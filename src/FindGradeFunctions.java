import java.util.ArrayList;
import java.util.Collections;
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
                courseName = "Course";
            }
            System.out.print("Enter number of CW: ");
            int numOfCW = Integer.parseInt(scan.nextLine());
            for (int j = 0; j < numOfCW; j++) {
                if (courseName.equals("Course")) {
                    System.out.printf("Course[%d] - CW[%d]\n", i + 1, j + 1);
                } else {
                    System.out.printf("%s - CW[%d]\n", courseName, j + 1);
                }
                System.out.print("Grade: ");
                double grade = Double.parseDouble(scan.nextLine());

                if (grade == 0) {
                    System.out.println();
                    continue;
                }
                System.out.print("Percent: ");
                double percent = Integer.parseInt(scan.nextLine());
                System.out.println();
                course = new Course(grade, percent);
                sum += course.modifyGrade();
            }
            courses.addCoursesAndGrades(courseName, sum);
        }
    }

    public static void printCourses() {
        courses.printCourses();
    }

    public static void findStudentAverage() {
        Student student = new Student();
        for (int i = 1; i < 7; i++) {
            System.out.printf("Enter grade[%d]: ", i);
            double num = scan.nextDouble();
            student.addGrade(num);
        }
        double sum = 0;
        for (Double num : student.grades()) {
            sum += num;
        }
        System.out.printf("\n-->Average: %.2f<--\n\n", sum / student.size());
        student.clear();
    }

    public static void deleteItems() {
        while (true) {
            if (courses.size() == 0) {
                System.out.println("The list is currently empty!\n");
                break;
            }
            System.out.println("0. Exit || 1. Delete last || 2. Delete index || 3. Delete course || 4. Reset list");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scan.nextLine());

            if (choice == 0) {
                break;
            }
            if (choice == 1) { // deletes last item of list
                System.out.println("Deleted last entry\n");
                courses.removeCoursesAndGrades(courses.size() - 1);
                break;
            }
            if (choice == 2) { // deletes list items based on index
                System.out.print("Enter index to remove: ");
                int index = scan.nextInt();
                if (courses.size() - 1 < index - 1) {
                    System.out.println("There's no such index!\n");
                    continue;
                }
                System.out.printf("Deleted index %d\n\n", index);
                courses.removeCoursesAndGrades(index - 1);
                break;
            }
            if (choice == 3) { // deletes list items based on course name
                boolean found = false;
                System.out.print("Enter course to remove: ");
                String courseName = scan.nextLine();
                if (courses.contains(courseName))
                    System.out.println("Removed course: " + courseName);
                    System.out.println();
                    courses.removeCourse(courseName);
                    list.remove(i);
                    found = true;
                    break;
                    }
                if (!found) {
                    System.out.println("There's no course with this name!\n");
                }
            }
            if (choice == 4) { // deletes lists
                System.out.println("Deleted list\n");
                list.clear();
                coursesList.clear();
                break;
            }
        }
    }

    public static void findClassAverageScore(ArrayList<Double> gradesArray) {
        ArrayList<String> names = new ArrayList<>();
        System.out.print("Continue with: My classroom[1] | New classroom[2]? ");
        int answer = Integer.parseInt(scan.nextLine());
        if (answer == 1) {
            names = new ArrayList<>() {
                {
                    add("Panagiwths");
                    add("Iakwvos");
                    add("Spyros");
                    add("Alex K");
                    add("Alex N");
                    add("Swthrhs");
                    add("Periklhs");
                }
            };
        } else if (answer == 2) {
            System.out.print("How many students? ");
            int numOfStudents = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < numOfStudents; i++) {
                System.out.print("Student name: ");
                names.add(scan.nextLine());
            }
        }
        int numOfStudents = names.size();
        int numOfCourses = 6;
        double[][] courseGrades = new double[numOfCourses][numOfStudents];

        for (int i = 0; i < numOfCourses; i++) {
            System.out.println();
            for (int j = 0; j < numOfStudents; j++) {
                System.out.printf("Course[%d], %s: ", i + 1, names.get(j));
                double grade = Double.parseDouble(scan.nextLine());
                courseGrades[i][j] = grade; //loop that populates 2d array
                gradesArray.add(courseGrades[i][j]); // adds items to list
            }
        }
        for (int i = 0; i < numOfStudents; i++) {
            gradesArray.add(gradesArray.get(i) + gradesArray.get(i + numOfStudents) + gradesArray.get(i + numOfStudents * 2) + gradesArray.get(i + numOfStudents * 3) +
                    gradesArray.get(i + numOfStudents * 4) + gradesArray.get(i + numOfStudents * 5)); // adds to
            // every nth item

        }
        gradesArray.subList(0, numOfStudents * numOfCourses).clear(); //deletes old items in list

        for (int i = 0; i < numOfStudents; i++) {
            gradesArray.add(gradesArray.get(i) / numOfCourses); //adds modified numbers to list
        }
        gradesArray.subList(0, numOfStudents).clear(); //deletes old items in list

        double sum = 0;
        for (Double num : gradesArray) {
            sum += num; // adds items of list to sum and then divides them to find the average
        }
        System.out.printf("\n-->Class average: %.2f<--\n\n", sum / gradesArray.size());

        for (int i = 0; i < numOfStudents; i++) {
            System.out.printf("%d. %s: \t %.2f\n", i + 1,
                    names.get(gradesArray.indexOf(Collections.max(gradesArray))),
                    Collections.max(gradesArray)); // finds the name with the max grade
            names.remove(gradesArray.indexOf(Collections.max(gradesArray))); // deletes old name and grade and loops
            // again to find max
            gradesArray.remove(Collections.max(gradesArray));
        }
        System.out.println();
    }

    public static void logo() {
        String logo1 =
                "                                                                       \n" +
                        " ███████╗██╗███╗   ██╗██████╗  ██████╗ ██████╗  █████╗ ██████╗ ███████╗\n" +
                        " ██╔════╝██║████╗  ██║██╔══██╗██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██╔════╝\n" +
                        " █████╗  ██║██╔██╗ ██║██║  ██║██║  ███╗██████╔╝███████║██║  ██║█████╗  \n" +
                        " ██╔══╝  ██║██║╚██╗██║██║  ██║██║   ██║██╔══██╗██╔══██║██║  ██║██╔══╝  \n" +
                        " ██║     ██║██║ ╚████║██████╔╝╚██████╔╝██║  ██║██║  ██║██████╔╝███████╗\n" +
                        " ╚═╝     ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝\n";


        System.out.println(logo1);
    }
}
