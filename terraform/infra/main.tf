# RANDOM IDS
# --------------------
resource "random_id" "confluent" {
    byte_length = 4
} 
# ENV
# --------------------
resource "confluent_environment" "main" {
    display_name = var.environment_name
}
# TF MANAGER
# --------------------
resource "confluent_service_account" "app_manager" {
    display_name = "app-manager-${random_id.confluent.hex}"
    description = "app-manager for '${confluent_environment.main.display_name}'"
}
resource "confluent_role_binding" "app_manager_env_admin" {
    principal = "User:${confluent_service_account.app_manager.id}"
    role_name = "EnvironmentAdmin"
    crn_pattern = confluent_environment.main.resource_name
}
resource "confluent_api_key" "app_manager_sr" {
    display_name = "app-manager-sr-${random_id.confluent.hex}"
    description = "app-manager-sr-${random_id.confluent.hex}"
    owner {
        id = confluent_service_account.app_manager.id
        api_version = confluent_service_account.app_manager.api_version
        kind = confluent_service_account.app_manager.kind
    }
    managed_resource {
        id = confluent_schema_registry_cluster.main.id
        api_version = confluent_schema_registry_cluster.main.api_version
        kind = confluent_schema_registry_cluster.main.kind
        environment {
            id = confluent_environment.main.id
        }
    }
    depends_on = [
        confluent_service_account.app_manager,
        confluent_role_binding.app_manager_env_admin
    ]
}
resource "confluent_api_key" "app_manager_kafka" {
    display_name = "app-manager-kafka-${random_id.confluent.hex}"
    description = "app-manager-kafka-${random_id.confluent.hex}"
    owner {
        id = confluent_service_account.app_manager.id
        api_version = confluent_service_account.app_manager.api_version
        kind = confluent_service_account.app_manager.kind
    }
    managed_resource {
        id = confluent_kafka_cluster.main.id
        api_version = confluent_kafka_cluster.main.api_version
        kind = confluent_kafka_cluster.main.kind
        environment {
            id = confluent_environment.main.id
        }
    }
    depends_on = [
        confluent_service_account.app_manager,
        confluent_role_binding.app_manager_env_admin
    ]
}
# SCHEMA REGISTRY
# --------------------
data "confluent_schema_registry_region" "main" {
    cloud = "AWS"
    region = var.aws_region
    package = "ADVANCED"
}
resource "confluent_schema_registry_cluster" "main" {
    package = data.confluent_schema_registry_region.main.package
    environment {
        id = confluent_environment.main.id
    }
    region {
        id = data.confluent_schema_registry_region.main.id
    }
}
resource "confluent_schema_registry_cluster_config" "main" {
    schema_registry_cluster {
        id = confluent_schema_registry_cluster.main.id 
    }
    rest_endpoint = confluent_schema_registry_cluster.main.rest_endpoint
    compatibility_level = "FORWARD"
    credentials {
        key = confluent_api_key.app_manager_sr.id
        secret = confluent_api_key.app_manager_sr.secret
    }
}
resource "confluent_schema_registry_cluster_mode" "main" {
    schema_registry_cluster {
        id = confluent_schema_registry_cluster.main.id
    }
    rest_endpoint = confluent_schema_registry_cluster.main.rest_endpoint
    mode = "READWRITE"
    credentials {
        key = confluent_api_key.app_manager_sr.id 
        secret = confluent_api_key.app_manager_sr.secret
    }
}
# KAFKA
# --------------------
resource "confluent_kafka_cluster" "main" {
    display_name = "kafka-cluster-${random_id.confluent.hex}"
    availability = "SINGLE_ZONE"
    cloud = "AWS"
    region = var.aws_region
    basic {}
    environment {
        id = confluent_environment.main.id 
    }
}
# PRODUCERS
# --------------------
resource "confluent_service_account" "producers" {
    display_name = "producers-${random_id.confluent.hex}"
    description = "service account for producers"
}
resource "confluent_role_binding" "producers_sr" {
    principal = "User:${confluent_service_account.producers.id}"
    role_name = "ResourceOwner"
    crn_pattern = format("%s/%s", confluent_schema_registry_cluster.main.resource_name, "subject=*")
}
resource "confluent_role_binding" "producers_kafka" {
    principal = "User:${confluent_service_account.producers.id}"
    role_name = "CloudClusterAdmin"
    crn_pattern = confluent_kafka_cluster.main.rbac_crn
}
resource "confluent_api_key" "producers_sr" {
    display_name = "producers-sr-${random_id.confluent.hex}"
    description = "producers-sr-${random_id.confluent.hex}"
    owner {
        id = confluent_service_account.producers.id
        api_version = confluent_service_account.producers.api_version
        kind = confluent_service_account.producers.kind
    }
    managed_resource {
        id = confluent_schema_registry_cluster.main.id 
        api_version = confluent_schema_registry_cluster.main.api_version
        kind = confluent_schema_registry_cluster.main.kind
        environment {
            id = confluent_environment.main.id 
        }
    }
    depends_on = [
        confluent_role_binding.producers_sr
    ]
}
resource "confluent_api_key" "producers_kafka" {
    display_name = "producers-kafka-${random_id.confluent.hex}"
    description = "producers-kafka-${random_id.confluent.hex}"
    owner {
        id = confluent_service_account.producers.id
        api_version = confluent_service_account.producers.api_version
        kind = confluent_service_account.producers.kind
    }
    managed_resource {
        id = confluent_kafka_cluster.main.id
        api_version = confluent_kafka_cluster.main.api_version
        kind = confluent_kafka_cluster.main.kind
        environment {
            id = confluent_environment.main.id 
        }
    }
    depends_on = [
        confluent_role_binding.producers_kafka
    ]
}
# TOPICS
# --------------------
locals {
    // Could jsondecode the schema file and use the namespace
    fully_qualified_class_prefix = "com.github.zacharydhamilton.events"

    animal_schema_files = fileset("../../schemas/animals", "*.avsc")
    animal_topic_names = [for s in local.animal_schema_files : lower(split(".", s)[0])]

    pizza_schema_files = fileset("../../schemas/pizza", "*.avsc")
    pizza_topic_name = "pizza-ingredients"

    vehicle_schema_files = fileset("../../schemas/vehicles", "*.avsc")
    vehicle_topic_name = "vehicles"
}
# TOPIC NAME STRATEGY
# --------------------
resource "confluent_kafka_topic" "topic_name_strategy_topics" {
    for_each = toset(local.animal_topic_names)
    topic_name = each.value
    rest_endpoint = confluent_kafka_cluster.main.rest_endpoint
    partitions_count = 1
    kafka_cluster {
        id = confluent_kafka_cluster.main.id
    }
    credentials {
        key = confluent_api_key.app_manager_kafka.id
        secret = confluent_api_key.app_manager_kafka.secret
    }
}
# TOPIC RECORD NAME STRATEGY
# --------------------
resource "confluent_kafka_topic" "topic_record_name_strategy_topics" {
    topic_name = local.pizza_topic_name
    rest_endpoint = confluent_kafka_cluster.main.rest_endpoint
    partitions_count = 1
    kafka_cluster {
        id = confluent_kafka_cluster.main.id
    }
    credentials {
        key = confluent_api_key.app_manager_kafka.id
        secret = confluent_api_key.app_manager_kafka.secret
    }
}
# RECORD NAME STRATEGY
# --------------------
resource "confluent_kafka_topic" "record_name_strategy_topics" {
    topic_name = local.vehicle_topic_name
    rest_endpoint = confluent_kafka_cluster.main.rest_endpoint
    partitions_count = 1
    kafka_cluster {
        id = confluent_kafka_cluster.main.id
    }
    credentials {
        key = confluent_api_key.app_manager_kafka.id
        secret = confluent_api_key.app_manager_kafka.secret
    }
}