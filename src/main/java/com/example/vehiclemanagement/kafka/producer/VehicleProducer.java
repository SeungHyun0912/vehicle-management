package com.example.vehiclemanagement.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VehicleProducer {

    private static final String TOPIC = "vehicle-updates";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public VehicleProducer( KafkaTemplate<String, String> kafkaTemplate ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage( String message ) {
        System.out.println( String.format( "Producing message -> %s", message ) );
        this.kafkaTemplate.send( TOPIC, message );
    }
}
