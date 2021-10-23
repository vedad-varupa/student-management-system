package com.example.Student.rest;

import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponse> getById(@PathVariable final Long id) {
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody final StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.create(studentRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentResponse> updateById(
            @PathVariable final Long id,
            @RequestBody final StudentRequest studentRequest
    ) {
        return new ResponseEntity<>(studentService.updateById(id, studentRequest), HttpStatus.ACCEPTED);
    }
}
