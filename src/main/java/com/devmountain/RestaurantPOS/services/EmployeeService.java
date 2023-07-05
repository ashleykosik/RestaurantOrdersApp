package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.dtos.EmployeeDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EmployeeService {
    // add a new employee
    @Transactional
    List<String> addEmployee(EmployeeDto employeeDto);

    //verify credentials during login
    List<String> employeeLogin(EmployeeDto employeeDto);
}
