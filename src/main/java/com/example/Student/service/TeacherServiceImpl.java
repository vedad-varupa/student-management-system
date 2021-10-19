package com.example.Student.service;

import com.example.Student.dao.TeacherRepository;
import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.mapper.TeacherMapper;
import com.example.Student.model.TeacherEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherResponse createTeacher(final TeacherRequest teacherRequest) {
        final TeacherEntity teacherEntity = teacherMapper.requestToEntity(teacherRequest);
        final int age = Period.between(teacherRequest.getDate(), LocalDate.now()).getYears();
        teacherEntity.setAge(age);
        final TeacherEntity resultEntity = teacherRepository.save(teacherEntity);
        return teacherMapper.entityToResponse(resultEntity);
    }
}
