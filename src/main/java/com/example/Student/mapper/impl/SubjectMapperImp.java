package com.example.Student.mapper.impl;

import com.example.Student.dto.SubjectRequest;
import com.example.Student.dto.SubjectResponse;
import com.example.Student.mapper.SubjectMapper;
import com.example.Student.model.SubjectEntity;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperImp implements SubjectMapper {
    @Override
    public SubjectResponse entityToResponse(SubjectEntity subjectEntity) {
        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.setId(subjectEntity.getId());
        subjectResponse.setSubjectName(subjectEntity.getSubjectName());
        subjectResponse.setSemester(subjectEntity.getSemester());
        return subjectResponse;
    }

    @Override
    public SubjectEntity requestToEntity(final SubjectRequest subjectRequest) {
        final SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectName(subjectRequest.getSubjectName());
        subjectEntity.setSemester(subjectRequest.getSemester());
        return subjectEntity;
    }
}
