package com.sabanciuniv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sabanciuniv.repo.*;


import com.sabanciuniv.model.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UcusController{

    @Autowired 
    private UcusRepository ucusRepo;

    @GetMapping("/flights")
    public ResponseEntity<List<Ucus>> getAllUcuss(@RequestParam(required = false) Havayolu airline){
         
        try{
            List<Ucus> ary = new ArrayList<Ucus>();

            if (airline == null){
                ucusRepo.findAll().forEach(ary::add);
            }
            else{
                ucusRepo.findByAirline(airline).forEach(ary::add);
            }
            if (ary.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(ary,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PostMapping("/flights")
    public ResponseEntity<Ucus> createUcus(@RequestBody Ucus ent) 
            {
        try {
            Ucus _ucus = ucusRepo.save(new Ucus(ent.getRoute(),ent.getAirline(),ent.getAvailableSeats(),ent.getTicketPrice()));
            return new ResponseEntity<>(_ucus,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<Ucus> getFlightByFlightNumber(@PathVariable("id")int flightNumber){
        Ucus data = ucusRepo.findByFlightNumber(flightNumber);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}