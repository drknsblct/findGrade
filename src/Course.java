public class Course {
    private double grade;
    private double percent;

    public Course(double grade, double percent) {
        this.grade = grade;
        this.percent = percent;
    }

    public double modifyGrade() {
        return grade * (percent / 100);
    }
}
