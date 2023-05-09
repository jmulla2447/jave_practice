package core.java.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeBaseStream {
    List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Engineering", 100000),
            new Employee("Bob", "Sales", 80000),
            new Employee("Charlie", "Engineering", 120000),
            new Employee("Dave", "Marketing", 90000),
            new Employee("Emily", "Sales", 95000),
            new Employee("Frank", "Marketing", 110000)
    );

    public void getEmployeesHighestPaidByDepartmentWise(){
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
    }

    public void getHighestPaidEmployee(){
        //1
        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).findFirst().get();
        //2
        Optional<Employee> highestPaidEmployee = employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary));
    }
}
