package com.example.Student.rest;

import com.example.Student.dto.StudentRequest;
import com.example.Student.dto.StudentResponse;
import com.example.Student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("test")
    public String test() {
        System.err.println("test is working");
        return "test is valid"; }

    @GetMapping("/get-students")
    public List<StudentResponse> getAllStudents() { return studentService.getAllStudents();}

    @GetMapping("/get-student/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) { return studentService.getStudentById(id);}

    @PostMapping("/create-student")
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest); }

    @DeleteMapping("/delete-student/{id}")
    public String deleteStudentById(@PathVariable Long id) {return studentService.deleteStudentById(id);}

    @PutMapping("/update-student/{id}")
    public StudentResponse updateStudentById(@PathVariable Long id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id, studentRequest); }
}
