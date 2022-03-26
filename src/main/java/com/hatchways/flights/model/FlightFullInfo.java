package com.hatchways.flights.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FlightFullInfo {

    private LocalDate date;
    private List<FlightInfo> flights = new ArrayList<>();

}
