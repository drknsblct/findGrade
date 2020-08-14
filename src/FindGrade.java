import java.util.ArrayList;
import java.util.Scanner;


public class FindGrade {
    static Scanner scan = new Scanner(System.in);



    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<Double> averageList = new ArrayList<>();
        ArrayList<String> coursesList = new ArrayList<>();

        //Find class average score
        ArrayList<Double> gradesArray = new ArrayList<>();

        FindGradeFunctions.logo();

        while (true) {
            System.out.println("[1] Add Courses\n" +
                    "[2] View Average Score\n" +
                    "[3] Reset List\n" +
                    "[4] Find Average Score\n" +
                    "[5] Delete Entries\n" +
                    "[6] Find Others Average Score\n" +
                    "[0] Exit\n");
            System.out.print("Choice: ");
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
                System.out.println("\n<<< View Average Score >>>");
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
                FindGradeFunctions.findAverage(averageList);
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


    //    public static void findFinalTest() {
//    }


}





