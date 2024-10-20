package com.dileep.SpringSecurityProject.Controller;

import com.dileep.SpringSecurityProject.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(new Student(1,"Dileep",90),
            new Student(2, "Prathyu", 85)));

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
