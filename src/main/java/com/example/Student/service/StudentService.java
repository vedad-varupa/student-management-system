package com.example.Student.service;




import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getAllStudents();
    StudentResponse getStudentById(final Long id);
    StudentResponse createStudent(final StudentRequest studentRequest);
    String deleteStudentById(final Long id);
    StudentResponse updateStudent(Long id, StudentRequest studentRequest);
}
