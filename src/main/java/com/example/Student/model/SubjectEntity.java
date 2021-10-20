package com.example.Student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subjectName;
    private Integer semester;
//    private LocalDateTime createdAt;
//    private String createdBy;
}
