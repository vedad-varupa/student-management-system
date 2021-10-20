package com.example.Student.service;

import com.example.Student.dto.GradeResponse;

public interface GradeService {
    GradeResponse create(final Integer grade, final Long studentId, final Long teacherId, final Long subjectId);
}
