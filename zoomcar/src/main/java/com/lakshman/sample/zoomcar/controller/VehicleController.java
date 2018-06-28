package com.lakshman.sample.zoomcar.controller;

import com.lakshman.sample.zoomcar.dao.VehicleRepository;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import com.lakshman.sample.zoomcar.enums.VehicleType;
import com.lakshman.sample.zoomcar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    private VehicleService vehicleService;

    /**
     * testing purpose
     * @return
     */
    @PostMapping("/addVehicles")
    public boolean addVehicles(){
        vehicleRepository.save(new Vehicle("1234",VehicleType.SEDAN));
        vehicleRepository.save(new Vehicle("5677",VehicleType.SEDAN));
        vehicleRepository.save(new Vehicle("6567",VehicleType.HATCHBACK));
        vehicleRepository.save(new Vehicle("7567",VehicleType.COUPE));

        return true;
    }

    @GetMapping("/getAll")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/byType/{vehicleType}")
    public List<Vehicle> getVehiclesByType(@PathVariable final String vehicleType){
        return vehicleService.getVehiclesByType(vehicleType);
    }


}
