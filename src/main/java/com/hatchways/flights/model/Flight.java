package com.hatchways.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "flights")
public class Flight {

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private String flightNumber;
    @Column(nullable = false)
    private LocalDate flightDate;
    @OneToMany
    private Set<Ticket> tickets;

}
