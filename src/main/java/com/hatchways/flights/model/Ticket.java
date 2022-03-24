package com.hatchways.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Tickets")
public class Ticket {

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private int ticketId;
    @Column(nullable = false)
    private String seatNumber;
    @Column(nullable = false)
    private int ticketCost;

}
