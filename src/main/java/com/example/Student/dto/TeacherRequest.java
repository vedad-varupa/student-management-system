package com.example.Student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class TeacherRequest {
    private String name;
    private String lastname;
    private String email;
    private LocalDate date;
}
