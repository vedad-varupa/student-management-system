package com.example.Student.service;

import com.example.Student.dao.StudentRepository;
import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.exception.ApiRequestException;
import com.example.Student.mapper.StudentMapper;
import com.example.Student.model.StudentEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    public static final String STUDENT_DOES_NOT_EXIST = "Student with {0} does not exist";

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
        if (!studentEntityOptional.isPresent()) {
            throw new ApiRequestException(
                    MessageFormat.format(STUDENT_DOES_NOT_EXIST, id)
            );
        }
        final StudentEntity entity = studentEntityOptional.get();
        return studentMapper.entityToResponse(entity);
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
    public void deleteStudentById(final Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(STUDENT_DOES_NOT_EXIST, id)
            );
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        final Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        StudentEntity studentEntity = null;
        if (!studentEntityOptional.isPresent()) {
            throw new ApiRequestException(
                    MessageFormat.format(STUDENT_DOES_NOT_EXIST, id)
            );
        }
        studentEntity = studentEntityOptional.get();
        studentEntity.setName(studentRequest.getName());
        studentEntity.setLastname(studentRequest.getLastname());
        studentEntity.setEmail(studentRequest.getEmail());
        StudentEntity updateStudentEntity = studentRepository.save(studentEntity);
        return studentMapper.entityToResponse(updateStudentEntity);
    }

}
