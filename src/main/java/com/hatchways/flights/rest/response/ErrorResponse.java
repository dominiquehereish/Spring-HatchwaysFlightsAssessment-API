package com.hatchways.flights.rest.response;

import lombok.Data;

@Data
public class ErrorResponse {

    private String status = "failed";
    private String reason;

}
