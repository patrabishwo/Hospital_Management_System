package com.learning.springBoot.Hospital_Management_System.entity;

import com.learning.springBoot.Hospital_Management_System.entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
              //  @UniqueConstraint(name = "unique_patient_email", columnNames = {"emails"}),
                @UniqueConstraint(name = "unique_patient_birthdate", columnNames = {"name ", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_birthdate", columnList = "birthDate")
        }


)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private  String name;

    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String  email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
}
