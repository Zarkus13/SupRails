package com.supinfo.suprails.dao.jpa.impl;

import com.supinfo.suprails.dao.jpa.TrainStationDao;
import com.supinfo.suprails.entity.TrainStation;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bargenson
 */
@Stateless
public class JpaTrainStationDao implements TrainStationDao, Serializable {

    @PersistenceContext
    private EntityManager em;
    
    
    public TrainStation addTrainStation(TrainStation station) {
        em.persist(station);
        return station;
    }

    public List<TrainStation> getAllTrainStations() {
        
        return em.createQuery("SELECT ts FROM TrainStation ts").getResultList();
    }

    public TrainStation findTrainStationById(Long departureId) {
        return em.find(TrainStation.class, departureId);
    }
    
}
