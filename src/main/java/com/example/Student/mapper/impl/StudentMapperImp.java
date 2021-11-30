package com.example.Student.mapper.impl;


import com.example.Student.dao.StudentRepository;
import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.mapper.StudentMapper;
import com.example.Student.model.StudentEntity;
import com.example.Student.service.GradeService;
import com.example.Student.service.StudentService;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImp implements StudentMapper {
    private GradeService gradeService;


    @Override
    public StudentResponse entityToResponse(StudentEntity studentEntity) {
        System.out.println(studentEntity);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setLastname(studentEntity.getLastname());
        studentResponse.setAge(studentEntity.getAge());
        studentResponse.setEmail(studentEntity.getEmail());
        studentResponse.setAverage(studentEntity.getAverage());
        return studentResponse;
    }

    @Override
    public StudentEntity requestToEntity(StudentRequest studentRequest) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentRequest.getName());
        studentEntity.setLastname(studentRequest.getLastname());
        studentEntity.setEmail(studentRequest.getEmail());
        return studentEntity;
    }
}
