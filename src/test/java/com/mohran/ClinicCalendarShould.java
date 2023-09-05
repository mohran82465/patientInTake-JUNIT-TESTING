package com.mohran;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import  java.util.*;

class ClinicCalendarShould {

    private ClinicCalendar calendar;
    @BeforeAll
    static void testClassSetup()
    {
        System.out.println("Before all.....");
    }
    @BeforeEach
    void inti()
    {
        System.out.println("Before each.....");
        calendar = new ClinicCalendar(LocalDate.of(2023,9,5));
    }
    @Test
    @Tag("dateTime")
    public void allowEntryOfAnAppointment(){
        System.out.println("entry of appointment");
        calendar.addAppointment("ahmed","mohran","ashraf","09/01/2023 2:00 pm");
        List <PatientAppointment> appointmentList = calendar.getAppointments();
        assertNotNull(appointmentList);
        assertEquals(1,appointmentList.size());
        PatientAppointment appointment = appointmentList.get(0);
        assertAll(
                ()->assertEquals("ahmed",appointment.getPatientFirstName()),
                ()->assertEquals(Doctor.ashraf,appointment.getDoctor()),
                ()->assertEquals("09/01/2023 02:00 PM",appointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"))),
                ()->assertEquals("mohran",appointment.getPatientLastName())
        );
    }
    @Test
    void returnTrueForHasAppointmentIfThereAreAppointment()
    {
        System.out.println("has appointment");
        calendar.addAppointment("mohamed","mohran","ashraf",
                "09/16/2023 2:00 pm");
        assertTrue(calendar.hasAppointment(LocalDate.of(2023,9,16)));
    }
    @Test
    void returnFalseForHasAppointmentsIfThereAreNoAppointments()
    {
        System.out.println("no appointment");
        assertFalse(calendar.hasAppointment(LocalDate.of(2023,9,5)));
    }

    @Test
    void returnCurrentDaysAppointments()
    {
        System.out.println("current day appointment");
        calendar.addAppointment("mohamed","mohran","essam",
                "9/5/2023 2:00 pm");
        calendar.addAppointment("ahmed","mohran","ashraf",
                "9/5/2023 3:00 pm");
        calendar.addAppointment("ali","mohran","ali",
                "9/16/2023 2:00 pm");
        assertEquals(2,calendar.getTodayAppointments().size());
    }
    @AfterEach
    void tearDownEachTest()
    {
        System.out.println("After each.....");
    }
    @AfterAll
    static void finalTest(){
        System.out.println("After all.....");
    }
}