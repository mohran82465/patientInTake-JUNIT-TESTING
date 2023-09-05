package com.mohran;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeConverterShould {
    @Test
    void covertTodayStringCorrectly()
    {
        LocalDateTime result = DateTimeConverter.convertStringTODateTime("today 1:00 pm", LocalDate.of(2023,9,5));
        assertEquals(result,LocalDateTime.of(2023,9,5,13,0));
    }
    @Test
    void convertCorrectPatternToDateTime(){
        LocalDateTime result = DateTimeConverter.convertStringTODateTime("9/7/2023 1:00 pm",
                LocalDate.of(2023,9,6));
        assertEquals(result,LocalDateTime.of(2023,9,7,13,0));
    }
    @Test
    void throwExceptionIfIncorrectPatternProvided(){
       Throwable error =  assertThrows(RuntimeException.class,()->DateTimeConverter.convertStringTODateTime("9/7/2023 100 pm",
                LocalDate.of(2023,9,6)));
        assertEquals("Unable to create date time from: [9/7/2023 100 pm], please enter with format [M/d/yyyy h:mm a], Text '9/7/2023 100 PM' could not be parsed at index 12",error.getMessage());
    }
}