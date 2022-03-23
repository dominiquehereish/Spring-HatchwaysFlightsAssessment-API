package com.hatchways.flights.rest;


import com.hatchways.flights.rest.request.RequestEvent;
import com.hatchways.flights.rest.response.Response;
import com.hatchways.flights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class HatchwaysFlightRest {

    @Autowired
    FlightService flightService;

    @PostMapping("/tickets")
    public ResponseEntity<Response> processTicket(@Valid @RequestBody RequestEvent requestEvent){
        return flightService.processTicket(requestEvent);
    }

    @GetMapping("/flights")
    public ResponseEntity<Response> getFlightsInfos(@RequestParam(required = false) String startDate,
                                                    @RequestParam(required = false) String endDate){
        return null;
    }
}
