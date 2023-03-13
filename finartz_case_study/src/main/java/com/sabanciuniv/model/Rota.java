package com.sabanciuniv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.*;


@Entity
@Table(name="ROTA")
public class Rota {
    
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    
    private int routeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departureAirport", referencedColumnName = "airportCode", nullable = true, insertable = false, updatable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Havalimani departureAirport;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrivalAirport", referencedColumnName = "airportCode",nullable = true, insertable = false, updatable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Havalimani arrivalAirport;
    //@Column(nullable = false, length = 128)
    // @ManyToOne
    // @JoinColumn(name = "airline", referencedColumnName = "airlineCode")
    // private Havayolu airline;

    
    public  Rota(){

    }
    
    public Rota(Havalimani departureAirport, Havalimani arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        // this.airline = airline;
    }
    public int getRouteID() {
        return routeID;
    }
    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }
    public Havalimani getDepartureAirport() {
        return departureAirport;
    }
    public void setDepartureAirport(Havalimani departureAirport) {
        this.departureAirport = departureAirport;
    }
    public Havalimani getArrivalAirport() {
        return arrivalAirport;
    }
    public void setArrivalAirport(Havalimani arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
    // public Havayolu getAirline() {
    //     return airline;
    // }
    // public void setAirline(Havayolu airline) {
    //     this.airline = airline;
    // }

    @Override
    public String toString() {
        return "Rota [routeID=" + routeID + ", departureAirport=" + departureAirport + ", arrivalAirport="
                + arrivalAirport + "]";
    }

}