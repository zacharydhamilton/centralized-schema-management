package com.github.zacharydhamilton.kafka.schemaregistry.management.centralized;

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

import com.github.zacharydhamilton.events.pizza.PizzaDough;
import com.github.zacharydhamilton.events.pizza.PizzaSauce;
import com.github.zacharydhamilton.events.pizza.PizzaTopping;
import com.github.zacharydhamilton.kafka.common.Utils;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;

public class TopicRecordNameStrategyProducer {
    private static ArrayList<String> REQUIRED_PROPS = new ArrayList<String>(Arrays.asList("BOOTSTRAP_SERVERS", "KAFKA_KEY", "KAFKA_SECRET", "SCHEMA_REGISTRY_URL", "SCHEMA_REGISTRY_KEY", "SCHEMA_REGISTRY_SECRET"));
    private static String CLIENT_ID = (System.getenv("CLIENT_ID") != null) ? System.getenv("CLIENT_ID") : "record-name-producer";
    private static String CONFIG_TYPE = (System.getenv("CONFIG_TYPE") != null) ? System.getenv("CONFIG_TYPE") : "FILE"; 
    private static String CONFIG_FILE = (System.getenv("CONFIG") != null) ? System.getenv("CONFIG_FILE") : "producer.properties";
    private static String TOPIC = "pizza-ingredients";
    public static void main(String[] args) throws ConfigException, IOException {
        KafkaProducer<String, GenericRecord> producer = new KafkaProducer<>(configure());
        for (int i=0; i<10; i++) {
            ArrayList<GenericRecord> values = randomPizza();
            for (GenericRecord value : values) {
                ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>(TOPIC, UUID.randomUUID().toString(), value);
                Future<RecordMetadata> futureRecordMetadata = producer.send(record);
            }
        }
    }
    private static Properties configure() throws ConfigException, IOException {
        Properties props = new Properties();
        if (CONFIG_TYPE.equals("FILE")) {
            Utils.addPropsFromFile(props, CONFIG_FILE);
        } else if (CONFIG_TYPE.equals("ENV")) {
            Utils.addPropsFromEnv(props, REQUIRED_PROPS);
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
        props.put(KafkaAvroSerializerConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicRecordNameStrategy.class.getName());
        Utils.preInitChecks(props, REQUIRED_PROPS);
        return props;
    }
    private static ArrayList<GenericRecord> randomPizza() {
        ArrayList<GenericRecord> ingredients = new ArrayList<>();
        String pizza = UUID.randomUUID().toString();
        ingredients.add(new PizzaDough(pizza, "dough", "normal", Math.random() > 0.5 ? "12" : "16"));
        ingredients.add(new PizzaSauce(pizza, "sauce", Math.random() > 0.5 ? "red" : "white", Math.random() > 0.5 ? "normal" : "extra"));
        if (Math.random() > 0.5) {
            ingredients.add(new PizzaTopping(pizza, "topping", "cheese", Math.random() > 0.5 ? "normal" : "extra", "full"));
        } else {
            ingredients.add(new PizzaTopping(pizza, "topping", "cheese", Math.random() > 0.5 ? "normal" : "extra", "full"));
            ingredients.add(new PizzaTopping(pizza, "topping", "pepperoni", Math.random() > 0.5 ? "normal" : "extra", Math.random() > 0.5 ? "half" : "full"));
        }
        return ingredients;
    }
}
