package com.microservices.student.controllers;

import com.microservices.student.models.Student;
import com.microservices.student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService){
        this.studentService = studentService;
    }


    @ResponseStatus(HttpStatus.CREATED) // STATUS HTTP  QUE SE MUESTRA SI SALE BIEN
    @PostMapping("/create")
    public void saveStudent(@RequestBody  Student student){
        studentService.saveStudent(student);
    }



    /*
        Response entity para devolver la entidad a solicitar
        PathVariable para mapear el parametro de la url
     * */
    @GetMapping("/search/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id")Long id){
        return ResponseEntity.ok(this.studentService.findStudentById(id)); //Retorno la entidad
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }

    @GetMapping("/search_by_course/{id}")
    public ResponseEntity<List<Student>> findByCourse(@PathVariable("id")Long id){
        return ResponseEntity.ok(this.studentService.getAllStudentsByCourseId(id));
    }

}
