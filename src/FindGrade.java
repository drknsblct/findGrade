import java.util.InputMismatchException;
import java.util.Scanner;


public class FindGrade {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        FindGradeFunctions.logo();


        while (true) {
            int answer;

            System.out.println("[1] Add Courses\t\t" +
                    "[4] Find Student Grade\n" +
                    "[2] View List\t\t" +
                    "[5] Delete Entries\n" +
                    "[3] Reset List\t\t" +
                    "[6] Find Classroom Average\n" +
                    "[0] Exit\n");
            System.out.print("Enter number: ");

            try {
                answer = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Wrong value!\n");
                continue;
            }


            switch (answer) {
                case 0:
                    System.out.println("Exiting program!\n");
                    break;

                case 1:
                    System.out.println("\n<<< Add Courses >>>");
                    FindGradeFunctions.courses();
                    FindGradeFunctions.printCourses();
                    break;

                case 2:
                    System.out.println("\n<<< View List >>>");
                    if (FindGradeFunctions.courses.size() == 0) {
                        System.out.println("The list is currently empty!\n");
                        continue;
                    }
                    FindGradeFunctions.printCourses();
                    break;

                case 3:
                    System.out.println("\n<<< Reset List >>>");
                    if (FindGradeFunctions.courses.size() == 0) {
                        System.out.println("The list is currently empty!\n");
                        continue;
                    }
                    FindGradeFunctions.courses.clear();
                    System.out.println("Emptied list!\n");
                    break;

                case 4:
                    System.out.println("\n<<< Find Average Score >>>");
                    FindGradeFunctions.findStudentAverage();
                    break;

                case 5:
                    System.out.println("\n<<< Delete Courses >>>");
                    FindGradeFunctions.deleteItems();
                    break;

                case 6:
                    System.out.println("\n<<< Find Classroom Average Score >>>");
                    FindGradeFunctions.findClassAverageScore();
                    break;

                default:
                    System.out.println("Input must be between 0 - 6\n");
            }
        }
    }
}





