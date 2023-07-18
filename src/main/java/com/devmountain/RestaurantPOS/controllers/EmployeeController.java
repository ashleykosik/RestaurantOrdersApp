package com.devmountain.RestaurantPOS.controllers;

import java.util.List;

import com.devmountain.RestaurantPOS.dtos.EmployeeDto;
import com.devmountain.RestaurantPOS.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // handle employee registration
    @PostMapping("/register")
    public List<String> addEmployee (@RequestBody EmployeeDto employeeDto) {
        String passHash = passwordEncoder.encode(employeeDto.getPassword());
        employeeDto.setPassword(passHash);
        return employeeService.addEmployee(employeeDto);
    }

    //handle employee login
    @PostMapping("/login")
    public List<String> employeeLogin(@RequestBody EmployeeDto employeeDto) {
        return employeeService.employeeLogin(employeeDto);
    }
}
