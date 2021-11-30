package com.example.Student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private int age;
    private Double average;
}
