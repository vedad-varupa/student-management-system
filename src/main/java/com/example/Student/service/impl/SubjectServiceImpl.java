package com.example.Student.service.impl;

import com.example.Student.dao.SubjectRepository;
import com.example.Student.dto.SubjectRequest;
import com.example.Student.dto.SubjectResponse;
import com.example.Student.exception.ApiRequestException;
import com.example.Student.mapper.SubjectMapper;
import com.example.Student.model.SubjectEntity;
import com.example.Student.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private static final String SUBJECT_DOES_NOT_EXIST = "Subject with {0} does not exist";
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;


    @Override
    public SubjectResponse create(final SubjectRequest subjectRequest) {
        final SubjectEntity subjectEntity = subjectMapper.requestToEntity(subjectRequest);
        final SubjectEntity resultEntity = subjectRepository.save(subjectEntity);
        return subjectMapper.entityToResponse(resultEntity);
    }

    @Override
    public SubjectEntity findSubjectEntityById(final Long id) {
        final Optional<SubjectEntity> optionalSubjectEntity = subjectRepository.findById(id);
        if (!optionalSubjectEntity.isPresent()) {
            throw new ApiRequestException(MessageFormat.format(SUBJECT_DOES_NOT_EXIST, id));
        }
        return optionalSubjectEntity.get();
    }

    @Override
    public void deleteById(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new ApiRequestException(MessageFormat.format(SUBJECT_DOES_NOT_EXIST, id));
        }
        subjectRepository.deleteById(id);
    }
}
