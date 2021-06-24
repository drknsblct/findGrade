import objClasses.Classroom;
import objClasses.Course;
import objClasses.Courses;
import objClasses.Student;

import java.util.Scanner;


public class FindGradeFunctions {
    static Scanner scan = new Scanner(System.in);
    static Courses courses = new Courses();


    public static void courses() {
        Course course;
        System.out.print("Enter number of courses: ");
        int numOfCourses = Integer.parseInt(scan.nextLine());
        System.out.println();

        for (int i = 0; i < numOfCourses; i++) {
            double sum = 0;
            System.out.print("Enter name of course (press enter to skip): ");
            String courseName = scan.nextLine();

            if (courseName.equals("")) {
                courseName = String.format("Course[%d]", i + 1);
            }
            System.out.print("Enter number of CW: ");
            int numOfCW = Integer.parseInt(scan.nextLine());

            for (int j = 0; j < numOfCW; j++) {
                System.out.printf("%s - CW[%d]\n", courseName, j + 1);
                System.out.print("Grade, Percent: ");
                String[] input = scan.nextLine().split(",");

                double grade = Double.parseDouble(input[0]);
                double percent = Double.parseDouble(input[1]);
                System.out.println();

                course = new Course(grade, percent);
                sum += course.modifyGrade();
            }
            courses.addCourseAndGrade(courseName, sum);
        }
    }

    public static void printCourses() {
        courses.printCourses();
    }

    public static void findStudentAverage() {
        Student student = new Student();
        for (int i = 1; i < 7; i++) {
            System.out.printf("Enter grade[%d]: ", i);
            double grade = scan.nextDouble();
            student.addGrade(grade);
        }

        System.out.printf("\n-->Average: %.2f<--\n\n", student.getGrade() / 6);
        student.clearGrades();
    }

    public static void deleteItems() {
        while (true) {
            if (courses.size() == 0) {
                System.out.println("The list is currently empty!\n");
                break;
            }
            System.out.println("0. Exit || 1. Delete course || 2. Reset list");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scan.nextLine());

            if (choice == 0) {
                System.out.println();
                break;
            }

            if (choice == 1) { // deletes list items based on course name
                System.out.print("Enter course to remove: ");
                String courseName = scan.nextLine().toLowerCase();
                if (courses.contains(courseName)) {
                    System.out.println("Removed course: " + courseName);
                    System.out.println();
                    courses.remove(courseName);
                    break;
                }
                System.out.println("There's no course with this name!\n");
            }

            if (choice == 2) { // deletes lists
                System.out.println("Deleted list\n");
                courses.clear();
                break;
            }
        }
    }

    public static void findClassAverageScore() {
        Classroom classroom = new Classroom();
        int answer;
        do {
            System.out.print("Continue with: My classroom[1] | New classroom[2]? ");
            answer = Integer.parseInt(scan.nextLine());
        } while (answer != 1 && answer != 2);


        if (answer == 1) {
            classroom.addStudent(new Student("Panos"));
            classroom.addStudent(new Student("Iakwvos"));
            classroom.addStudent(new Student("Spyros"));
            classroom.addStudent(new Student("Alex K"));
            classroom.addStudent(new Student("Alex N"));
            classroom.addStudent(new Student("Swthrhs"));
            classroom.addStudent(new Student("Periklhs"));
        } else {
            System.out.print("How many students? ");
            int loops = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < loops; i++) {
                System.out.print("Student name: ");
                classroom.addStudent(new Student(scan.nextLine()));
            }
        }

        int numOfStudents = classroom.size();
        int numOfCourses = 6;

        for (int i = 0; i < numOfCourses; i++) {
            System.out.println();
            for (int j = 0; j < numOfStudents; j++) {
                System.out.printf("Course[%d], %s:\t", i + 1, classroom.getStudentName(j));
                double grade = Double.parseDouble(scan.nextLine());
                classroom.addGradeToStudent(classroom.getStudent(j), grade);
            }
        }

        System.out.printf("\n-->Classroom average: %.2f<--\n\n", classroom.average());
        int i = 1;
        while (!(classroom.size() == 0)) {
            System.out.println(i + ". " + classroom.returnBest());
            i++;
        }
        System.out.println("\n");
    }

    public static void logo() {
        String logo =
                "                                                                       \n" +
                        " ███████╗██╗███╗   ██╗██████╗  ██████╗ ██████╗  █████╗ ██████╗ ███████╗\n" +
                        " ██╔════╝██║████╗  ██║██╔══██╗██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██╔════╝\n" +
                        " █████╗  ██║██╔██╗ ██║██║  ██║██║  ███╗██████╔╝███████║██║  ██║█████╗  \n" +
                        " ██╔══╝  ██║██║╚██╗██║██║  ██║██║   ██║██╔══██╗██╔══██║██║  ██║██╔══╝  \n" +
                        " ██║     ██║██║ ╚████║██████╔╝╚██████╔╝██║  ██║██║  ██║██████╔╝███████╗\n" +
                        " ╚═╝     ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝\n";


        System.out.println(logo);
    }
}

