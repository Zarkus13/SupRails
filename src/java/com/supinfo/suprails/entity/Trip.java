package com.supinfo.suprails.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bargenson
 */
@Entity
@XmlRootElement
public class Trip implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable=false)
    private BigDecimal price;
    
    @ManyToOne @JoinColumn
    private TrainStation departureStation;
    
    @ManyToOne @JoinColumn
    private TrainStation arrivalStation;
    
    @OneToMany(mappedBy = "trip", cascade = CascadeType.REMOVE)
    private List<CustomerOrder> orders;

    
    public Trip() {
        
    }

    public Trip(TrainStation departureStation, TrainStation arrivalStation, BigDecimal price) {
        this.price = price;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TrainStation getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(TrainStation departureStation) {
        this.departureStation = departureStation;
    }

    public TrainStation getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(TrainStation arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    @XmlTransient
    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "com.supinfo.suprails.entity.Trip[ id=" + id + " ]";
    }

}
