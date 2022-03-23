package com.hatchways.flights.service;

import com.hatchways.flights.rest.request.RequestEvent;
import com.hatchways.flights.rest.response.Response;
import org.springframework.http.ResponseEntity;

public interface FlightService {

    public ResponseEntity<Response> processTicket(RequestEvent requestEvent);
    public ResponseEntity<Response> getFlightsInfos(String startDate, String endDate);

}
