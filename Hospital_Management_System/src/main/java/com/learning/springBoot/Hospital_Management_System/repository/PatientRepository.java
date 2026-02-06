package com.learning.springBoot.Hospital_Management_System.repository;

import com.learning.springBoot.Hospital_Management_System.entity.Patient;
import com.learning.springBoot.Hospital_Management_System.entity.type.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient>  findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContaining(String query);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient>  findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

    @Query("SELECT p FROM Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate")LocalDate birthDate);

    @Query("SELECT p.bloodGroup , Count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroup();

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatient();

}
