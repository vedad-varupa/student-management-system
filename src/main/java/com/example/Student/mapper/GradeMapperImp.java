package com.example.Student.mapper;

import com.example.Student.dto.GradeRequest;
import com.example.Student.dto.GradeResponse;
import com.example.Student.model.GradeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class GradeMapperImp implements GradeMapper {

    @Override
    public GradeResponse entityToResponse(GradeEntity gradeEntity) {
        GradeResponse gradeResponse = new GradeResponse();
        gradeResponse.setGradeId(gradeEntity.getId());
        gradeResponse.setGrade(gradeEntity.getGrade());
        gradeResponse.setSubjectName(gradeEntity.getSubjectEntity().getSubjectName());
        gradeResponse.setTeacherName(gradeEntity.getTeacherEntity().getName());
        gradeResponse.setStudentFullName(gradeEntity.getStudentEntity().getName());
        gradeResponse.setCreatedAt(LocalDateTime.now());
        return gradeResponse;
    }

    @Override
    public GradeEntity requestToEntity(GradeRequest gradeRequest) {
        GradeEntity gradeEntity = new GradeEntity();
        gradeEntity.setGrade(gradeRequest.getGrade());
        return gradeEntity;
    }
}
