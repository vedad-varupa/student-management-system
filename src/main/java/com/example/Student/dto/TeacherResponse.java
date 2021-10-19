package com.example.Student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeacherResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private int age;
}
