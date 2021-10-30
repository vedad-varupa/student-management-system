package com.example.Student.service.impl;

import com.example.Student.dao.GradeRepository;
import com.example.Student.dao.StudentRepository;
import com.example.Student.dao.SubjectRepository;
import com.example.Student.dao.TeacherRepository;
import com.example.Student.dto.GradeRequest;
import com.example.Student.dto.GradeResponse;
import com.example.Student.exception.ApiRequestException;
import com.example.Student.mapper.GradeMapper;
import com.example.Student.model.GradeEntity;
import com.example.Student.model.StudentEntity;
import com.example.Student.model.SubjectEntity;
import com.example.Student.model.TeacherEntity;
import com.example.Student.service.GradeService;
import com.example.Student.service.StudentService;
import com.example.Student.service.SubjectService;
import com.example.Student.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private static final String GRADE_DOES_NOT_EXIST = "Grade with {0} does not exist";
    private final GradeRepository gradeRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final GradeMapper gradeMapper;


    @Override
    public GradeResponse create(final GradeRequest gradeRequest) {
        final GradeEntity gradeEntity = new GradeEntity();
        final StudentEntity studentEntity = studentService.findStudentEntityById(gradeRequest.getStudentId());
        gradeEntity.setStudentEntity(studentEntity);

        final SubjectEntity subjectEntity = subjectService.findSubjectEntityById(gradeRequest.getSubjectId());
        gradeEntity.setSubjectEntity(subjectEntity);

        final TeacherEntity teacherEntity = teacherService.findTeacherEntityById(gradeRequest.getTeacherId());
        gradeEntity.setTeacherEntity(teacherEntity);
        gradeEntity.setCratedAt(LocalDateTime.now());
        gradeEntity.setCreatedBy("SYSTEM");
        gradeEntity.setGrade(gradeRequest.getGrade());

        final GradeEntity resultEntity = gradeRepository.save(gradeEntity);

        return gradeMapper.entityToResponse(resultEntity);
    }

    @Override
    public GradeResponse getById(final Long id) {
        final Optional<GradeEntity> gradeEntityOptional = gradeRepository.findById(id);
        if (!gradeEntityOptional.isPresent()) {
            throw new ApiRequestException(
                    MessageFormat.format(GRADE_DOES_NOT_EXIST, id)
            );
        }
        final GradeEntity entity = gradeEntityOptional.get();
        return gradeMapper.entityToResponse(entity);
    }

    @Override
    public void deleteById(final Long id) {
        if (!gradeRepository.existsById(id)) {
            throw new ApiRequestException(
                    MessageFormat.format(GRADE_DOES_NOT_EXIST, id)
            );
        }
        gradeRepository.deleteById(id);
    }

    @Override
    public GradeResponse updateById(final Long id, final GradeRequest gradeRequest) {
        final Optional<GradeEntity> gradeEntityOptional = gradeRepository.findById(id);
        if (!gradeEntityOptional.isPresent()) {
            throw new ApiRequestException(
                    MessageFormat.format(GRADE_DOES_NOT_EXIST, id)
            );
        }
        final GradeEntity gradeEntity = gradeEntityOptional.get();
        if (gradeRequest.getGrade() != null) {
            gradeEntity.setGrade(gradeRequest.getGrade());
        }

        final StudentEntity studentEntity = studentService.findStudentEntityById(gradeRequest.getStudentId());
        gradeEntity.setStudentEntity(studentEntity);

        final TeacherEntity teacherEntity = teacherService.findTeacherEntityById(gradeRequest.getTeacherId());
        gradeEntity.setTeacherEntity(teacherEntity);

        final SubjectEntity subjectEntity = subjectService.findSubjectEntityById(gradeRequest.getSubjectId());
        gradeEntity.setSubjectEntity(subjectEntity);

        final GradeEntity updatedGradeEntity = gradeRepository.save(gradeEntity);
        return gradeMapper.entityToResponse(updatedGradeEntity);
    }
}
