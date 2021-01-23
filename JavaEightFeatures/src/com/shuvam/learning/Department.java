package com.shuvam.learning;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return new ArrayList<>(employeeList);
    }

    public void addEmployee(Employee e) {
        this.employeeList.add(e);
    }
}
