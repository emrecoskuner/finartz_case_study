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

public class HavayoluController {
    @Autowired 
    private HavayoluRepository havayoluRepo;

    @GetMapping("/airlines")
    public ResponseEntity<List<Havayolu>> getAllHavayolus(@RequestParam(required = false) String name){
         
        try{
            List<Havayolu> arry = new ArrayList<Havayolu>();

            if (name == null){
                havayoluRepo.findAll().forEach(arry::add);
            }
            else{
                havayoluRepo.findByAirlineName(name).forEach(arry::add);
            }
            if (arry.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(arry,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<Havayolu> getAirlinetByID(@PathVariable("id") int id) {
        Havayolu data = havayoluRepo.findByAirlineCode(id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/airlines")
    public ResponseEntity<Havayolu> createHavayolu(@RequestBody Havayolu ent) 
            {
        try {
            Havayolu _havayolu = havayoluRepo.save(new Havayolu(ent.getAirlineName()));
            return new ResponseEntity<>(_havayolu,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
