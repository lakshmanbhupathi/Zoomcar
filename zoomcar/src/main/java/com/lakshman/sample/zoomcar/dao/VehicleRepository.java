package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>,VehicleByTypeDao {
}
