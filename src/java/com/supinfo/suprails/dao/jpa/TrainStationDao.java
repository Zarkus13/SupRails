/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.entity.TrainStation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alexis
 */
@Local
public interface TrainStationDao {
    
    public TrainStation addTrainStation(TrainStation station);

    public List<TrainStation> getAllTrainStations();

    public TrainStation findTrainStationById(Long departureId);
}
