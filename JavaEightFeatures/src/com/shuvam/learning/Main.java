package com.shuvam.learning;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /*
    The interfaces in the java.util.function package don't have any meaning as themselves. They describe the
    arguments and return value, but do not dictate actually what the implementations must do.
    They're not like interfaces such as Runnable which represents an object with a block of executable code,
    or an event handler which contains code that will run when the user interacts with the user interface component.
    As an example, when we want to use a lambda expression that tests a value and returns true false we, can use a Predicate.
    When we want to use a lambda expression in place for method that accepts an argument and returns a value we can use Function.
     */
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee snow = new Employee("Snow White", 22);
        Employee jack = new Employee("Jack Hill", 21);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(tim);
        employeeList.add(snow);
        employeeList.add(jack);
        employeeList.add(red);
        employeeList.add(charming);

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

        /*
        Functional Interfaces looked at so far:
            Consumer does not return a value (action)
            Supplier doesn't accept any parameters (get)
            Predicate only returns true or false (test)
            Function interface fits the criteria that takes one parameter and returns a value (apply)
        */

        // syntax: Function<Input type, Output type>
        Function<Employee, String> getLastName = employee -> {
                return employee.getName().substring(employee.getName().indexOf( " " ) + 1);
        };

        Function<Employee, String> getFirstName = employee -> {
            return employee.getName().substring(0, employee.getName().indexOf( " " ));
        };

        // Print LastName, FirstName
        employeeList.forEach(e -> {
                System.out.println(getLastName.apply(e) + ", " + getFirstName.apply(e));
        });

        Random random1 = new Random();
        for(Employee employee:employeeList) {
            if (random1.nextBoolean()) {
                System.out.println("Last Name: " + getAName(getLastName, employee));
            } else {
                System.out.println("First Name: " + getAName(getFirstName, employee));
            }
        }

        System.out.println("====================");

        // Chaining multiple functions and making a new function
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employeeList.get(1))); // prints TIM

        // BiFunction interface is an interface that accept two arguments
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employeeList.get(1));
        System.out.println(concatAge.apply(upperName, employeeList.get(1)));

        // Unary operator interface accepts a single argument and returns a value of the same type as the argument
        UnaryOperator<Integer> iPlus5 = i -> i+5;
        System.out.println(iPlus5.apply(10)); // 15

        BiPredicate<Employee, Integer> employeeAgeCheck = new BiPredicate<Employee, Integer>() {
            @Override
            public boolean test(Employee employee, Integer age) {
                return employee.getAge() > age;
            }
        };
        System.out.println("Employee is older than 20: " + employeeAgeCheck.test(employeeList.get(1), 20));

        streamsPartOne();

        Department hr = new Department("HR");
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        hr.addEmployee(john);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(tim);
        accounting.addEmployee(charming);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        /*
         Use flatMap method that requires a function that returns a stream
         For each department, we call the getEmployees method which returns a list on which we call the stream method
         to return a stream of employees. Now the items in this stream were added to the stream that will be returned
         from the flatMap method. In the case of a HR department, we have gone from one department object to 3 Employee
         objects. Thi method is called flat map because it is often used to flatten nested lists. Here, we have lists
         of employees nested within the department list, so the flatMap method is the one to use when we want to perform
         operations on the list but the list isn't the source. We use the method to create a stream of all the objects
         in those lists.
         */
        departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .forEach(System.out::println); // Prints the toString equivalent
                //.forEach(s->System.out.println(s));

        /*
        Store the contents thus generated using Stream::collect method
        The first version of the collect method stores the contents of the stream operations used as a terminal
        operation. This method of collect usage accepts a Collector which is an interface to the java.util.stream
        package, which maps the collector to the arguments required.
         */
        List<Employee> departmentEmployeesCollect1 = departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .collect(Collectors.toList());

        /*
        The second version of the collect method expects 3 arguments - a supplier, a BiConsumer accumulator and a
        BiConsumer combiner. These arguments must be specific about how we want the items to be added to the result of
        the collect method. E.g., if we wanted to end up with an ArrayList rather than a list, we can use the more
        specific collect version of the method to actually do this.
         */
        List<Employee> departmentEmployeesCollect2 = departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Map<Integer, List<Employee>> groupedByAge = departments
                                                    .stream()
                                                    .flatMap(department->department.getEmployeeList().stream())
                                                    .collect(Collectors.groupingBy(employee -> employee.getAge()));

        groupedByAge.forEach((age, employee) -> System.out.println(age + ":" + employee));

        departments.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2 )
                .ifPresent(System.out::println);

        /*
        Few notes about streams:
        1. We can't reuse them - if we try to, once we've called a terminal operation on a stream, we will receive an
        Illegal state exception if we try to operate on that stream again.
        2. Operations in streams are lazily evaluated. Intermediate operations are not performed until there's a
        terminal operation.
        3. We can use more specific stream interfaces when we're working with lists of numbers, e.g. int stream,
        long stream and double stream. These interfaces have additional methods like sum, min, max and a few others
        that are useful when working with numbers.
         */

        long c = Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "STT", "POC")
                .filter(s-> {
                    System.out.println(s);
                    return s.length() == 3;
                }).count(); // Without this terminal condition, the stream is not evaluated

        System.out.println("Count of elements with 3 characters: " + c);

    }

    public static void streamsPartOne() {
        System.out.println("-------Stream Example--------");
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36", "B12", "A30", "B6", "G53",
                "G49", "G70", "G56", "I27", "X28", "O71"
        );

        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers.forEach(number -> {
            if(number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });

        gNumbers.sort((s1, s2)->s1.compareTo(s2));
        gNumbers.forEach(s-> System.out.println(s));

        /*
        Stream is a sequence of elements supporting sequential and parallel aggregate operations.
        A stream is a set of object references. The stream method creates a stream from a collection.
        Each object reference in the stream corresponds to an object in the collection and the ordering of the
        object reference matches the ordering of the collection. When we want to use a stream that uses a collection
        as a source, the stream method will always be the first call.
        Any stream operations that we use have to meet two requirements:
        1. They must be non-interfering, which means that they don't change the stream source in any way.
        2. They must be stateless, so the result of an operation can't depend on any state outside of the operation.
        The map method ultimately returns a stream which contains all the uppercase bingo numbers, i.e. the results of
        calling the toUpperCase method on the input stream. It's called map because it is essentially mapping each item
        in the input stream to the results returned by the function argument. Now the resulting stream will have the
        same number of items as the source stream. In this case, the source stream is the result of the some bingo number.
         */
        System.out.println("-------Using Streams--------");
        // Collection someBingoNumbers is the source of the stream
        someBingoNumbers
                .stream()
                .map(String::toUpperCase) // Method reference, passed as a Function, same as s.toUpperCase()
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(s-> System.out.println(s)); // Nothing to return here, hence it is a terminal operation

        // Create a Stream from scratch
        Stream<String> iNumberStream = Stream.of("I26", "I17", "I29", "D71");
        Stream<String> nNumberStream = Stream.of("N12", "N81", "N89", "N41", "I29");
        Stream concatStream = Stream.concat(iNumberStream, nNumberStream);
        System.out.println("------------------------------------------");
        System.out.println("Concatenated stream # of distinct items: " +
                concatStream
                        .distinct()
                        .peek(s-> System.out.println(s)) // peek for debugging purposes, which accepts a Consumer interface with action method implemented
                        .count());

    }

    public static String getAName(Function<Employee, String> function, Employee employee) {
        return function.apply(employee);
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
