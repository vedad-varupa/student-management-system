package com.example.Student.mapper;

import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.model.TeacherEntity;

public interface TeacherMapper {
    TeacherResponse entityToResponse(TeacherEntity teacherEntity);

    TeacherEntity requestToEntity(TeacherRequest teacherRequest);
}
