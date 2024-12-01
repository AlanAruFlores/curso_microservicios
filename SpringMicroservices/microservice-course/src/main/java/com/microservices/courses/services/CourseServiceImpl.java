package com.microservices.courses.services;

import com.microservices.courses.client.StudentClient;
import com.microservices.courses.dto.StudentDTO;
import com.microservices.courses.http.response.StudentByCourseResponse;
import com.microservices.courses.models.Course;
import com.microservices.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{
    private CourseRepository courseRepository;
    private StudentClient studentClient;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient  = studentClient;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return this.courseRepository.findById(id).orElseThrow();
    }



    @Override
    public StudentByCourseResponse getStudentByCourse(Long id) {

        //Curso
        Course course = this.courseRepository.findById(id).orElse(new Course());

        //Estudiantes del curso
        List<StudentDTO> students = this.studentClient.findAllStudentsByCourse(id);


        //Generamos una instancia con builder
        return StudentByCourseResponse.builder()
                .course(course.getName())
                .teacher(course.getTeacher())
                .students(students)
                .build();
    }

}
