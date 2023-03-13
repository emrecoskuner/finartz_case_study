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


class RouteRequest {
    private Havalimani arrivalAirport;
    private Havalimani departureAirport;
    public RouteRequest(Havalimani arrivalAirport, Havalimani departureAirport) {
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }
    public RouteRequest() {
        
        
    }
    public Havalimani getarrivalAirport() {
        return arrivalAirport;
    }
    public void setarrivalAirport(Havalimani arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
    public Havalimani getdepartureAirport() {
        return departureAirport;
    }
    public void setdepartureAirport(Havalimani departureAirport) {
        this.departureAirport = departureAirport;
    }

}


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RotaController {

    @Autowired 
    private RotaRepository rotaRepo;

    @Autowired
    private HavalimaniRepository havalimaniRepo;

    

    @GetMapping("/routes")
    public ResponseEntity<List<Rota>> getAllRotas(@RequestParam(required = false) Havalimani departureAirport){
         
        try{
            List<Rota> ary = new ArrayList<Rota>();
            rotaRepo.findAll().forEach(ary::add);
            // if (departureAirport == null){
            //     rotaRepo.findAll().forEach(ary::add);
            // }
            // else{
            //     rotaRepo.findByDepartureAirport(departureAirport).forEach(ary::add);
            // }
            // if (ary.isEmpty()) {
            //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // }

            return new ResponseEntity<>(ary,HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/routes/{routeid}")
    public ResponseEntity<Rota> getRouteByID(@PathVariable("routeid") int id) {
        Rota data = rotaRepo.findByRouteID(id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/routes")
    public ResponseEntity<Rota> createRota(@RequestBody RouteRequest ent) 
            {
        try {
            Havalimani arrivalAirport = havalimaniRepo.findByAirportCode(ent.getarrivalAirport().getAirportCode());
            Havalimani departureAirport = havalimaniRepo.findByAirportCode(ent.getdepartureAirport().getAirportCode());
            Rota test = new Rota(departureAirport, arrivalAirport);
            Rota _rota = rotaRepo.save(test);
            return new ResponseEntity<>(_rota,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
