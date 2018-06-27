package com.lakshman.sample.zoomcar.service;

import com.lakshman.sample.zoomcar.dao.VehicleRepository;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import com.lakshman.sample.zoomcar.enums.VehicleType;
import com.lakshman.sample.zoomcar.exceptions.ContentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return vehicleRepository.getVehiclesByType(VehicleType.valueOf(vehicleType));
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        Vehicle vehicle;
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
        if (vehicleOptional.isPresent()) {
            vehicle = vehicleOptional.get();
        } else {
            throw new ContentNotFoundException("Vehicle not found");
        }

        return vehicle;
    }
}
