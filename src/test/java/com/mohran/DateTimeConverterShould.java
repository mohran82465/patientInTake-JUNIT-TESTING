package com.mohran;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@Tag("dateTime")
@DisplayName("DateTimeConverter should")
class DateTimeConverterShould {
    @Nested
    @DisplayName("convert string with 'today' keyword correctly")
    class todayTest{
        @Test
        @DisplayName(" correctly")
        void convertCorrectPatternToDateTime(){
            LocalDate today = LocalDate.of(2023, 9, 5);
            LocalDateTime result = DateTimeConverter.convertStringTODateTime("today 1:00 pm",
                    today);
            assertEquals(result,LocalDateTime.of(2023,9,5,13,0 ),
                    ()->"Failed to convert 'today' string to expected date time, today passed was : "+today);
            // note that lambda expression here to speed up test execution

        }

        @Test
        @DisplayName("regardless of case")
        void convertTodayStringCorrectlyCaseInsensitive(){
            LocalDate today = LocalDate.of(2023, 9, 5);
            LocalDateTime result = DateTimeConverter.convertStringTODateTime("toDay 1:00 pm",
                    today);
            assertEquals(result,LocalDateTime.of(2023,9,5,13,0 ),
                    ()->"Failed to convert 'today' string to expected date time, today passed was : "+today);
            // note that lambda expression here to speed up test execution

        }
    }


    @Test
    @DisplayName("convert expected date time pattern in string correctly ")
    void covertTodayStringCorrectly()
    {
        LocalDate today = LocalDate.of(2023, 9, 5);
        LocalDateTime result = DateTimeConverter.convertStringTODateTime("today 1:00 pm",
                today);
        assertEquals(result,LocalDateTime.of(2023,9,5,13,0 ),
                ()->"Failed to convert 'today' string to expected date time, today passed was : "+today);
        // note that lambda expression here to speed up test execution
    }
    @Test
    @DisplayName("throw exception if entered pattern of st ring incorrect ")
    void throwExceptionIfIncorrectPatternProvided(){
       Throwable error =  assertThrows(RuntimeException.class,()->DateTimeConverter.convertStringTODateTime("9/7/2023 100 pm",
                LocalDate.of(2023,9,6)));
        assertEquals("Unable to create date time from: [9/7/2023 100 pm], please enter with format [M/d/yyyy h:mm a], Text '9/7/2023 100 PM' could not be parsed at index 12",error.getMessage());
    }
}