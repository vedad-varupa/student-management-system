package com.example.Student.rest;

import com.example.Student.dto.SubjectRequest;
import com.example.Student.dto.SubjectResponse;
import com.example.Student.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subject")
@AllArgsConstructor
public class SubjectController {
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponse> create(@RequestBody SubjectRequest subjectRequest) {
        return new ResponseEntity<>(subjectService.create(subjectRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        subjectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
