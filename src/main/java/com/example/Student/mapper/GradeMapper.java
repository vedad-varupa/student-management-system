package com.example.Student.mapper;

import com.example.Student.dto.GradeRequest;
import com.example.Student.dto.GradeResponse;
import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.model.GradeEntity;
import com.example.Student.model.TeacherEntity;

public interface GradeMapper {
    GradeResponse entityToResponse(GradeEntity gradeEntity);

    GradeEntity requestToEntity(GradeRequest gradeRequest);
}
