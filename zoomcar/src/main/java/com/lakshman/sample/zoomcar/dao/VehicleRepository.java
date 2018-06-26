package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
