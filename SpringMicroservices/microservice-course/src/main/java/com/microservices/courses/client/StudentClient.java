package com.microservices.courses.client;

import com.microservices.courses.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
// Nombre del microservicio al cual vamos a consultar y la url de la api

// Sin Api gateway--> ponemos directamente el puerto del microservicio  student
//@FeignClient(name="microservice-student", url="localhost:8090/api/student")

//Con api gateway --> ponemos el puerto del microservicio gateway que va a atender nuestras peticiones
@FeignClient(name="microservice-student", url="localhost:8080/api/student")
public interface StudentClient {

    /*endpoing donde vamos a hacer la consulta*/
    @GetMapping("/search_by_course/{id}")
        List<StudentDTO> findAllStudentsByCourse(@PathVariable Long id);

}
