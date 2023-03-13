package com.sabanciuniv.repo;
import com.sabanciuniv.model.Havalimani;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HavalimaniRepository extends JpaRepository<Havalimani,String> {
    Havalimani findByAirportCode(int airportCode);
    List<Havalimani> findAll();
    List<Havalimani> findByAirportCountry(String airportCountry);
}

