package com.microservices.student.services;

import com.microservices.student.models.Student;
import com.microservices.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long id) {
        return this.studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudentsByCourseId(Long courseId) {
        return this.studentRepository.findAllByIdCourse(courseId);
    }
}
