package com.hatchways.flights.repository;

import com.hatchways.flights.model.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomFlightRepository {

    Flight findById(String id);
    Flight save(Flight flight);
    List<Flight> findByFlightDate(LocalDate date);
    List<Flight> findByPeriod(LocalDate startDate, LocalDate endDate);

}
