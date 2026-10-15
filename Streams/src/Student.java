import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student>{
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other){
        return Integer.compare(this.marks,other.marks);
    }

    static void main(String[] args) {
        List<Student> students=new ArrayList<>();

        students.add(new Student("Rahul", 60));
        students.add(new Student("Amit", 40));
        students.add(new Student("Priya", 90));
        students.add(new Student("Neha", 70));

        students.stream().sorted().forEach(i-> System.out.println(i.getMarks()));


        Comparator<Student>x=(a,b)->a.getName().compareTo(b.getName());
        students.stream().sorted(x.reversed()).forEach(i-> System.out.println(i.getName()));
    }
}