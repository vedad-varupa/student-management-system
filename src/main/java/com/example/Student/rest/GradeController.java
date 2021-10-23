package com.example.Student.rest;

import com.example.Student.dto.GradeRequest;
import com.example.Student.dto.GradeResponse;
import com.example.Student.service.GradeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("grade")
public class GradeController {

    private final GradeService gradeService;


    @PostMapping
    public ResponseEntity<GradeResponse> create(@RequestBody final GradeRequest gradeRequest) {
        return new ResponseEntity<>(gradeService.create(gradeRequest), HttpStatus.CREATED);
    }

}
