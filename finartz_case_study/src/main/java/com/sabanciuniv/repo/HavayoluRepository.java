package com.sabanciuniv.repo;
import com.sabanciuniv.model.Havayolu;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HavayoluRepository extends JpaRepository<Havayolu,String>{
    Havayolu findByAirlineCode(int airlineCode);
    List<Havayolu> findAll();
    List<Havayolu> findByAirlineName(String airportName);


}