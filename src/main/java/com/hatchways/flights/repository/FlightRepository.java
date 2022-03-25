package com.hatchways.flights.repository;

import com.hatchways.flights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, String> {
}
