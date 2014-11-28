package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bargenson
 */
@WebServlet(urlPatterns="/trips")
public class ListTripsServlet extends HttpServlet {

    @EJB
    private TripService tripService;
    
    @Resource(mappedName = "jms/SupRailsConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(mappedName = "queue/SupRails")
    private Destination destination;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            System.out.println("connectionFactory : " + connectionFactory);
            System.out.println("destination : " + destination);
            Connection cnt = connectionFactory.createConnection();
            Session session = cnt.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer producer = session.createProducer(destination);
            
            TextMessage msg = session.createTextMessage("PHILIPPE !");
            
            producer.send(msg);
            
            System.out.println("message sent !");
            
            cnt.close();
        }
        catch (Exception e) {
            System.out.println("Error during message sending : " + e.getMessage());
        }
        
        List<Trip> trips = tripService.getAllTrips();
        req.setAttribute("trips", trips);
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }

}
