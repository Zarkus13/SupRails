/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.rest;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.service.TrainStationService;
import java.net.URI;
import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author alexis
 */
@Path("/stations")
public class TrainStationsAPI {
    
    @EJB
    private TrainStationService trainStationService;
    
    @POST
    public Response addTrainStation(TrainStation trainStation) {
        trainStationService.addTrainStation(trainStation);
        
        return Response.created(URI.create("/SupRails/rest/stations/" + trainStation.getId())).build();
    }
    
}
