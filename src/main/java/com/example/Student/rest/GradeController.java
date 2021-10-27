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
    @GetMapping("{id}")
    public ResponseEntity<GradeResponse> getById(@PathVariable final Long id) {
        return new ResponseEntity<>(gradeService.getById(id), HttpStatus.FOUND);
    }
   @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable final Long id) {
        gradeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   @PutMapping("{id}")
    public ResponseEntity<GradeResponse> updateById(
            @PathVariable final Long id,
            @RequestBody GradeRequest gradeRequest) {
        return new ResponseEntity<>(gradeService.updateById(id, gradeRequest),HttpStatus.ACCEPTED);
   }

}
