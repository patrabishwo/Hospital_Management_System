package com.learning.springBoot.Hospital_Management_System;

import com.learning.springBoot.Hospital_Management_System.entity.Appointment;
import com.learning.springBoot.Hospital_Management_System.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment(){

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11, 1, 14,00))
                .reason("Cancer")
                .build();

       var newAppointment = appointmentService.createAppointment(appointment, 1L, 2L );
        System.out.println(newAppointment);

    }

    @Test
    public void testReAssignAppointment(){

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(
                        2026,02, 06, 4, 30
                ))
                .reason("Cancer")
                .build();
        var newAppointment = appointmentService.createAppointment(appointment, 1L, 2L);

     var updatedAppointment =   appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);

        System.out.println(updatedAppointment);
    }
}
