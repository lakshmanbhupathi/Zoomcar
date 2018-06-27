package com.lakshman.sample.zoomcar.dao;

import com.lakshman.sample.zoomcar.entity.Booking;
import com.lakshman.sample.zoomcar.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookingPastHistoryImpl implements BookingPastHistory {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> getPastHistoryByUser(User user) {
        Query query = entityManager.createQuery("SELECT b FROM Booking b WHERE b.user = :userId");

        query.setParameter("userId",user);
        return query.getResultList();
    }
}
