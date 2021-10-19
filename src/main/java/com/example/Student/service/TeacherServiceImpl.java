package com.example.Student.service;

import com.example.Student.dao.TeacherRepository;
import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.exception.ApiRequestException;
import com.example.Student.mapper.TeacherMapper;
import com.example.Student.model.TeacherEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    public static final String TEACHER_DOES_NOT_EXIST = "Teacher with {0} does not exist";
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherResponse getTeacherById(Long id) {
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
    public TeacherResponse createTeacher(final TeacherRequest teacherRequest) {
        final TeacherEntity teacherEntity = teacherMapper.requestToEntity(teacherRequest);
        final int age = Period.between(teacherRequest.getDate(), LocalDate.now()).getYears();
        teacherEntity.setAge(age);
        final TeacherEntity resultEntity = teacherRepository.save(teacherEntity);
        return teacherMapper.entityToResponse(resultEntity);
    }

    @Override
    public void deleteTeacherById(final Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(TEACHER_DOES_NOT_EXIST, id)
            );
        }
        teacherRepository.deleteById(id);
    }


}
