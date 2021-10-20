package com.example.Student.rest;

import com.example.Student.dto.GradeResponse;
import com.example.Student.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("grade")
public class GradeController {

    private final GradeService gradeService;

    @PostMapping("/{grade}/{studentId}/{teacherId}/{subjectId}")
    public ResponseEntity<GradeResponse> create(
            @PathVariable Integer grade,
            @PathVariable Long studentId,
            @PathVariable Long teacherId,
            @PathVariable Long subjectId
    ) {
        return new ResponseEntity<>(gradeService.create(grade, studentId, teacherId, subjectId), HttpStatus.CREATED);
    }

}
