package com.lakshman.sample.zoomcar.controller;

import com.lakshman.sample.zoomcar.dao.VehicleRepository;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @PostMapping("/addVehicles")
    public boolean addVehicles(){
        vehicleRepository.save(new Vehicle("1234"));
        vehicleRepository.save(new Vehicle("5677"));
        vehicleRepository.save(new Vehicle("6567"));
        vehicleRepository.save(new Vehicle("7567"));

        return true;
    }

}
