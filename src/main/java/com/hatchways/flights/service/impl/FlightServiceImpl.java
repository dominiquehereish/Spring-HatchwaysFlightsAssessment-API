package com.hatchways.flights.service.impl;

import com.hatchways.flights.model.Event;
import com.hatchways.flights.rest.request.RequestEvent;
import com.hatchways.flights.rest.response.Response;
import com.hatchways.flights.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    @Override
    public ResponseEntity<Response> processTicket(RequestEvent requestEvent) {
        Event event = requestEvent.getEvent();
        return null;
    }

    @Override
    public ResponseEntity<Response> getFlightsInfos(String startDate, String endDate) {
        return null;
    }
}
