package com.Employee_Service.controller;

import com.Employee_Service.entity.Employee;
import com.Employee_Service.repository.EmployeeRepo;
import com.Employee_Service.response.EmployeeResponse;
import com.Employee_Service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpolyeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeDetails(@PathVariable int id){
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
       return employeeResponse;
    }
}
