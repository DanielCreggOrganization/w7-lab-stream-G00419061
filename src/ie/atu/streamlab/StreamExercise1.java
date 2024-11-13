package ie.atu.streamlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

}

public class StreamExercise1 {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22, 3.8));
        students.add(new Student("Bob", 19, 3.5));
        students.add(new Student("Charlie", 21, 3.9));
        students.add(new Student("Diana", 20, 3.7));
        students.add(new Student("Sophia", 20, 3.9));
        students.add(new Student("Liam", 22, 3.6));
        students.add(new Student("Ethan", 20, 3.9));

        students.stream()
        .filter(s -> s. getGpa()> 3.7)
        .sorted(Comparator.comparing(Student::getGpa).reversed())
        .map(s -> String.format("Name: %-10s Age: %-4s GPA: %.2f", s.getName(), s.getAge(), s.getGpa()))
        .forEach(System.out::println);
    }
}
