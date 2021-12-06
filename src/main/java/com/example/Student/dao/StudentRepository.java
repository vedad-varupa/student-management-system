package com.example.Student.dao;


import com.example.Student.model.StudentEntity;
import com.example.Student.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    @Query("SELECT AVG(g.grade) FROM GradeEntity g WHERE g.studentEntity.id = :studentId")
    Double getAverageGradeByStudentId(final Long studentId);

    @Query("SELECT  DISTINCT(s.subjectName) FROM GradeEntity g JOIN SubjectEntity s ON g.studentEntity.id = :studentId")
    List<String> getSubjectNamesById(final Long studentId);
}
