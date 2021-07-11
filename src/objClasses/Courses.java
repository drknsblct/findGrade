package objClasses;

import java.util.HashMap;
import java.util.LinkedHashMap;

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

    public String returnCourses() {
        courseMap.keySet().forEach(name -> {
            double value = courseMap.get(name);
            System.out.printf("%s: %.2f\n", name, value);
        });
        double sum = courseMap.values().stream().mapToDouble(num -> num).sum();
        return String.format("\n-->Average: %.2f<--\n\n", sum / courseMap.size());
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



