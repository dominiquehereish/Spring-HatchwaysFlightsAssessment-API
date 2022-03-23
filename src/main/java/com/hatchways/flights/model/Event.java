package com.hatchways.flights.model;

import javax.validation.constraints.NotNull;

public class Event {

    @NotNull
    private int ticketId;
    @NotNull
    private String flightDate;
    private String flightNumber;
    private String seatNumber;
    private int ticketCost;

}
