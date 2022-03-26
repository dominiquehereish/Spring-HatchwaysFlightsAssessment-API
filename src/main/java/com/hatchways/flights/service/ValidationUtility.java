package com.hatchways.flights.service;

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
