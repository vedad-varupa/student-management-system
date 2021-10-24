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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {
    public static final String STUDENT_DOES_NOT_EXIST = "Student with {0} does not exist";
    public static final String TEACHER_DOES_NOT_EXIST = "Teacher with {0} does not exist";
    private static final String SUBJECT_DOES_NOT_EXIST = "Subject with {0} does not exist";
    private static final String GRADE_DOES_NOT_EXIST = "Grade with {0} does not exist";
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final GradeMapper gradeMapper;


    @Override
    public GradeResponse create(final GradeRequest gradeRequest) {
        final GradeEntity gradeEntity = new GradeEntity();
        final Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(gradeRequest.getStudentId());
        if (!optionalStudentEntity.isPresent()) {
            throw new ApiRequestException(MessageFormat.format(STUDENT_DOES_NOT_EXIST, gradeRequest.getStudentId()));
        }
        gradeEntity.setStudentEntity(optionalStudentEntity.get());

        final Optional<TeacherEntity> optionalTeacherEntity = teacherRepository.findById(gradeRequest.getTeacherId());
        if (!optionalTeacherEntity.isPresent()) {
            throw new ApiRequestException(MessageFormat.format(TEACHER_DOES_NOT_EXIST, gradeRequest.getTeacherId()));
        }
        gradeEntity.setTeacherEntity(optionalTeacherEntity.get());

        final Optional<SubjectEntity> optionalSubjectEntity = subjectRepository.findById(gradeRequest.getSubjectId());
        if (!optionalSubjectEntity.isPresent()) {
            throw new ApiRequestException(MessageFormat.format(SUBJECT_DOES_NOT_EXIST, gradeRequest.getSubjectId()));
        }
        gradeEntity.setSubjectEntity(optionalSubjectEntity.get());

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
}
