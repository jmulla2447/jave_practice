package core.java.practice.j8.stm;

import java.util.*;
import java.util.stream.Collectors;

public class TestEmployee {
    private static List<Employee> employeeList = new ArrayList<Employee>();

    static {
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new
                Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new
                Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new
                Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new
                Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new
                Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new
                Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new
                Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new
                Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new
                Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new
                Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new
                Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new
                Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new
                Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new
                Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new
                Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new
                Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    }

    public static void main(String[] args) {
//        How many male and female employees are there in the organization?
        howManyMaleAndFemaleEmp();
//> Print the name of all departments in the organization?
        printNameOfAllDepartment();
//> What is the average age of male and female employees?
        avarageAgePerGender();
//> Getthe details of highest paid employee in the organization?
        highestPayedEmployee();
//                Get the names of all employees who have joined after 2015?
        filterEmployeeWhoJoined2015();
//• Count the number of employees in each department?
        departmentWiseEmployeeCount();
//> What is the average salary of each department?
        avgSalaryPerDepartmentWise();

//        Get the details of youngest male employee in the product development department?
        findYongestInPD();
//• Who has the most working experience in the organization?
        mostWorkingExperince();
// > How many male and female employees are there in the sales and marketing team?
        howManyMaleAndFemaleEmpInSalesAndMarketing();
//                What is the average salary of male and female employees?
        avgSalaryBasedOnGeneder();
//                List down the names of all employees in each department?
        departmentWiseEmployee();
//> What is the average salary and total salary of the whole organization?
        printTotalSalaryAndAvgSalary();
// > Separate the employees who are younger or equal to 25 years from those
        partitionEmpBasedOnAge();

//        employees who are older than 25 years? • Who is the oldest employee in the organization? What is his age and which
//        department he belongs to?
        oldestEmployeeBelongToWhichDepartment();
    }

    private static Employee oldestEmployeeBelongToWhichDepartment() {
        return employeeList.stream().max(Comparator.comparingInt(Employee::getYearOfJoining)).get();
    }

    private static Map<Boolean, List<Employee>> partitionEmpBasedOnAge() {
       return employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge()<=25));
    }

    private static void printTotalSalaryAndAvgSalary() {
        double totalSalary = employeeList.stream().map(employee -> employee.getSalary()).reduce((i,j) -> (i+j)).get();
        double avgSalary =  employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0.0d);
    }

    private static Map<String, List<Employee>> departmentWiseEmployee() {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    private static Map<String, Double> avgSalaryBasedOnGeneder() {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
    }

    private static Map<String, Long> howManyMaleAndFemaleEmpInSalesAndMarketing() {
        return employeeList.stream().filter(employee -> employee.equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

    private static Employee mostWorkingExperince() {
        return employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
    }

    private static Employee findYongestInPD() {
        return employeeList.stream().filter(employee -> employee.getDepartment().equals("Product Development"))
                .min(Comparator.comparingInt(Employee::getAge)).get();
    }

    private static Map<String, Double> avgSalaryPerDepartmentWise() {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    private static Map<String, Long> departmentWiseEmployeeCount() {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    private static List<Employee> filterEmployeeWhoJoined2015() {
        return employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).collect(Collectors.toList());
    }

    private static void highestPayedEmployee() {
        //below method return only the max salary not employee information
        employeeList.stream().map(Employee::getSalary).max(Double::compare).get();
        //
        employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
    }

    private static Map<String, Double> avarageAgePerGender() {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
    }

    private static void printNameOfAllDepartment() {
        employeeList.stream().map(Employee::getDepartment).forEach(System.out::println);
    }

    private static Map<String, Long> howManyMaleAndFemaleEmp() {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }


}
