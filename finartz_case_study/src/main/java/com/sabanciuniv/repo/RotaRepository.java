package com.sabanciuniv.repo;

import com.sabanciuniv.model.Havalimani;

import com.sabanciuniv.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RotaRepository extends JpaRepository<Rota,String> {
    
    Rota findByRouteID(int routeID);
    List<Rota> findAll();
    List<Rota> findByDepartureAirport(Havalimani departureAirport);
    
}
