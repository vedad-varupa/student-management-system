package com.example.Student.service;

import com.example.Student.dto.GradeRequest;
import com.example.Student.dto.GradeResponse;

public interface GradeService {
    GradeResponse create(final GradeRequest gradeRequest);


    GradeResponse getById(final Long id);

    void deleteById(final Long id);

    GradeResponse updateById(final Long id, GradeRequest gradeRequest);
}
