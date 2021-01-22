package com.shuvam.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee snow = new Employee("Snow White", 22);
        Employee jack = new Employee("Jack Hill", 40);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(tim);
        employeeList.add(snow);
        employeeList.add(jack);

        // Predicate interface requires its test method to be implemented, done via lambda below
        printEmployeesByAge(employeeList, "Employees over age 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employeeList, "Employees of age 30 and under", employee -> employee.getAge() <= 30);
        printEmployeesByAge(employeeList, "Employees of under age 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        // Predicate that works only on integers
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lesserThan100 = i -> i < 100;
        System.out.println(greaterThan15.test(20)); // true
        System.out.println(greaterThan15.test(5)); // false

        // Predicates can be chained together
        // Predicate also contains and, or, negate and isEqual methods
        // The more specific Predicate interfaces do not contain isEqual method, but everything else
        System.out.println(greaterThan15.and(lesserThan100).test(20)); // false
        System.out.println(greaterThan15.and(lesserThan100).test(105)); // true

        // Using a Supplier interface whose get method (taking no args) is implemented via lambdas, to return random values
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);

        for(int i = 0; i<10; i++) {
            System.out.println(randomSupplier.get());
        }

    }

    public static void printEmployeesByAge(List<Employee> employeeList,
                                           String ageText,
                                           Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("====================");
        for(Employee employee: employeeList) {
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
