package com.microservices.courses.http.response;


import com.microservices.courses.dto.StudentDTO;
import lombok.*;

import java.util.List;

/*Respuesta personalizada*/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentByCourseResponse {
    private String course;
    private String teacher;
    private List<StudentDTO> students;
}
