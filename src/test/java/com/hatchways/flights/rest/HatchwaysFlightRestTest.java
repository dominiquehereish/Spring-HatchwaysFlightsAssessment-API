package com.hatchways.flights.rest;

import com.hatchways.flights.service.FlightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class HatchwaysFlightRestTest {

    @Autowired
    public FlightService flightService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(flightService).isNotNull();
    }

    @Test
    void processTicket() {
    }

    @Test
    void getFlightsInfos() {
    }
}