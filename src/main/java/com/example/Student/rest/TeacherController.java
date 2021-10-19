package com.example.Student.rest;

import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teacher")
@AllArgsConstructor
public class TeacherController {
    private TeacherService teacherService;

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity<TeacherResponse> getTeacherById(@PathVariable Long id) {
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.FOUND);
    }

    @PostMapping("/create-teacher")
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody TeacherRequest teacherRequest) {
        return new ResponseEntity<>(teacherService.createTeacher(teacherRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-teacher/{id}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable final Long id) {
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
