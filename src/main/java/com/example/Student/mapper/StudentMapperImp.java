package com.example.Student.mapper;


import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.model.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImp implements StudentMapper{


    @Override
    public StudentResponse entityToResponse(StudentEntity studentEntity) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setLastname(studentEntity.getLastname());
        studentResponse.setAge(studentEntity.getAge());
        studentResponse.setEmail(studentEntity.getEmail());
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
