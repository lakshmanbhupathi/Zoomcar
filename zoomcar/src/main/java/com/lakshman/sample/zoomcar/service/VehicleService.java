package com.lakshman.sample.zoomcar.service;

import com.lakshman.sample.zoomcar.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    List<Vehicle> getVehiclesByType(String vehicleType);
}
