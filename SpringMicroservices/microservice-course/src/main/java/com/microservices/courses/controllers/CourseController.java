package com.microservices.courses.controllers;

import com.microservices.courses.http.response.StudentByCourseResponse;
import com.microservices.courses.models.Course;
import com.microservices.courses.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private ICourseService courseService;

    @Autowired
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(this.courseService.getAllCourses());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.courseService.getCourseById(id));
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course) {
       this.courseService.saveCourse(course);
    }


    @GetMapping("/search-students/{id}")
    public ResponseEntity<StudentByCourseResponse> findStudentsByIdCourse(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.courseService.getStudentByCourse(id));
    }
}
