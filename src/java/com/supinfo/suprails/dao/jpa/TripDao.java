/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.entity.Trip;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alexis
 */
@Local
public interface TripDao {
    public Trip addTrip(Trip trip);

    public List<Trip> getAllTrips();

    public Trip findTripById(Long tripId);

    public void removeTrip(Trip trip);
}
