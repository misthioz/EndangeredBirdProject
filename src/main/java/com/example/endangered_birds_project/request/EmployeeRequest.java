package com.example.endangered_birds_project.request;

import com.example.endangered_birds_project.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRequest {
    private String name;
    private LocalDate date_of_birth;
    private String role;
    private String email;

    public Employee convert(){
        Employee employee = new Employee();
        employee.setName(this.name);
        employee.setDate_of_birth(this.date_of_birth);
        employee.setRole(this.role);
        employee.setEmail(this.email);

        return employee;
    }

    public Employee convertAtualiza(int id){
        return new Employee(id, name, date_of_birth, role, email);
    }


}
