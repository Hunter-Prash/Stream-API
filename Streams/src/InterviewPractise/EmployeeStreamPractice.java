package InterviewPractise;

import java.util.*;
import java.util.stream.*;

public class EmployeeStreamPractice {

    record Employee(int id, String name, int salary, String dept) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(101, "John", 50000, "IT"),
                new Employee(102, "Alice", 70000, "HR"),
                new Employee(103, "Bob", 45000, "IT"),
                new Employee(104, "David", 90000, "Finance"),
                new Employee(105, "Priya", 65000, "HR"),
                new Employee(106, "Karthik", 80000, "IT")
        );


        Comparator<Employee> comparator = (a, b) -> a.name().compareTo(b.name());

        List<String> ans = employees.stream()
                .sorted(comparator)
                .filter(i -> i.salary() > 60000)
                .map(i -> i.name())
                .toList();

        //System.out.println(ans);


        //max sal among all employees
        int sal=employees.stream().mapToInt(Employee::salary).max().orElse(-1);
        employees.stream().filter(i->i.salary()==sal).forEach(i-> System.out.println(i.name()));

        //max sal among IT
        int sal2=employees.stream().filter(i->i.dept().equals("IT")).mapToInt(Employee::salary).max().orElse(-1);

        //get the names of the top 3 highest-paid employees, highest first, into a List<String> and print it.
        List<String>top3=employees.stream().sorted(Comparator.comparingInt(Employee::salary).reversed()).limit(3).map(i->i.name()).toList();
       // System.out.println(top3);

        //Using the same employees list: find how many employees are in each department.
        //Expected output (key order can differ):
        //{HR=2, Finance=1, IT=3}
        Map<String,Long>grpbydept=employees.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.counting()));
        //grpbydept.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(i-> System.out.println(i.getKey() + " " + i.getValue()));

        //Using the same employees list: find the average salary per department.
        //Expected output (order can differ):
        //{HR=67500.0, Finance=90000.0, IT=58333.333333333336}

        Map<String,Double>avgbydept =employees.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.averagingInt(Employee::salary)));
        //avgbydept.entrySet().stream().forEach(i-> System.out.println(i.getKey()+" "+i.getValue()));

        Map<String, String> result  =employees.stream().collect(Collectors.groupingBy(Employee::dept,Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingInt(Employee::salary)),
                opt -> opt.map(Employee::name).orElse("none"))));

        result.entrySet().forEach(i-> System.out.println(i.getKey()+ " " + i.getValue()));

    }
}
