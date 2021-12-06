package com.example.Student.service;


import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.model.StudentEntity;
import com.example.Student.model.SubjectEntity;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getAll();

    StudentResponse getById(final Long id);

    StudentResponse create(final StudentRequest studentRequest);

    void deleteById(final Long id);

    StudentResponse updateById(Long id, StudentRequest studentRequest);

    StudentEntity findStudentEntityById(final Long id);

    Double getAverageGradeByStudentId(final Long id);

    List<String> getSubjectNamesById(final Long id);


}
