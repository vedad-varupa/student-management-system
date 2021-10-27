package com.example.Student.mapper.impl;

import com.example.Student.dto.GradeRequest;
import com.example.Student.dto.GradeResponse;
import com.example.Student.mapper.GradeMapper;
import com.example.Student.model.GradeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GradeMapperImp implements GradeMapper {

    @Override
    public GradeResponse entityToResponse(final GradeEntity gradeEntity) {
        final GradeResponse gradeResponse = new GradeResponse();
        gradeResponse.setGradeId(gradeEntity.getId());
        gradeResponse.setGrade(gradeEntity.getGrade());
        gradeResponse.setSubjectName(gradeEntity.getSubjectEntity().getSubjectName());
        gradeResponse.setTeacherName(gradeEntity.getTeacherEntity().getName());
        gradeResponse.setStudentFullName(
                gradeEntity.getStudentEntity().getName() + " " + gradeEntity.getStudentEntity().getLastname()
        );
        gradeResponse.setCreatedAt(gradeEntity.getCratedAt());
        return gradeResponse;
    }

    @Override
    public GradeEntity requestToEntity(GradeRequest gradeRequest) {
        GradeEntity gradeEntity = new GradeEntity();
        gradeEntity.setGrade(gradeRequest.getGrade());
        return gradeEntity;
    }

}
