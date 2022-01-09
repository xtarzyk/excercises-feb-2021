package com.codecool.feb2021pl.springdemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {

    private List<Employee> employees = new ArrayList<>();

    public synchronized void save(Employee employee) {
        employees.add(employee);
    }

    public synchronized Optional<Employee> findEmployeeByName(String name) {
        // SELECT * FROM employees WHERE name = ?
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    public synchronized List<Employee> all() {
        ArrayList<Employee> employeesCopy = new ArrayList<>();
        employeesCopy.addAll(employees);
        return employeesCopy;
    }

}
