package com.example.Student.dto;

import com.example.Student.model.SubjectEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    List<String> getSubjectNamesById = new ArrayList<>();
}