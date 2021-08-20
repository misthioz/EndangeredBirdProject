package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    EmployeeRepository employeeRepository;
}
