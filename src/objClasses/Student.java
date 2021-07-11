package objClasses;

public class Student {
    private double grade;
    private String name;


    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public void addGrade(double grade) {
        this.grade += grade;
    }

    public double getGrade() {
        return grade;
    }

    public void clearGrades() {
        grade = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s: \t %.2f", name, grade / 6);

    }
}
