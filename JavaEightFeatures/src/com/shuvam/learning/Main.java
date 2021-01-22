package com.shuvam.learning;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee snow = new Employee("Snow White", 22);
        Employee jack = new Employee("Jack Hill", 40);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(tim);
        employeeList.add(snow);
        employeeList.add(jack);

        // forEach method accepts a Functional Interface Consumer, with action method implemented - done as a lambda here
        // Consumer interface requires its accept method to be implemented, doable via lambdas
        employeeList.forEach(employee -> {
            System.out.println(employee.getName() + ": " + employee.getAge());
        });
    }
}
