package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@SpringBootApplication
public class DifferenceBetweenJpaHibernateAndSpringDataJpaApplication implements CommandLineRunner {
    @Autowired 
    private EmployeeService  employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DifferenceBetweenJpaHibernateAndSpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setDepartment("H");
        emp.setSalary(500000);
        employeeService.addEmployee(emp);
        System.out.println("Employee added successfully");
    }
}
