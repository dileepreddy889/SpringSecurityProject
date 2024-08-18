package com.dileep.SpringSecurityProject.Controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SecurityController {



    @GetMapping("/")
    public ResponseEntity<String> greet(HttpServletRequest request) {
        String result = "This is Welcome Page " + request.getSession().getId();
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>("There is not String Available",HttpStatus.BAD_REQUEST);
    }


}
