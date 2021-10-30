package com.example.Student.service;

import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.model.StudentEntity;
import com.example.Student.model.TeacherEntity;

import java.util.List;

public interface TeacherService {

    List<TeacherResponse> getAll();

    TeacherResponse getById(final Long id);

    TeacherResponse create(final TeacherRequest teacherRequest);

    void deleteById(final Long id);

    TeacherResponse updateById(final Long id, TeacherRequest teacherRequest);

    TeacherEntity findTeacherEntityById(final Long id);
}
