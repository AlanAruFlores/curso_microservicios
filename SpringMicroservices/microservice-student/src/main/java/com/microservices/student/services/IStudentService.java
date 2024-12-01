package com.microservices.student.services;

import com.microservices.student.models.Student;

import java.util.List;

public interface IStudentService  {
    List<Student> getAllStudents();
    Student findStudentById(Long id);
    void saveStudent(Student student);
    List<Student> getAllStudentsByCourseId(Long courseId);
}
