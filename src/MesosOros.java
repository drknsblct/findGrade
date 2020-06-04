import java.util.ArrayList;
import java.util.Scanner;

public class MesosOros {


    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();

        courses(list);
        printArray(list);


    }

    public static double edit(double va9mos, double pososto) {
        return va9mos * (pososto / 100);
    }

    public static void courses(ArrayList<Double> list) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int courses = scan.nextInt();
        System.out.print("Enter number of ergasies: ");
        int ergasies = scan.nextInt();

        for (int i = 0; i < courses; i++) {
            double va9mos;
            double pososto;
            double sum = 0.0;

            for (int j = 0; j < ergasies; j++) {
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
        System.out.printf("Mesos oros: %.2f\n", sum / list.size());
    }
}




