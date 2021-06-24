package objClasses;

import java.util.ArrayList;

public class Classroom {
    private ArrayList<Student> students;


    public Classroom() {
        this.students = new ArrayList<>();
    }

    public Student getStudent(int i){
        return students.get(i);
    }

    public String getStudentName(int i){
        return students.get(i).getName();
    }

    public double sumOfGrades(){
        double sum = 0;
        for (Student st: students) {
//            sum += st.getGrade()/6;
            sum += st.getGradeDivSix();

        }
        return sum;
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
        Student best = students.get(0);
        for (Student student : students) {
            if(student.getGrade() > best.getGrade()) {
                best = student;
            }
        }
        return best;
    }
    public Student returnBest() {
        Student best = best();
        students.remove(best);
        return best;
    }

    public double average(){
        return sumOfGrades() / size();
    }
}

