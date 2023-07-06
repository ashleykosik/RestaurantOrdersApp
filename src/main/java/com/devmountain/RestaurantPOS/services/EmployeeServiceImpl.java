package com.devmountain.RestaurantPOS.services;

import com.devmountain.RestaurantPOS.dtos.EmployeeDto;
import com.devmountain.RestaurantPOS.entities.Employee;
import com.devmountain.RestaurantPOS.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // add a new employee
    @Override
    @Transactional
    public List<String> addEmployee(EmployeeDto employeeDto) {
        List<String> response = new ArrayList<>();
        Employee employee = new Employee(employeeDto);
        //EmployeeRepository.saveAndFlush(employee);
        response.add("Employee Added Successfully");
        return response;
    }
    //verify credentials during login
    @Override
    @Transactional
    public List<String> employeeLogin(EmployeeDto employeeDto) {
        List<String> response = new ArrayList<>();
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeDto.getId());
        if (employeeOptional.isPresent()) {
            if (passwordEncoder.matches(employeeDto.getPassword(), employeeOptional.get().getPassword())) {
                response.add("Employee Login Successful");
                response.add(String.valueOf(employeeOptional.get().getId()));

            } else {
                response.add("Employee ID or password incorrect");
            }
        } else {
            response.add("Employee ID or password incorrect");

        }
        return response;

    }



}
