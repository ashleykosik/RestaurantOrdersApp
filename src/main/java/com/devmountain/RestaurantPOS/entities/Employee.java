package com.devmountain.RestaurantPOS.entities;

import com.devmountain.RestaurantPOS.dtos.EmployeeDto;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private int phoneNumber;

    @Column
    private String address;


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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee(Long id, String firstName, String lastName, String password, int phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Employee() {
    }

    public Employee(EmployeeDto employeeDto) {
        if (employeeDto.getId() != null) {
            this.id = employeeDto.getId();
        }
        if (employeeDto.getPassword() != null) {
            this.password = employeeDto.getPassword();
        }
    }

}
