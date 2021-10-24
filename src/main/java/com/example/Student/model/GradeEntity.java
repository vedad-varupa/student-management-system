package com.example.Student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="grade")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer grade;
    private LocalDateTime cratedAt;
    private String createdBy;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subjectEntity;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;


}
