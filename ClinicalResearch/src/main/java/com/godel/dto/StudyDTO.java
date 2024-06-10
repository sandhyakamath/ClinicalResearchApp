package com.godel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudyDTO {
    private int id;
    private String title;
    private String therapeutics;
    private String description;
    private String status;
}
