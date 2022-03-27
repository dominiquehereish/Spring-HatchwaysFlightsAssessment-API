package com.hatchways.flights.service.impl;

import com.hatchways.flights.model.*;
import com.hatchways.flights.repository.CustomFlightRepository;
import com.hatchways.flights.repository.TicketRepository;
import com.hatchways.flights.rest.request.RequestEvent;
import com.hatchways.flights.rest.response.ErrorResponse;
import com.hatchways.flights.rest.response.FlightsResponse;
import com.hatchways.flights.rest.response.Response;
import com.hatchways.flights.rest.response.TicketResponse;
import com.hatchways.flights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.hatchways.flights.service.ValidationUtility.isEmptyDate;
import static com.hatchways.flights.service.ValidationUtility.isValidDate;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private CustomFlightRepository customFlightRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public ResponseEntity<Response> processTicket(RequestEvent requestEvent) {
        Event event = requestEvent.getEvent();
        if(isEmptyDate(event.getFlightDate()) || !isValidDate(event.getFlightDate()))
            return ResponseEntity.badRequest().body(new ErrorResponse("date provided is invalid"));
        if(ticketRepository.findById(event.getTicketId()).isPresent())
            return ResponseEntity.badRequest().body(new ErrorResponse("ticketIdAlready exists"));

        Ticket ticket = new Ticket(event.getTicketId(),event.getSeatNumber(), event.getTicketCost());
        Flight flight = customFlightRepository.findById(event.getFlightNumber());
        if(null == flight){
            flight = new Flight(event.getFlightNumber(), LocalDate.parse(event.getFlightDate()), ticket);
        }else{
            for(Ticket t : flight.getTickets()){
                if(t.getSeatNumber().equals(ticket.getSeatNumber()))
                    return ResponseEntity.badRequest().body(new ErrorResponse("seatNumber already taken"));
            }
            flight.addTicketToFlight(ticket);
            if(!flight.getFlightDate().isEqual(LocalDate.parse(event.getFlightDate())))
                flight.setFlightDate(LocalDate.parse(event.getFlightDate()));
        }
        customFlightRepository.save(flight);

        return ResponseEntity.ok().body(new TicketResponse());
    }

    @Override
    public ResponseEntity<Response> getFlightsInfos(String startDate, String endDate) {
        if(isEmptyDate(startDate))
            return ResponseEntity.badRequest().body(new ErrorResponse("startDate is empty"));
        if(isEmptyDate(endDate))
            return ResponseEntity.badRequest().body(new ErrorResponse("endDate is empty"));
        if(!isValidDate(startDate))
            return ResponseEntity.badRequest().body(new ErrorResponse("startDate is invalid"));
        if(!isValidDate(endDate))
            return ResponseEntity.badRequest().body(new ErrorResponse("endDate is invalid"));
        if(LocalDate.parse(endDate).isBefore(LocalDate.parse(startDate)))
            return ResponseEntity.badRequest().body(new ErrorResponse("endDate can not be before startDate"));

        FlightsResponse flightsResponse = new FlightsResponse();
        LocalDate.parse(startDate).datesUntil(LocalDate.parse(endDate)).forEach(d -> {
            FlightInfo flightInfo = new FlightInfo();
            FlightFullInfo flightFullInfo = new FlightFullInfo();
            flightFullInfo.setDate(d);
            for(Flight flight : customFlightRepository.findByFlightDate(d)){
                flightInfo.setFlightNumber(flight.getFlightNumber());
                for(Ticket ticket : flight.getTickets()){
                    flightInfo.addToRevenue(ticket.getTicketCost());
                    flightInfo.addOccupiedSeat(ticket.getSeatNumber());
                }
                flightFullInfo.addFligths(flightInfo);
                flightsResponse.addToDates(flightFullInfo);
            }
        });
        return ResponseEntity.ok().body(flightsResponse);
    }
}
