package com.sabanciuniv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="UCUS")
@Entity
public class Ucus {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int flightNumber;
    
    @ManyToOne
    @JoinColumn(name = "routeID")
    private Rota route;

    @OneToOne
    @JoinColumn(name = "airlineCode")
    private Havayolu airline;

    @Column(nullable = false, length = 128)
    private int availableSeats;
    @Column(nullable = false, length = 128)
    private double ticketPrice;

    public Ucus(){

    }

    public Ucus(Rota route, Havayolu airline, int availableSeats, double ticketPrice) {
        this.route = route;
        this.airline = airline;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }
    
    public int getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    public Rota getRoute() {
        return route;
    }
    public void setRoute(Rota route) {
        this.route = route;
    }
    public Havayolu getAirline() {
        return airline;
    }
    public void setAirline(Havayolu airline) {
        this.airline = airline;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    
}