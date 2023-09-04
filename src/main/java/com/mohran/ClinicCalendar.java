package com.mohran;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class ClinicCalendar {
    private List <PatientAppointment> appiontments;

    public ClinicCalendar() {
        this.appiontments = new ArrayList<>();
    }
    public void addAppointment(String patientFirstName , String patientLastName,String doctorKey,String dateTime )
    {
        Doctor doc = Doctor.valueOf(doctorKey.toLowerCase());
        LocalDateTime localDateTime;
        try {
            localDateTime=LocalDateTime.parse(dateTime.toUpperCase(), DateTimeFormatter.ofPattern("M/d/yyyy h:mm a",Locale.US));

        }
        catch (Throwable e)
        {
            throw new RuntimeException("Unable to create date time form : ["+dateTime.toUpperCase()+"], please enter with format [m/d/yyyy h:mm a"+e.getMessage());
        }
        PatientAppointment appointment = new PatientAppointment(patientFirstName,patientLastName,localDateTime,doc);
        appiontments.add(appointment);

    }

    public List<PatientAppointment> getAppointments() {
        return this.appiontments;
    }
}
