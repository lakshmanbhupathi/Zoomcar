package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Vehicle;
import com.lakshman.sample.zoomcar.enums.VehicleType;

import java.util.List;

public interface VehicleByTypeDao {

    List<Vehicle> getVehiclesByType(VehicleType vehicleType);
}
