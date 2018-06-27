package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookingByVehicleImpl implements BookingByVehicle {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> getBookingsByVehicle(Vehicle vehicle) {
        Query query = entityManager.createQuery("SELECT b FROM Booking b WHERE b.vehicle = :vehicle");

        query.setParameter("vehicle", vehicle);
        return query.getResultList();
    }
}
