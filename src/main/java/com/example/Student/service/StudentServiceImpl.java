package com.example.Student.service;

import com.example.Student.dao.StudentRepository;
import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.mapper.StudentMapper;
import com.example.Student.model.StudentEntity;
import com.example.Student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> studentMapper.entityToResponse(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudentById(final Long id) {
        final Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        if (studentEntityOptional.isPresent()) {
            final StudentEntity entity = studentEntityOptional.get();
            return studentMapper.entityToResponse(entity);
        }
        return new StudentResponse();
    }

    @Override
    public StudentResponse createStudent(final StudentRequest studentRequest) {
        final StudentEntity studentEntity = studentMapper.requestToEntity(studentRequest);
        final int age = Period.between(studentRequest.getDate(), LocalDate.now()).getYears();
        studentEntity.setAge(age);
        final StudentEntity resultEntity = studentRepository.save(studentEntity);
        return studentMapper.entityToResponse(resultEntity);
    }

    @Override
    public String deleteStudentById(final Long id) {
        String message = "";
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            message = "Deleted";
        } else {
            message = "Not found";
        }
        return message;
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        final Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        StudentEntity studentEntity = null;
        if (studentEntityOptional.isPresent()) {
            studentEntity = studentEntityOptional.get();
        } else {
            throw new RuntimeException("Student not found.");
        }
        studentEntity.setName(studentRequest.getName());
        studentEntity.setLastname(studentRequest.getLastname());
        studentEntity.setEmail(studentRequest.getEmail());
        StudentEntity updateStudentEntity = studentRepository.save(studentEntity);
        return studentMapper.entityToResponse(updateStudentEntity);
    }

}
