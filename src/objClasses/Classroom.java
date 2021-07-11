package objClasses;

import java.util.ArrayList;
import java.util.Comparator;

public class Classroom {
    private ArrayList<Student> students;


    public Classroom() {
        this.students = new ArrayList<>();
    }

    public Student getStudent(int i) {
        return students.get(i);
    }

    public String getStudentName(int i) {
        return students.get(i).getName();
    }

    public void addStudent(Student name) {
        students.add(name);
    }

    public void addGradeToStudent(Student student, double grade) {
        student.addGrade(grade);
    }

    public int size() {
        return students.size();
    }

    public Student best() {
        //finds max student.getGrade() from students
        Student best = students.stream()
                .max(Comparator.comparing(Student::getGrade)).get();
        students.remove(best);
        return best;

    }

    public double average() {
        //divides each value / 6 and then sums the total
        return students.stream()
                .mapToDouble(Student::getGrade)
                .map(grade -> grade / 6)
                .sum() / size();
    }
}

