package com.example.Student.mapper.impl;

import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.mapper.TeacherMapper;
import com.example.Student.model.TeacherEntity;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapperImp implements TeacherMapper {
    @Override
    public TeacherResponse entityToResponse(final TeacherEntity teacherEntity) {
        final TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacherEntity.getId());
        teacherResponse.setName(teacherEntity.getName());
        teacherResponse.setLastname(teacherEntity.getLastname());
        teacherResponse.setAge(teacherEntity.getAge());
        teacherResponse.setEmail(teacherEntity.getEmail());
        return teacherResponse;
    }

    @Override
    public TeacherEntity requestToEntity(final TeacherRequest teacherRequest) {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName(teacherRequest.getName());
        teacherEntity.setLastname(teacherRequest.getLastname());
        teacherEntity.setEmail(teacherRequest.getEmail());
        return teacherEntity;
    }
}
