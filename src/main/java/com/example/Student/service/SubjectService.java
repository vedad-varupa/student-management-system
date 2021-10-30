package com.example.Student.service;

import com.example.Student.dto.SubjectRequest;
import com.example.Student.dto.SubjectResponse;
import com.example.Student.model.SubjectEntity;

public interface SubjectService {
    SubjectResponse create(final SubjectRequest subjectRequest);

    SubjectEntity findSubjectEntityById(final Long id);

    void deleteById(final Long id);
}
