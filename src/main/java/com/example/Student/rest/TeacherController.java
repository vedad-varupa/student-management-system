package com.example.Student.rest;

import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
@AllArgsConstructor
public class TeacherController {
    private TeacherService teacherService;

    @PostMapping("/create-teacher")
    public TeacherResponse createTeacher(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.createTeacher(teacherRequest);
    }
}
