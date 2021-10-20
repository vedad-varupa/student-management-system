package com.example.Student.rest;

import com.example.Student.dto.TeacherRequest;
import com.example.Student.dto.TeacherResponse;
import com.example.Student.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
@AllArgsConstructor
public class TeacherController {
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getAll() {
        return new ResponseEntity<>(teacherService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherResponse> getById(@PathVariable final Long id) {
        return new ResponseEntity<>(teacherService.getById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> create(@RequestBody TeacherRequest teacherRequest) {
        return new ResponseEntity<>(teacherService.create(teacherRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        teacherService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeacherResponse> updateById(
            @PathVariable final Long id,
            @RequestBody final TeacherRequest teacherRequest) {
        return new ResponseEntity<>(teacherService.updateById(id, teacherRequest), HttpStatus.ACCEPTED);
    }

}
