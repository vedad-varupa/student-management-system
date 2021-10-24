package com.example.Student.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GradeResponse {
    private Long gradeId;
    private Integer grade;
    private String subjectName;
    private String teacherName;
    private String studentFullName;
    private LocalDateTime createdAt;
}
