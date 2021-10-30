package com.example.Student.mapper;

import com.example.Student.dto.SubjectRequest;
import com.example.Student.dto.SubjectResponse;
import com.example.Student.model.SubjectEntity;

public interface SubjectMapper {
    SubjectResponse entityToResponse(SubjectEntity subjectEntity);
    SubjectEntity requestToEntity(SubjectRequest subjectRequest);
}
