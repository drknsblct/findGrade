import java.util.Scanner;


public class FindGrade {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        FindGradeFunctions.logo();

        while (true) {
            System.out.println("[1] Add Courses\t\t" +
                    "[4] Find Student Grade\n" +
                    "[2] View List\t\t" +
                    "[5] Delete Entries\n" +
                    "[3] Reset List\t\t" +
                    "[6] Find Classroom Average\n" +
                    "[0] Exit\n");
            System.out.print("Enter number: ");
            int answer = scan.nextInt();
            if (answer == 0) {
                System.out.println("Exiting program!\n");
                break;
            }
            if (answer == 1) {
                System.out.println("\n<<< Add Courses >>>");
                FindGradeFunctions.courses();
                FindGradeFunctions.printCourses();
            }
            if (answer == 2) {
                System.out.println("\n<<< View List >>>");
                if (FindGradeFunctions.courses.size() == 0) {
                    System.out.println("The list is currently empty!\n");
                    continue;
                }
                FindGradeFunctions.printCourses();
            }
            if (answer == 3) {
                System.out.println("\n<<< Reset List >>>");
                if (FindGradeFunctions.courses.size() == 0) {
                    System.out.println("The list is currently empty!\n");
                    continue;
                }
                FindGradeFunctions.courses.clear();
                System.out.println("Emptied list!\n");

            }
            if (answer == 4) {
                System.out.println("\n<<< Find Average Score >>>");
                FindGradeFunctions.findStudentAverage();
            }
            if (answer == 5) {
                System.out.println("\n<<< Delete Courses >>>");
                FindGradeFunctions.deleteItems();
            }
            if (answer == 6) {
                System.out.println("\n<<< Find Classroom Average Score >>>");
                FindGradeFunctions.findClassAverageScore();
            }
        }
    }
}





