package com.supinfo.suprails.service;

import com.supinfo.suprails.dao.jpa.TripDao;
import com.supinfo.suprails.entity.Trip;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author bargenson
 */
@Stateless
public class TripService implements Serializable {
    
    @EJB
    private TripDao tripDao;
    
    
    public Trip addTrip(Trip trip) {
        return tripDao.addTrip(trip);
    }
    
    public List<Trip> getAllTrips() {
        return tripDao.getAllTrips();
    }

    public void removeTrip(Long tripId) {
        tripDao.removeTrip(findTripById(tripId));
    }
    
    public Trip findTripById(Long tripId) {
        return tripDao.findTripById(tripId);
    }

}
