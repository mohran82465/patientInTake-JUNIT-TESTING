package com.mohran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import  java.util.*;
class ClinicCalendarShould {
    @Test
    public void allowEntryOfAnAppointment(){
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
        calendar.addAppointment("ahmed","mohran","ashraf","09/01/2023 2:00 pm");
        List <PatientAppointment> appointmentList = calendar.getAppointments();
        assertNotNull(appointmentList);
        assertEquals(1,appointmentList.size());
        PatientAppointment appointment = appointmentList.get(0);
        assertEquals("ahmed",appointment.getPatientFirstName());
        assertSame(Doctor.ashraf,appointment.getDoctor());
        assertEquals("09/01/2023 02:00 PM",appointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")));
        assertEquals("mohran",appointment.getPatientLastName());

    }
    @Test
    void returnTrueForHasAppointmentIfThereAreAppointment()
    {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
        calendar.addAppointment("mohamed","mohran","ashraf",
                "09/16/2023 2:00 pm");
        assertTrue(calendar.hasAppointment(LocalDate.of(2023,9,16)));
    }
    @Test
    void returnFalseForHasAppointmentsIfThereAreNoAppointments()
    {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
        assertFalse(calendar.hasAppointment(LocalDate.of(2023,9,4)));
    }

    @Test
    void returnCurrentDaysAppointments()
    {
        ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
        calendar.addAppointment("mohamed","mohran","essam",
                "9/4/2023 2:00 pm");
        calendar.addAppointment("ahmed","mohran","ashraf",
                "9/4/2023 3:00 pm");
//        calendar.addAppointment("ali","mohran","ali",
//                "9/16/2023 2:00 pm");
        assertEquals(2,calendar.getTodayAppointments().size());
        assertIterableEquals(calendar.getTodayAppointments(),calendar.getAppointments());
    }
}