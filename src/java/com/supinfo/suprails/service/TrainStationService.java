package com.supinfo.suprails.service;

import com.supinfo.suprails.dao.jpa.TrainStationDao;
import com.supinfo.suprails.entity.TrainStation;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author bargenson
 */
@Stateless
public class TrainStationService implements Serializable {

    @EJB
    private TrainStationDao trainStationDao;
    
    
    public void addTrainStation(TrainStation station) {
        trainStationDao.addTrainStation(station);
    }

    public List<TrainStation> getAllTrainStations() {
        return trainStationDao.getAllTrainStations();
    }

    public TrainStation findTrainStationById(Long departureId) {
        return trainStationDao.findTrainStationById(departureId);
    }
    
}
