package com.learning.springBoot.Hospital_Management_System;

import com.learning.springBoot.Hospital_Management_System.entity.Patient;
import com.learning.springBoot.Hospital_Management_System.entity.type.BloodGroup;
import com.learning.springBoot.Hospital_Management_System.repository.PatientRepository;
import com.learning.springBoot.Hospital_Management_System.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientsTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
      List<Patient>  patientList =  patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){

       // Patient patient =  patientService.getPatientByID(1L);
       // Patient  patient = patientRepository.findByName("Diya Patel");

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(
//                LocalDate.of(1990,5,18),
//                "ishant.verma@example.com"
//        );

//        List<Patient> patientList = patientRepository.findByBirthDateBetween(
//                LocalDate.of(1993,7,11),
//                LocalDate.of(1995,8,20)
//        );

//        List<Patient> patientList = patientRepository.findByNameContaining("Di");

//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroup.A_NEGATIVE);

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1992,12,1));
//
//        for(Patient patient: patientList){
//            System.out.println(patient);
//        }
//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroup();
//
//        for(Object[] objects: bloodGroupList){
//            System.out.println("["+objects[0]+","+objects[1]+"]");
//        }

        List<Patient> patientList1 = patientRepository.findAllPatient();

        for(Patient patient:patientList1){
            System.out.println(patient);
        }

//        System.out.println(patientList);
    }
}
