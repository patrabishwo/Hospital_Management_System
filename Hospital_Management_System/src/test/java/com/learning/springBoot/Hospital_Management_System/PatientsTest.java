package com.learning.springBoot.Hospital_Management_System;

import com.learning.springBoot.Hospital_Management_System.entity.Patient;
import com.learning.springBoot.Hospital_Management_System.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientsTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
      List<Patient>  patientList =  patientRepository.findAll();
        System.out.println(patientList);
    }
}
