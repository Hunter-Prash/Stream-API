import com.sun.jdi.IntegerValue;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    static class Employee {
        private int id;
        private String name;
        private int salary;
        private String department;

        Employee(int id, String name, int salary, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getSalary() { return salary; }
        public String getDepartment() { return department; }

    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Alice", 50000, "HR"),
                new Employee(102, "Alice", 70000, "IT"),
                new Employee(103, "Bob", 90000, "Finance"),
                new Employee(104, "David", 90000, "IT")
        );

        //get salary asc
        Comparator<Employee> x= (a,b)->Integer.compare(a.getSalary(),b.getSalary());
        employees.stream().sorted(x).forEach(i-> System.out.println(i.getSalary()));

        //get name asc
        Comparator<Employee>y=(a,b)->a.getName().compareTo(b.getName());
        employees.stream().sorted(y).forEach(i-> System.out.println(i.getName()));

        //get avg sal
        double safsdf=employees.stream().mapToDouble(i->i.getSalary()).average().orElse(-1);
        System.out.println(safsdf);

        //group by salary
        Map<Integer, List<Employee>> res = employees.stream()
                .collect(Collectors.groupingBy(
                        i -> i.getSalary(),
                        Collectors.toList()
                ));

        //grp by 1st letter of name
        Map<Character, List<Employee>> res2 = employees.stream()
                .collect(Collectors.groupingBy(
                        i -> i.getName().charAt(0),
                        Collectors.toList()
                ));

        //Separate employees into high-salary and lower-salary groups.
        Map<Boolean,List<Employee>> res3=employees.stream().collect(Collectors.partitioningBy(i->i.getSalary()>=60000));

        //Separate employees into employees whose names start with a vowel and everyone else.
        Map<Boolean, List<Employee>>res4=employees.stream().collect(Collectors.partitioningBy(i->{
            String firstLetter=i.getName().toLowerCase().substring(0,1);
            return "aeiou".contains(firstLetter);
        }));

        System.out.println(res);
        System.out.println(res2);
        System.out.println(res4);

        //count occureneces of peoplwe with same name

        Map<String, Long> nameCounts = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.counting()
                ));

        nameCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue())
                );


        //find highest paid employee
        Comparator<Employee>asfdasdf=(a,b)->Integer.compare(a.getSalary(),b.getSalary());
        employees.stream().sorted(asfdasdf.reversed()).limit(1).forEach(i-> System.out.println(i.getName()));

        //find highest paid emp per dept
        Map<String,Optional<Employee>> m=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

        m.forEach((department, employee) ->
                System.out.println(
                        department + " -> " +
                                employee.map(e -> e.getName() + " - " + e.getSalary())
                                        .orElse("No employee")
                )
        );

        //find all deps with >=2 employees
        Map<String,Long>re=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        re.entrySet().stream().filter(i->i.getValue()>=2).forEach(i-> System.out.println(i.getKey()));
    }
}