package com.example.vehiclemanagement.service;

import com.example.vehiclemanagement.model.Vehicle;
import com.example.vehiclemanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles( ) {
        return vehicleRepository.findAll( );
    }

    public Optional<Vehicle> getVehicleById( Long id ) {
        return vehicleRepository.findById( id );
    }

    public Vehicle createVehicle( Vehicle vehicle ) {
        return vehicleRepository.save( vehicle );
    }

    public Vehicle updateVehicle( Long id, Vehicle vehicleDetails ) {
        Vehicle vehicle = vehicleRepository.findById( id )
                .orElseThrow( ( ) -> new RuntimeException( "Vehicle not found with id: " + id ) );

        vehicle.setName( vehicleDetails.getName( ) );
        vehicle.setType( vehicleDetails.getType( ) );
        vehicle.setLocation( vehicleDetails.getLocation( ) );

        return vehicleRepository.save( vehicle );
    }

    public void deleteVehicle( Long id ) {
        vehicleRepository.deleteById( id );
    }
}
