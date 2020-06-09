import java.util.ArrayList;
import java.util.Scanner;

public class MesosOros {

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<Double> averageList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Courses || 2. View Average Score || 3. Reset List || 4. " +
                    "Find Average Score || 5. Delete Entries || 0. Exit");
            System.out.print("Choice: ");
            int answer = scan.nextInt();
            if (answer == 0) {
                System.out.println("Exiting program!\n");
                break;
            }
            if (answer == 1) {
                System.out.println("<<< Add Courses >>>");
                courses(list);
                printArray(list);
            }
            if (answer == 2) {
                System.out.println("<<< View Average Score >>>");
                if (list.size() == 0) {
                    System.out.println("The list is currently empty!\n");
                    continue;
                }
                printArray(list);
            }
            if (answer == 3) {
                System.out.println("<<< Reset List >>>");
                if (list.size() == 0) {
                    System.out.println("The list is currently empty!\n");
                    continue;
                }
                System.out.println("Emptied list!\n");
                list.clear();
            }
            if (answer == 4) {
                System.out.println("<<< Find Average Score >>>");
                findAverage(averageList);
                averageList.clear();
            }
            if (answer == 5) {
                System.out.println("<<< Delete Entries >>>");
                deleteItems(list);
            }

        }
    }

    public static double edit(double va9mos, double pososto) {
        return va9mos * (pososto / 100);
    }

    public static void courses(ArrayList<Double> list) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int courses = scan.nextInt();
        System.out.print("Enter number of CW: ");
        int cw = scan.nextInt();
        System.out.println();

        for (int i = 0; i < courses; i++) {
            double va9mos;
            double pososto;
            double sum = 0.0;

            for (int j = 0; j < cw; j++) {
                System.out.printf("Ma9hma[%d] - Ergasia[%d]\n", i + 1, j + 1);
                System.out.print("Va9mos: ");
                va9mos = scan.nextDouble();


                if (va9mos == 0) {
                    System.out.println();
                    continue;
                }
                System.out.print("Pososto: ");
                pososto = scan.nextInt();
                System.out.println();

                sum += edit(va9mos, pososto);
            }
            list.add(sum);
        }
    }

    public static void printArray(ArrayList<Double> list) {
        double sum = 0.0;
        if (list.size() >= 2) {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("Ma9hma[%d]: ", i + 1);
                System.out.printf("%.2f\n", list.get(i));
            }
        }
        for (Double num : list) {
            sum += num;

        }
        System.out.printf("-->Mesos oros: %.2f<--\n\n", sum / list.size());
    }

    //dexetai thn telikh va9mologia ka9e ma9hmatos kai vriskei to teliko meso oro
    public static void findAverage(ArrayList<Double> averageList) {
        Scanner scan = new Scanner(System.in);
        int i = 1;
        while (true) {
            System.out.printf("Enter number[%d]: ", i);
            double num = scan.nextDouble();
            if (num == 0) {
                break;
            }
            averageList.add(num);
            i++;
        }
        double sum = 0.0;
        for (Double num : averageList) {
            sum += num;
        }
        System.out.printf("-->Mesos oros: %.2f<--\n\n", sum / averageList.size());
    }

    public static void deleteItems(ArrayList <Double> list) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("0. Exit || 1. Delete last || 2. Delete index || 3. Reset list");
            System.out.print("Choice: ");
            int choice = scan.nextInt();

            if (choice == 0) {
                break;
            }
            if (choice == 1) {
                if (list.size() == 0){
                    System.out.println("The list is currently empty!\n");
                    break;
                }
                System.out.println("Deleted last entry\n");
                list.remove(list.size()-1);
                break;
            }
            if (choice == 2) {
                System.out.print("Enter index to remove: ");
                int index = scan.nextInt();
                if (list.size()-1 < index){
                    System.out.println("There's no such index!\n");
                    continue;
                }
                System.out.printf("Deleted index %d\n\n", index);
                list.remove(index);
                break;
            }
            if (choice == 3) {
                if (list.size() == 0){
                    System.out.println("The list is currently empty!\n");
                    break;
                }
                System.out.println("Deleted list\n");
                list.clear();
                break;
            }

        }
    }
    public static void findFinalTest(){
        
    }
}


