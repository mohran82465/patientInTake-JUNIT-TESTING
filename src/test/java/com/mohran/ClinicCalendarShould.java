package com.mohran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.format.DateTimeFormatter;
import  java.util.*;
class ClinicCalendarShould {
    @Test
    public void allowEntryOfAnAppointment(){
        ClinicCalendar calendar= new ClinicCalendar();
        calendar.addAppointment("ahmed","mohran","ashraf","09/01/2023 2:00 pm");
        List <PatientAppointment> appointmentList = calendar.getAppointments();
        assertNotNull(appointmentList);
        assertEquals(1,appointmentList.size());
        PatientAppointment appointment = appointmentList.get(0);
        assertEquals("ahmed",appointment.getPatientFirstName());
        assertEquals(Doctor.ashraf,appointment.getDoctor());
        assertEquals("09/01/2023 02:00 PM",appointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")));
        assertEquals("mohran",appointment.getPatientLastName());

    }
} 