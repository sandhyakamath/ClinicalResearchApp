package com.godel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PatientDTO {
    int id;
    String name;
    int age;
    String gender;
    String conditionType;
    Date recuitmentDate;

}
