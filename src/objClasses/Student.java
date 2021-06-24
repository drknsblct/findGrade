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

    //could delete this function
    public double getGradeDivSix() {
        return grade / 6;
    }

    public void clearGrades() {
        grade = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        //replace getGradeDivSix() with grade/6
//        if(name.length() <= 5){
//            return String.format("%s: \t\t %.2f", name, getGradeDivSix());
//        }
        return String.format("%s: \t %.2f", name, getGradeDivSix());

    }
}
