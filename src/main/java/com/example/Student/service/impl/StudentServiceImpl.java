package com.example.Student.service.impl;

import com.example.Student.dao.StudentRepository;
import com.example.Student.dao.SubjectRepository;
import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.dto.SubjectResponse;
import com.example.Student.exception.ApiRequestException;
import com.example.Student.mapper.StudentMapper;
import com.example.Student.model.StudentEntity;
import com.example.Student.model.SubjectEntity;
import com.example.Student.service.GradeService;
import com.example.Student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    public static final String STUDENT_DOES_NOT_EXIST = "Student with {0} does not exist";
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;



    @Override
    public List<StudentResponse> getAll() {
        return studentRepository.findAll().stream()
                .map(student -> studentMapper.entityToResponse(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getById(final Long id) {
      final  StudentEntity studentEntity = findStudentEntityById(id);
      final StudentResponse studentResponse = studentMapper.entityToResponse(studentEntity);
      final double average = this.getAverageGradeByStudentId(id);
      final List<String> listsubjectnames = getSubjectNamesById(id);
      studentResponse.setAverage(average);
      studentResponse.setGetSubjectNamesById(listsubjectnames);
      return studentResponse;
    }

    @Override
    public StudentResponse create(final StudentRequest studentRequest) {
        final StudentEntity studentEntity = studentMapper.requestToEntity(studentRequest);
        final int age = Period.between(studentRequest.getDate(), LocalDate.now()).getYears();
        studentEntity.setAge(age);
        final StudentEntity resultEntity = studentRepository.save(studentEntity);
        return studentMapper.entityToResponse(resultEntity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(STUDENT_DOES_NOT_EXIST, id)
            );
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse updateById(final Long id, final StudentRequest studentRequest) {
        final StudentEntity studentEntity = findStudentEntityById(id);
        studentEntity.setName(studentRequest.getName());
        studentEntity.setLastname(studentRequest.getLastname());
        studentEntity.setEmail(studentRequest.getEmail());
        final int age = Period.between(studentRequest.getDate(), LocalDate.now()).getYears();
        studentEntity.setAge(age);
        StudentEntity updateStudentEntity = studentRepository.save(studentEntity);
        return studentMapper.entityToResponse(updateStudentEntity);
    }

    @Override
    public StudentEntity findStudentEntityById(final Long id) {
        final Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        if (!studentEntityOptional.isPresent()) {
            throw new ApiRequestException(
                    MessageFormat.format(STUDENT_DOES_NOT_EXIST, id)
            );
        }

        return studentEntityOptional.get();
    }
    @Override
    public Double getAverageGradeByStudentId(final Long id) {
        return studentRepository.getAverageGradeByStudentId(id);
    }

    @Override
    public List<String> getSubjectNamesById(Long id)
    {
        return studentRepository.getSubjectNamesById(id);
    }


}
