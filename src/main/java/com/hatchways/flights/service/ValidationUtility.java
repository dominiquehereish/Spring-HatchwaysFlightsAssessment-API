package com.hatchways.flights.service;

import com.hatchways.flights.model.Event;
import com.hatchways.flights.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ValidationUtility {

    public static boolean isEmptyDate(String date){
        return (null == date || date.isBlank());
    }

    public static boolean isValidDate(String date){
        try{
            LocalDate.parse(date);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
