package com.example.vehiclemanagement.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.vehiclemanagement.service.VehicleService;

@Service
public class VehicleConsumer {

    private final VehicleService vehicleService;

    public VehicleConsumer( VehicleService vehicleService ) {
        this.vehicleService = vehicleService;
    }

    @KafkaListener( topics = "vehicle-updates", groupId = "vehicle-group" )
    public void listenVehicleUpdates( String message ) {
        System.out.println( "Received Message: " + message );

        // For demonstration, we assume the message is the name of a new vehicle.
        // In a real application, you would likely deserialize a JSON message into a Vehicle object.
        com.example.vehiclemanagement.model.Vehicle newVehicle = new com.example.vehiclemanagement.model.Vehicle();
        newVehicle.setName( message );
        newVehicle.setType( "From Kafka" );
        newVehicle.setLocation( "Unknown" );

        vehicleService.createVehicle( newVehicle );
        System.out.println( "Successfully created a new vehicle from Kafka message: " + message );
    }
}
