import java.util.ArrayList;
import java.util.Scanner;


public class FindGrade {

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<Double> averageList = new ArrayList<>();
        ArrayList<String> coursesList = new ArrayList<>();

        //Find class average score
        ArrayList<Double> gradesArray = new ArrayList<>();

        FindGradeFunctions.logo();

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("[1] Add Courses\t\t" +
                    "[4] Find Student Grade\n" +
                    "[2] View List\t\t" +
                    "[5] Delete Entries\n" +
                    "[3] Reset List\t\t" +
                    "[6] Find Class Average\n" +
                    "[0] Exit\n");
            System.out.print("Enter number: ");
            int answer = scan.nextInt();
            if (answer == 0) {
                System.out.println("Exiting program!\n");
                break;
            }
            if (answer == 1) {
                System.out.println("\n<<< Add Courses >>>");
                FindGradeFunctions.courses(list, coursesList);
                FindGradeFunctions.printArray(list, coursesList);
            }
            if (answer == 2) {
                System.out.println("\n<<< View List >>>");
                if (list.isEmpty()) {
                    System.out.println("The list is currently empty!\n");
                    continue;
                }
                FindGradeFunctions.printArray(list, coursesList);
            }
            if (answer == 3) {
                System.out.println("\n<<< Reset List >>>");
                if (list.isEmpty()) {
                    System.out.println("The list is currently empty!\n");
                    continue;
                }
                System.out.println("Emptied list!\n");
                list.clear();
                coursesList.clear();
            }
            if (answer == 4) {
                System.out.println("\n<<< Find Average Score >>>");
                FindGradeFunctions.findStudentAverage(averageList);
                averageList.clear();
            }
            if (answer == 5) {
                System.out.println("\n<<< Delete Courses >>>");
                FindGradeFunctions.deleteItems(list, coursesList);
            }
            if (answer == 6) {
                System.out.println("\n<<< Find Class Average Score >>>");
                FindGradeFunctions.findClassAverageScore(gradesArray);
            }

        }
    }
}





