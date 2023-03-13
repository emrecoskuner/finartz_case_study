package com.sabanciuniv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="HAVALIMANI")
@Entity
public class Havalimani {

    @Column(name="airportCode") @Id @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int airportCode;

    @Column(nullable=false ,length=128, name="airportName")
    private String airportName;
    @Column(nullable = false, length = 128, name="airportCountry")
    private String airportCountry;

    public Havalimani(){

    }

    public Havalimani(String airportName, String airportCountry) {
        this.airportName = airportName;
        this.airportCountry = airportCountry;
    }

    public String getAirportCountry() {
        return airportCountry;
    }
    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }
    public String getAirportName() {
        return airportName;
    }
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getAirportCode() {
        return airportCode;
    }

    @Override
    public String toString() {
        return "Havalimani [airportCode=" + airportCode + ", airportName=" + airportName + ", airportCountry="
                + airportCountry + "]";
    }


}