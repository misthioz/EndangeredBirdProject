package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.Employee;
import com.example.endangered_birds_project.repository.EmployeeRepository;
import com.example.endangered_birds_project.request.EmployeeRequest;
import com.example.endangered_birds_project.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<EmployeeResponse> addEmployee(
            @RequestBody EmployeeRequest employeeRequest,
            UriComponentsBuilder uriComponentsBuilder){
        Employee employee = employeeRequest.convert();
        employeeRepository.save(employee);

        URI uri = uriComponentsBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeResponse(employee));
    }
}
