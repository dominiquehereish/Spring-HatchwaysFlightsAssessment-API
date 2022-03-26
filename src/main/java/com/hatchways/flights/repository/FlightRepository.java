package com.hatchways.flights.repository;

import com.hatchways.flights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String>{

    List<Flight> findByFlightDate(LocalDate date);
}
