package com.example.vehiclemanagement.controller;

import com.example.vehiclemanagement.kafka.producer.VehicleProducer;
import com.example.vehiclemanagement.model.Vehicle;
import com.example.vehiclemanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/vehicles" )
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleProducer vehicleProducer;

    @GetMapping
    public List<Vehicle> getAllVehicles( ) {
        return vehicleService.getAllVehicles( );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Vehicle> getVehicleById( @PathVariable Long id ) {
        return vehicleService.getVehicleById( id )
                .map( ResponseEntity::ok )
                .orElse( ResponseEntity.notFound( ).build( ) );
    }

    @PostMapping
    public Vehicle createVehicle( @RequestBody Vehicle vehicle ) {
        return vehicleService.createVehicle( vehicle );
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Vehicle> updateVehicle( @PathVariable Long id, @RequestBody Vehicle vehicleDetails ) {
        try {
            Vehicle updatedVehicle = vehicleService.updateVehicle( id, vehicleDetails );
            return ResponseEntity.ok( updatedVehicle );
        } catch ( RuntimeException e ) {
            return ResponseEntity.notFound( ).build( );
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Void> deleteVehicle( @PathVariable Long id ) {
        vehicleService.deleteVehicle( id );
        return ResponseEntity.noContent( ).build( );
    }

    @PostMapping( "/publish" )
    public void sendMessageToKafkaTopic( @RequestParam( "message" ) String message ) {
        this.vehicleProducer.sendMessage( message );
    }
}
