import java.util.*;

public class Courses {

    private HashMap<String, Double> courseMap;

    public Courses() {
        this.courseMap = new LinkedHashMap<>();
    }

    public void addCourseAndGrade(String course, double grade) {
        courseMap.put(course, grade);
    }

    public int size() {
        return courseMap.size();
    }

    public void printCourses() {
        double sum = 0;

        for (String name : courseMap.keySet()) {
            double value = courseMap.get(name);
            System.out.printf("%s: %.2f\n", name, value);
        }
        for (Double num : courseMap.values()) {
            sum += num;
        }
        System.out.printf("\n-->Average: %.2f<--\n\n", sum / courseMap.size());
    }

    public boolean contains(String name) {
        return courseMap.containsKey(name);
    }

    public void remove(String course) {
        courseMap.remove(course);
    }

    public void clear() {
        courseMap.clear();
    }

}



