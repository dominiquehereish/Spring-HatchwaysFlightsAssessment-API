package com.hatchways.flights.repository.impl;

import com.hatchways.flights.model.Flight;
import com.hatchways.flights.repository.CustomFlightRepository;
import com.hatchways.flights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomFlightRepositoryImpl implements CustomFlightRepository {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight findById(String id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isPresent())
            return flight.get();
        return null;
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }


    @Override
    public List<Flight> findByFlightDate(LocalDate date) {
        return flightRepository.findByFlightDate(date);
    }

    @Override
    public List<Flight> findByPeriod(LocalDate startDate, LocalDate endDate) {
        return null;
    }
}
