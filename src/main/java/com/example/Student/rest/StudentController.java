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

    @GetMapping("/get-students")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.FOUND);
    }

    @GetMapping("/get-student/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.FOUND);
    }

    @PostMapping("/create-student")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.createStudent(studentRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable final Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity<StudentResponse> updateStudentById(
            @PathVariable Long id,
            @RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.updateStudent(id, studentRequest), HttpStatus.ACCEPTED);
    }
}
