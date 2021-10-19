package com.example.Student.service;

import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;

public interface TeacherService {
    TeacherResponse getTeacherById(final Long id);

    TeacherResponse createTeacher(final TeacherRequest teacherRequest);

    void deleteTeacherById(final Long id);
}
