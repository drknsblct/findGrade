import java.util.ArrayList;
import java.util.Objects;

public class Courses extends ArrayList{
    private ArrayList<String> courses;
    private ArrayList<Double> grades;

    public Courses() {
        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    private void addCourse(String course) {
        courses.add(course);
    }

    private void addGrade(Double grade) {
        grades.add(grade);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    public void removeGrades(Double grade) {
        grades.remove(grade);
    }
    private void removeCourse(int i) {
        courses.remove(i);
    }

    private void removeGrades(int i) {
        grades.remove(i);
    }

    public void removeCoursesAndGrades(String course, Double grades) {
        removeCourse(course);
        removeGrades(grades);
    }

    public void removeCoursesAndGrades(int i) {
        removeCourse(i);
        removeGrades(i);
    }

    public void addCoursesAndGrades(String course, Double grades) {
        addCourse(course);
        addGrade(grades);
    }

    public int size(){
        return courses.size();
    }

    public void printCourses() {
        double sum = 0;
        if (grades.size() >= 1) {
            for (int i = 0; i < grades.size(); i++) {
                System.out.printf("%d. %s: %.2f\n", i + 1, courses.get(i), grades.get(i));
            }
        }
        for (Double num : grades) {
            sum += num;
        }
        System.out.printf("\n-->Average: %.2f<--\n\n", sum / grades.size());
    }
    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }
//

}


