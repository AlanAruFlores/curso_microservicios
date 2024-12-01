package com.microservices.student.repositories;

import com.microservices.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Otra forma de hacer lo mismo
    /*
    @Query("SELECT s from Student s where s.idCourse = :idCourse")
    List<Student> findStudents(Long idCourse);
    */


    List<Student> findAllByIdCourse(Long idCourse);
}
