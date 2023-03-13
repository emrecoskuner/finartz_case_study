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
public class HavalimaniController {
    @Autowired 
    private HavalimaniRepository havalimaniRepo;

    @GetMapping("/airports")
    public ResponseEntity<List<Havalimani>> getAllHavalimanis(@RequestParam(required = false) String country){
         
        try{
            List<Havalimani> ary = new ArrayList<Havalimani>();

            if (country == null){
                havalimaniRepo.findAll().forEach(ary::add);
            }
            else{
                havalimaniRepo.findByAirportCountry(country).forEach(ary::add);
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

    @GetMapping("/airport/{id}")
    public ResponseEntity<Havalimani> getAirportByID(@PathVariable("id") int id) {
        Havalimani data = havalimaniRepo.findByAirportCode(id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/airports")
    public ResponseEntity<Havalimani> createHavalimani(@RequestBody Havalimani ent) 
            {
        try {
            Havalimani _havalimani = havalimaniRepo.save(new Havalimani(ent.getAirportName(), ent.getAirportCountry()));
            return new ResponseEntity<>(_havalimani,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

