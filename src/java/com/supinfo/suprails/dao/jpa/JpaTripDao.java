package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.entity.Trip;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bargenson
 */
@Stateless
public class JpaTripDao {

    @PersistenceContext
    private EntityManager em;

    
    public Trip addTrip(Trip trip) {
        em.persist(trip);
        return trip;
    }

    public List<Trip> getAllTrips() {
        return em.createQuery("SELECT t FROM Trip t").getResultList();
    }

    public Trip findTripById(Long tripId) {
        return em.find(Trip.class, tripId);
    }

    public void removeTrip(Trip trip) {
        em.remove(trip);
    }
    
}
