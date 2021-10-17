package com.example.Student.mapper;


import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.model.StudentEntity;

public interface StudentMapper {
    StudentResponse entityToResponse(StudentEntity studentEntity);
    StudentEntity requestToEntity(StudentRequest studentRequest);
}
