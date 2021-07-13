import objClasses.Classroom;
import objClasses.Course;
import objClasses.Courses;
import objClasses.Student;

import java.util.Scanner;


public class FindGradeFunctions {
    static Scanner scan = new Scanner(System.in);
    static Courses courses = new Courses();


    public static void courses() {
        int numOfCourses;
        int numOfCW;
        String[] input;
        double grade;
        double percent;

        try {
            System.out.print("Enter number of courses: ");
            numOfCourses = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Setting to default of 1 course");
            numOfCourses = 1;
        }
        System.out.println();

        for (int i = 0; i < numOfCourses; i++) {
            double sum = 0;
            System.out.print("Enter name of course (press enter to skip): ");
            String courseName = scan.nextLine();

            if (courseName.isEmpty()) {
                courseName = String.format("Course[%d]", i + 1);
            }
            try {
                System.out.print("Enter number of CW: ");
                numOfCW = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Setting to default of 1 CW");
                numOfCW = 1;
            }

            for (int j = 0; j < numOfCW; j++) {
                System.out.printf("\n%s - CW[%d]\n", courseName, j + 1);
                System.out.print("Grade, Percent: ");
                input = scan.nextLine().split(",");

                try {
                    grade = Double.parseDouble(input[0]);
                    percent = Double.parseDouble(input[1]);
                } catch (Exception e) {
                    System.out.println("Forgot comma between values!");
                    j--;
                    continue;
                }

                if (!((grade >= 0 && grade <= 100) && (percent >= 0 && percent <= 100))) {
                    j--;
                    continue;
                }

                System.out.println();

                Course course = new Course(grade, percent);
                sum += course.modifyGrade();
            }
            courses.addCourseAndGrade(courseName, sum);
        }
    }

    public static void printCourses() {
        System.out.println(courses.returnCourses());
    }

    public static void findStudentAverage() {
        Student student = new Student();
        double grade;

        for (int i = 1; i < 7; i++) {
            try {
                System.out.printf("Enter grade[%d]: ", i);
                grade = Double.parseDouble(scan.nextLine());
            } catch (Exception e) {
                i--;
                continue;
            }

            if (!(grade >= 0 && grade <= 100)) {
                i--;
                continue;
            }

            student.addGrade(grade);
        }

        System.out.printf("\n-->Average: %.2f<--\n\n", student.getGrade() / 6);
        student.clearGrades();
    }

    public static void deleteItems() {
        int choice;
        while (true) {
            if (courses.size() == 0) {
                System.out.println("The list is currently empty!\n");
                break;
            }
            System.out.println("0. Exit || 1. Delete course || 2. Reset list");
            System.out.print("Choice: ");
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println();
                continue;
            }

            if (choice == 0) {
                System.out.println();
                break;
            }

            if (choice == 1) { // deletes list items based on course name
                System.out.print("Enter course to remove: ");
                String courseName = scan.nextLine();

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
        int answer = 0;
        int loops;
        double grade = 0;

        do {
            try {
                System.out.print("Continue with: My classroom[1] | New classroom[2]? ");
                answer = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println();
            }
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
            try {
                System.out.print("How many students? ");
                loops = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Setting default to 11\n");
                loops = 11;
            }
            for (int i = 0; i < loops; i++) {
                System.out.printf("Name[%d]: ", i+1);
                String name = scan.nextLine();
                if (name.equals("")){
                    name = String.format("Student[%d]", i+1);
                }
                classroom.addStudent(new Student(name));

            }
        }

        int numOfStudents = classroom.size();
        int numOfCourses = 6;

        for (int i = 0; i < numOfCourses; i++) {
            System.out.println();
            for (int j = 0; j < numOfStudents; j++) {
                try {
                    System.out.printf("Course[%d], %s:\t", i + 1, classroom.getStudentName(j));
                    grade = Double.parseDouble(scan.nextLine());
                } catch (Exception e){
                    System.out.println();
                    j--;
                    continue;
                }
                classroom.addGradeToStudent(classroom.getStudent(j), grade);
            }
        }

        System.out.printf("\n-->Classroom average: %.2f<--\n\n", classroom.average());
        int i = 1;
        while (!(classroom.size() == 0)) {
            System.out.println(i + ". " + classroom.best());
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

