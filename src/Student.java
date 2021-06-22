import java.util.ArrayList;

public class Student {
    private String name;
    private int grade;
    private ArrayList<Double> grades;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.grades = new ArrayList<>();
    }

    public Student() {
        this.grades = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public ArrayList<Double> grades(){
        return grades;
    }

    public int size(){
        return grades.size();
    }

    public void clear(){
        grades.clear();
    }

    public void addGrade(double grade){
        grades.add(grade);
    }

    @Override
    public String toString() {
        return String.format("%s, grade: %d", name, grade);
    }
}
