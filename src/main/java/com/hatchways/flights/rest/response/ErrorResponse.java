package com.hatchways.flights.rest.response;

import lombok.Data;

@Data
public class ErrorResponse extends Response{

    private String status = "failed";
    private String reason;

    public ErrorResponse(String reason){
        this.reason = reason;
    }

}
