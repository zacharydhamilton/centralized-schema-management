# PROVIDERS
# --------------------
terraform {
    required_providers {
        aws = {
            source  = "hashicorp/aws"
            version = "4.51"
        }
        confluent = {
            source = "confluentinc/confluent"
            version = "1.51.0"
        }
    }
}
# RANDOM IDS
# --------------------
resource "random_id" "confluent" {
    byte_length = 4
} 
# VARS
# --------------------
variable "aws_region" {
    type = string
    default = "us-east-2"
}
# FILE OUTPUTS
# --------------------
resource "local_file" "producer_properties" {
    filename = "../centralized-schema-management/producer.properties"
    content = <<-EOF
    ## Confluent Cloud Cluster
    bootstrap.servers=${substr(confluent_kafka_cluster.main.bootstrap_endpoint,11,-1)}
    security.protocol=SASL_SSL
    sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule   required username='${confluent_api_key.producers_kafka.id}'   password='${confluent_api_key.producers_kafka.secret}';
    sasl.mechanism=PLAIN
    # Confluent Cloud Schema Registry
    schema.registry.url=${confluent_schema_registry_cluster.main.rest_endpoint}
    basic.auth.credentials.source=USER_INFO
    basic.auth.user.info=${confluent_api_key.producers_sr.id}:${confluent_api_key.producers_sr.secret}
    # Required for correctness in Apache Kafka clients prior to 2.6
    client.dns.lookup=use_all_dns_ips
    # Best practice for higher availability in Apache Kafka clients prior to 3.0
    session.timeout.ms=45000
    EOF
}