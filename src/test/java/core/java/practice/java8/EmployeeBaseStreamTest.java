package core.java.practice.java8;


import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

class EmployeeBaseStreamTest {

    private List<Employee> employees ;
    @BeforeEach
    public void init(){
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering", 100000),
                new Employee("Bob", "Sales", 80000),
                new Employee("Charlie", "Engineering", 120000),
                new Employee("Dave", "Marketing", 90000),
                new Employee("Emily", "Sales", 95000),
                new Employee("Frank", "Marketing", 110000)
        );
    }
    @org.junit.jupiter.api.Test
    public void getEmployeesHighestPaidByDepartmentWise() {
            EmployeeBaseStream employeeBaseStream = new EmployeeBaseStream();
            employeeBaseStream.getEmployeesHighestPaidByDepartmentWise();
    }

    @org.junit.jupiter.api.Test
    void getHighestPaidEmployee() {
    }
}
