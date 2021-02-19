import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class FindGradeFunctions {
    public static double modifyGrade(double grade, double percent) {
        return grade * (percent / 100);
    }

    public static void courses(ArrayList<Double> list, ArrayList<String> coursesList) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int courses = Integer.parseInt(scan.nextLine());
        System.out.println();

        for (int i = 0; i < courses; i++) {
            double grade;
            double percent;
            double sum = 0;
            System.out.print("Enter name of course (press enter to skip): ");
            String course = scan.nextLine();
            if (course.equals("")) {
                course = "Course";
            }
            System.out.print("Enter number of CW: ");
            int cw = Integer.parseInt(scan.nextLine());
            for (int j = 0; j < cw; j++) {
                if (course.equals("Course")) {
                    System.out.printf("Course[%d] - CW[%d]\n", i + 1, j + 1);
                } else {
                    System.out.printf("%s - CW[%d]\n", course, j + 1);
                }
                System.out.print("Grade: ");
                grade = Double.parseDouble(scan.nextLine());

                if (grade == 0) {
                    System.out.println();
                    continue;
                }
                System.out.print("Percent: ");
                percent = Integer.parseInt(scan.nextLine());
                System.out.println();
                sum += modifyGrade(grade, percent);
            }
            coursesList.add(course);
            list.add(sum);
        }
    }

    public static void printArray(ArrayList<Double> list, ArrayList<String> coursesList) {
        double sum = 0;
        if (list.size() >= 2) {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s: %.2f\n", i + 1, coursesList.get(i), list.get(i));
            }
        }
        for (Double num : list) {
            sum += num;
        }
        System.out.printf("-->Average: %.2f<--\n\n", sum / list.size());
    }

    public static void findStudentAverage(ArrayList<Double> averageList) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            System.out.printf("Enter grade[%d]: ", i);
            double num = scan.nextDouble();
            averageList.add(num);
        }
        double sum = 0;
        for (Double num : averageList) {
            sum += num;
        }
        System.out.printf("\n-->Average: %.2f<--\n\n", sum / averageList.size());
    }

    public static void deleteItems(ArrayList<Double> list, ArrayList<String> coursesList) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (list.isEmpty()) {
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
                list.remove(list.size() - 1);
                coursesList.remove(coursesList.size() - 1);
                break;
            }
            if (choice == 2) { // deletes list items based on index
                System.out.print("Enter index to remove: ");
                int index = scan.nextInt();
                if (list.size() - 1 < index - 1) {
                    System.out.println("There's no such index!\n");
                    continue;
                }
                System.out.printf("Deleted index %d\n\n", index);
                list.remove(index - 1);
                coursesList.remove(index - 1);

                break;
            }
            if (choice == 3) { // deletes list items based on course name
                boolean found = false;
                System.out.print("Enter course to remove: ");
                String courseName = scan.nextLine();
                for (int i = 0; i < coursesList.size(); i++) {
                    if (courseName.equals(coursesList.get(i))) {
                        System.out.println("Removed course: " + courseName);
                        System.out.println();
                        coursesList.remove(courseName);
                        list.remove(i);
                        found = true;
                        break;
                    }
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
        Scanner scan = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>() {
            {
//                add("Student1");
//                add("Student2");
//                add("Student3");
//                add("Student4");
//                add("Student5");
//                add("Student6");
//                add("Student7");
//                add("Student8");

                add("Panagiwths");
                add("Iakwvos");
                add("Spyros");
                add("Alex K");
                add("Alex N");
                add("Swthrhs");
                add("Iwshf");
                add("Periklhs");

            }
        };
        int numOfStudents = names.size();
        int numOfCourses = 6;
        double[][] courseGrades = new double[numOfCourses][numOfStudents];

        for (int i = 0; i < numOfCourses; i++) {
            System.out.println();
            for (int j = 0; j < numOfStudents; j++) {
                System.out.printf("Course[%d], Student[%d]: ", i + 1, j + 1);
                double grade = Double.parseDouble(scan.nextLine());
                courseGrades[i][j] = grade; //loop that populates 2d array
                gradesArray.add(courseGrades[i][j]); // adds items to list
            }
        }
        for (int i = 0; i < numOfStudents; i++) {
            gradesArray.add(gradesArray.get(i) + gradesArray.get(i + numOfStudents) + gradesArray.get(i + numOfStudents * 2) + gradesArray.get(i + numOfStudents * 3) +
                    gradesArray.get(i + numOfStudents * 4) + gradesArray.get(i + numOfStudents * 5)); // adds to every nth item

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
