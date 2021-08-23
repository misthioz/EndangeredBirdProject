package com.example.endangered_birds_project.controller;

import com.example.endangered_birds_project.entity.Employee;
import com.example.endangered_birds_project.repository.EmployeeRepository;
import com.example.endangered_birds_project.request.EmployeeRequest;
import com.example.endangered_birds_project.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public List<EmployeeResponse> listEmployees(){
        List<Employee> elist = employeeRepository.findAll();
        return EmployeeResponse.convert(elist);
    }

    @GetMapping("/{id}")
    public EmployeeResponse findEmployeeById(@PathVariable int id){
        Employee employee = employeeRepository.getById(id);
        return new EmployeeResponse(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> addEmployee(
            @RequestBody EmployeeRequest employeeRequest,
            UriComponentsBuilder uriComponentsBuilder){
        Employee employee = employeeRequest.convert();
        employeeRepository.save(employee);

        URI uri = uriComponentsBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeResponse(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> edit(@PathVariable int id, @RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeRequest.convertAtualiza(id);
        employeeRepository.save(employee);

        return ResponseEntity.ok(new EmployeeResponse(employee));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable int id){
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
