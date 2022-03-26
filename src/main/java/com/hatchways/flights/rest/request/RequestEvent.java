package com.hatchways.flights.rest.request;

import com.hatchways.flights.model.Event;
import lombok.Data;

import javax.validation.Valid;

@Data
public class RequestEvent {

    @Valid
    private Event event;

}
