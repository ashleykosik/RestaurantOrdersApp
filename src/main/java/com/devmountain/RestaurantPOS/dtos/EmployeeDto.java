package com.devmountain.RestaurantPOS.dtos;

import com.devmountain.RestaurantPOS.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;

    public EmployeeDto (Employee employee) {
        if (employee.getId() != null) {
            this.id = employee.getId();
        }
        if (employee.getFirstName() != null) {
            this.firstName = employee.getFirstName();
        }
        if (employee.getLastName() != null) {
            this.lastName = employee.getLastName();
        }
        if (employee.getPassword() != null) {
            this.password = employee.getPassword();
        }
        if (employee.getPhoneNumber() != null) {
            this.phoneNumber = employee.getPhoneNumber();
        }
        if (employee.getEmail() != null) {
            this.email = employee.getEmail();
        }

    }
}
