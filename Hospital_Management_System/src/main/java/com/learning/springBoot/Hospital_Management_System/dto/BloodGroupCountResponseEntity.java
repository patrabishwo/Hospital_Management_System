package com.learning.springBoot.Hospital_Management_System.dto;

import com.learning.springBoot.Hospital_Management_System.entity.type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseEntity {

    private BloodGroup bloodGroup;
    private Long count;
}
