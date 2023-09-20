package com.github.zacharydhamilton.producers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Future;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.common.serialization.StringSerializer;

import com.github.zacharydhamilton.events.animals.Cat;
import com.github.zacharydhamilton.events.animals.Dog;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;

public class TopicNameStrategyProducer {
    private static ArrayList<String> REQUIRED_PROPS = new ArrayList<String>(Arrays.asList("BOOTSTRAP_SERVERS", "KAFKA_KEY", "KAFKA_SECRET", "SCHEMA_REGISTRY_URL", "SCHEMA_REGISTRY_KEY", "SCHEMA_REGISTRY_SECRET"));
    private static String CLIENT_ID = (System.getenv("CLIENT_ID") != null) ? System.getenv("CLIENT_ID") : "record-name-producer";
    private static String CONFIG_TYPE = (System.getenv("CONFIG_TYPE") != null) ? System.getenv("CONFIG_TYPE") : "FILE"; 
    private static String CONFIG_FILE = (System.getenv("CONFIG") != null) ? System.getenv("CONFIG_FILE") : "producer.properties";
    private static String TOPIC = "vehicles";
    public static void main(String[] args) throws ConfigException, IOException {
        KafkaProducer<String, GenericRecord> producer = new KafkaProducer<>(configure());
        for (int i=0; i<10; i++) {
            GenericRecord value = randomAnimal();
            ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>(TOPIC, UUID.randomUUID().toString(), value);
            Future<RecordMetadata> futureRecordMetadata = producer.send(record);
        }
    }
    private static Properties configure() throws ConfigException, IOException {
        Properties props = new Properties();
        if (CONFIG_TYPE.equals("FILE")) {
            ProducerUtils.addPropsFromFile(props, CONFIG_FILE);
        } else if (CONFIG_TYPE.equals("ENV")) {
            ProducerUtils.addPropsFromEnv(props, REQUIRED_PROPS);
        } else {
            throw new ConfigException(String.format("Unknown CONFIG_TYPE '%s'. Supported types are '[FILE, ENV]'", System.getenv("CONFIG_TYPE")));
        }
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(KafkaAvroSerializerConfig.AUTO_REGISTER_SCHEMAS, false);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, CLIENT_ID);
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 5);    
        props.put(KafkaAvroSerializerConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicNameStrategy.class.getName());
        ProducerUtils.preInitChecks(props, REQUIRED_PROPS);
        return props;
    }
    private static GenericRecord randomAnimal() {
        GenericRecord animal = null;
        if (Math.random() > 0.5) {
            animal = new Cat(Math.random() > 0.5 ? "siamese" : "hairless", Math.random() > 0.5 ? "tan" : "brown", Math.random() > 0.5 ? "mittens" : "kevin");
        } else {
            animal = new Dog(Math.random() > 0.5 ? "golden" : "lab", Math.random() > 0.5 ? "brown" : "black", Math.random() > 0.5 ? "spot" : "ralph");
        }
        return animal;
    }
}
