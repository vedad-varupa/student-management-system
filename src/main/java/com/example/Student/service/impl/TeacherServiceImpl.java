package com.example.Student.service.impl;

import com.example.Student.dao.TeacherRepository;
import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.exception.ApiRequestException;
import com.example.Student.mapper.TeacherMapper;
import com.example.Student.model.StudentEntity;
import com.example.Student.model.TeacherEntity;
import com.example.Student.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    public static final String TEACHER_DOES_NOT_EXIST = "Teacher with {0} does not exist";
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;


    @Override
    public List<TeacherResponse> getAll() {
        return teacherRepository.findAll().stream()
                .map(teacher -> teacherMapper.entityToResponse(teacher))
                .collect(Collectors.toList());
    }

    @Override
    public TeacherResponse getById(Long id) {
        final Optional<TeacherEntity> teacherEntityOptional = teacherRepository.findById(id);
        if (!teacherEntityOptional.isPresent()) {
            throw new ApiRequestException(
                    MessageFormat.format(TEACHER_DOES_NOT_EXIST, id)
            );
        }
        final TeacherEntity entity = teacherEntityOptional.get();
        return teacherMapper.entityToResponse(entity);
    }

    @Override
    public TeacherResponse create(final TeacherRequest teacherRequest) {
        final TeacherEntity teacherEntity = teacherMapper.requestToEntity(teacherRequest);
        final int age = Period.between(teacherRequest.getDate(), LocalDate.now()).getYears();
        teacherEntity.setAge(age);
        final TeacherEntity resultEntity = teacherRepository.save(teacherEntity);
        return teacherMapper.entityToResponse(resultEntity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(TEACHER_DOES_NOT_EXIST, id)
            );
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherResponse updateById(Long id, TeacherRequest teacherRequest) {
        final Optional<TeacherEntity> teacherEntityOptional = teacherRepository.findById(id);

        if (!teacherEntityOptional.isPresent()) {
            throw new ApiRequestException(
                    MessageFormat.format(TEACHER_DOES_NOT_EXIST, id)
            );
        }
        final TeacherEntity teacherEntity = teacherEntityOptional.get();
        teacherEntity.setName(teacherRequest.getName());
        teacherEntity.setLastname(teacherRequest.getLastname());
        teacherEntity.setEmail(teacherRequest.getEmail());
        final int age = Period.between(teacherRequest.getDate(), LocalDate.now()).getYears();
        teacherEntity.setAge(age);
        final TeacherEntity updateTeacherEntity = teacherRepository.save(teacherEntity);
        return teacherMapper.entityToResponse(updateTeacherEntity);

    }

    @Override
    public TeacherEntity findTeacherEntityById(Long id) {
        final Optional<TeacherEntity> teacherEntityOptional = teacherRepository.findById(id);
        if (!teacherEntityOptional.isPresent()) {
            throw new ApiRequestException(
                    MessageFormat.format(TEACHER_DOES_NOT_EXIST, id)
            );
        }
        return teacherEntityOptional.get();
    }
}
