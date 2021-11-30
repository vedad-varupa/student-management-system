package com.example.Student.dao;


import com.example.Student.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    @Query("SELECT AVG(g.grade) FROM GradeEntity g WHERE g.studentEntity.id = :studentId")
    Double getAverageGradeByStudentId(final Long studentId);
}
