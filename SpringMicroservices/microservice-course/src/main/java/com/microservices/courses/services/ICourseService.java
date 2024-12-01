package com.microservices.courses.services;

import com.microservices.courses.http.response.StudentByCourseResponse;
import com.microservices.courses.models.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    void saveCourse(Course course);
    Course getCourseById(Long id);

    StudentByCourseResponse getStudentByCourse(Long id);

}
