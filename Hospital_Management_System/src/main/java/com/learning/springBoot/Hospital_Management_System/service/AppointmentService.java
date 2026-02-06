package com.learning.springBoot.Hospital_Management_System.service;

import com.learning.springBoot.Hospital_Management_System.entity.Appointment;
import com.learning.springBoot.Hospital_Management_System.entity.Doctor;
import com.learning.springBoot.Hospital_Management_System.entity.Patient;
import com.learning.springBoot.Hospital_Management_System.repository.AppointmentRepository;
import com.learning.springBoot.Hospital_Management_System.repository.DoctorRepository;
import com.learning.springBoot.Hospital_Management_System.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private  final PatientRepository patientRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId){

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()-> new EntityNotFoundException("Doctor not found with id:"+doctorId));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id:"+patientId));

        if(appointment.getId() != null){
            throw  new IllegalArgumentException("Appointment shouldn't have ");
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);


        patient.getAppointments().add(appointment);


        appointmentRepository.save(appointment);

        return appointment;

    }

    @Transactional
    public  Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appoint not found  with id:"+appointmentId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id:"+doctorId));


        appointment.setDoctor(doctor);// this   will automatically call the  update because  it is  dirty now

        doctor.getAppointments().add(appointment);// just  for bidirectional consistency

        return appointment;
    }
}
