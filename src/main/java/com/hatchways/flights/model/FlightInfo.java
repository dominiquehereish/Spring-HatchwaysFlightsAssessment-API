package com.hatchways.flights.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FlightInfo {

    private String FlightNumber;
    private int revenue;
    private List<String> occupiedSeats = new ArrayList<>();

}
