package com.sabanciuniv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="HAVAYOLU")
@Entity
public class Havayolu{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int airlineCode;
    @Column(nullable=false ,length=128)
    private String airlineName;

    public Havayolu(){


    }
    
    public Havayolu(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(int airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

}