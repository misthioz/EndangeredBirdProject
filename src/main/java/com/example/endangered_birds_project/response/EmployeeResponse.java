package com.example.endangered_birds_project.response;

import com.example.endangered_birds_project.entity.Employee;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeResponse {
    @Getter int id;
    @Getter String name;
    @Getter LocalDate date_of_birth;
    @Getter String role;
    @Getter String email;

    public EmployeeResponse(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.date_of_birth = employee.getDate_of_birth();
        this.role = employee.getRole();
        this.email = employee.getEmail();
    }

    public static List<EmployeeResponse> convert(List<Employee> employees){
        return employees.stream().map(EmployeeResponse::new).collect(Collectors.toList());
    }
}
