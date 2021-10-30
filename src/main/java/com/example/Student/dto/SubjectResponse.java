package com.example.Student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubjectResponse {
    private Long id;
    private String SubjectName;
    private Integer semester;
}
