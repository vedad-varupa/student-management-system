package com.example.Student.service;

import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;

public interface TeacherService {
    TeacherResponse createTeacher(final TeacherRequest teacherRequest);
}
