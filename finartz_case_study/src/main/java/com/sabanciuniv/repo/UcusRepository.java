package com.sabanciuniv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabanciuniv.model.Havayolu;
import com.sabanciuniv.model.Ucus;
import java.util.List;

@Repository
public interface UcusRepository extends JpaRepository<Ucus,String> {
    Ucus findByFlightNumber(int flightNumber);
    List<Ucus> findAll();
    List<Ucus> findByAirline(Havayolu airline);
}

