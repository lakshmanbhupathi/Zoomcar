package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.User;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import com.lakshman.sample.zoomcar.enums.VehicleType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VehicleByTypeDaoImpl implements VehicleByTypeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Vehicle> getVehiclesByType(VehicleType vehicleType) {
        Query query = entityManager.createQuery("SELECT v FROM Vehicle v WHERE v.vehicleType = :vehicleType");

        query.setParameter("vehicleType",vehicleType);
        return query.getResultList();
    }
}
