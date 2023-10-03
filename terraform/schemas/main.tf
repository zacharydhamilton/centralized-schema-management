data "confluent_environment" "main" {
    id = var.env_id
}
data "confluent_schema_registry_cluster" "main" {
    id = var.sr_cluster_id
    environment {
        id = data.confluent_environment.main.id
    }
}
# SCHEMAS
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
resource "confluent_schema" "topic_name_strategy_schemas" {
    for_each = toset(local.animal_schema_files)
    schema_registry_cluster {
        id = data.confluent_schema_registry_cluster.main.id 
    }
    rest_endpoint = data.confluent_schema_registry_cluster.main.rest_endpoint
    subject_name = "${lower(split(".", each.value)[0])}-value"
    format = "AVRO"
    schema = file("../schemas/animals/${each.value}")
    credentials {
        key = var.app_manager_sr_key
        secret = var.app_manager_sr_secret
    }
}
# TOPIC RECORD NAME STRATEGY
# --------------------
resource "confluent_schema" "topic_record_name_strategy_schemas" {
    for_each = toset(local.pizza_schema_files)
    schema_registry_cluster {
        id = data.confluent_schema_registry_cluster.main.id 
    }
    rest_endpoint = data.confluent_schema_registry_cluster.main.rest_endpoint
    subject_name = format("${local.pizza_topic_name}-%s.%s", local.fully_qualified_class_prefix, "${split(".", each.value)[0]}")
    format = "AVRO"
    schema = file("../schemas/pizza/${each.value}")
    credentials {
        key = var.app_manager_sr_key
        secret = var.app_manager_sr_secret
    }
}
# RECORD NAME STRATEGY
# --------------------
resource "confluent_schema" "record_name_strategy_scheams" {
    for_each = toset(local.vehicle_schema_files)
    schema_registry_cluster {
        id = data.confluent_schema_registry_cluster.main.id 
    }
    rest_endpoint = data.confluent_schema_registry_cluster.main.rest_endpoint
    subject_name = format("%s.%s", local.fully_qualified_class_prefix, "${split(".", each.value)[0]}")
    format = "AVRO"
    schema = file("../schemas/vehicles/${each.value}")
    credentials {
        key = var.app_manager_sr_key
        secret = var.app_manager_sr_secret
    }
}