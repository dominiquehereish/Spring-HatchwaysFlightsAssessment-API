package com.hatchways.flights.rest.response;

import com.hatchways.flights.model.FlightFullInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FlightsResponse extends Response{

    private List<FlightFullInfo> dates = new ArrayList<>();

    public void addToDates(FlightFullInfo flightFullInfo){
        this.dates.add(flightFullInfo);
    }
}
