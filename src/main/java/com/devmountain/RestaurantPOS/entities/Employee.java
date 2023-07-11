package com.devmountain.RestaurantPOS.entities;

import com.devmountain.RestaurantPOS.dtos.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String address) {
        this.email = address;
    }


    public Employee(EmployeeDto employeeDto) {
        if (employeeDto.getId() != null) {
            this.id = employeeDto.getId();
        }
        if (employeeDto.getPassword() != null) {
            this.password = employeeDto.getPassword();
        }
        if (employeeDto.getFirstName() != null) {
            this.firstName = employeeDto.getFirstName();
        }
        if (employeeDto.getLastName() != null) {
            this.lastName = employeeDto.getLastName();
        }
        if (employeeDto.getPhoneNumber() != null) {
            this.phoneNumber = employeeDto.getPhoneNumber();
        }
        if (employeeDto.getEmail() != null) {
            this.email = employeeDto.getEmail();
        }
    }

}
