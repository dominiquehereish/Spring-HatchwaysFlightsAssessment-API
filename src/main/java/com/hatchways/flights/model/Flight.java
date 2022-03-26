package com.hatchways.flights.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity(name = "flights")
public class Flight {

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private String flightNumber;
    @Column(nullable = false)
    private LocalDate flightDate;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

    public Flight(String flightNumber, LocalDate flightDate, Ticket ticket){
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.tickets.add(ticket);
    }

    public void addTicketToFlight(Ticket ticket){
        this.tickets.add(ticket);
    }

}
