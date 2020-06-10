import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MesosOros {

    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<Double> averageList = new ArrayList<>();
        ArrayList<String> coursesList = new ArrayList<>();

        //Find others average score
        ArrayList<Double> megaList = new ArrayList<>();
        ArrayList<Double> editedMegaList = new ArrayList<>();
        ArrayList<Double> list1 = new ArrayList<>();
        ArrayList<Double> list2 = new ArrayList<>();
        ArrayList<Double> list3 = new ArrayList<>();
        ArrayList<Double> list4 = new ArrayList<>();
        ArrayList<Double> list5 = new ArrayList<>();
        ArrayList<Double> list6 = new ArrayList<>();


        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Courses || 2. View Average Score || 3. Reset List || 4. " +
                    "Find Average Score || 5. Delete Entries || 6. Find Others Average Score || 0. Exit");
            System.out.print("Choice: ");
            int answer = scan.nextInt();
            if (answer == 0) {
                System.out.println("Exiting program!\n");
                break;
            }
            if (answer == 1) {
                System.out.println("<<< Add Courses >>>");
                courses(list, coursesList);
                printArray(list, coursesList);
            }
            if (answer == 2) {
                System.out.println("<<< View Average Score >>>");
                if (list.isEmpty()) {
                    System.out.println("The list is currently empty!\n");
                    continue;
                }
                printArray(list, coursesList);
            }
            if (answer == 3) {
                System.out.println("<<< Reset List >>>");
                if (list.isEmpty()) {
                    System.out.println("The list is currently empty!\n");
                    continue;
                }
                System.out.println("Emptied list!\n");
                list.clear();
                coursesList.clear();
            }
            if (answer == 4) {
                System.out.println("<<< Find Average Score >>>");
                findAverage(averageList);
                averageList.clear();
            }
            if (answer == 5) {
                System.out.println("<<< Delete Entries >>>");
                deleteItems(list, coursesList);
            }
            if (answer == 6) {
                System.out.println("<<< Find Others Average Score >>>");
                findOthersAverageScore(megaList, list1, list2, list3, list4, list5, list6, editedMegaList);
            }

        }
    }

    public static double edit(double va9mos, double pososto) {
        return va9mos * (pososto / 100);
    }

    public static void courses(ArrayList<Double> list, ArrayList<String> coursesList) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int courses = Integer.parseInt(scan.nextLine());
        System.out.print("Enter number of CW: ");
        int cw = Integer.parseInt(scan.nextLine());
        System.out.println();

        for (int i = 0; i < courses; i++) {
            double va9mos;
            double pososto;
            double sum = 0.0;
            System.out.print("Enter name of course: ");
            String course = scan.nextLine();
            if (course.equals("")) {
                course = "Ma9hma";
            }
            for (int j = 0; j < cw; j++) {
                if (course.equals("Ma9hma")) {
                    System.out.printf("Ma9hma[%d] - Ergasia[%d]\n", i + 1, j + 1);
                } else {
                    System.out.printf("%s - Ergasia[%d]\n", course, j + 1);
                }
                System.out.print("Va9mos: ");
                va9mos = Double.parseDouble(scan.nextLine());


                if (va9mos == 0) {
                    System.out.println();
                    continue;
                }
                System.out.print("Pososto: ");
                pososto = Integer.parseInt(scan.nextLine());
                System.out.println();

                sum += edit(va9mos, pososto);
            }
            coursesList.add(course);
            list.add(sum);
        }
    }

    public static void printArray(ArrayList<Double> list, ArrayList<String> coursesList) {
        double sum = 0.0;
        if (list.size() >= 2) {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s: %.2f\n", i + 1, coursesList.get(i), list.get(i));
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
            System.out.printf("Enter score[%d]: ", i);
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
            if (choice == 1) {
                System.out.println("Deleted last entry\n");
                list.remove(list.size() - 1);
                coursesList.remove(coursesList.size() - 1);
                break;
            }
            if (choice == 2) {
                System.out.print("Enter index to remove: ");
                int index = scan.nextInt();
                if (list.size() - 1 < index) {
                    System.out.println("There's no such index!\n");
                    continue;
                }
                System.out.printf("Deleted index %d\n\n", index);
                list.remove(index);
                coursesList.remove(index);

                break;
            }
            if (choice == 3) {
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
            if (choice == 4) {
                System.out.println("Deleted list\n");
                list.clear();
                coursesList.clear();
                break;
            }

        }
    }

    public static void findFinalTest() {
    }


    public static void findOthersAverageScore(ArrayList<Double> megaList, ArrayList<Double> list1,
                                              ArrayList<Double> list2, ArrayList<Double> list3,
                                              ArrayList<Double> list4, ArrayList<Double> list5,
                                              ArrayList<Double> list6, ArrayList<Double> editedMegalist) {
        ArrayList<String> names = new ArrayList<String>() {
            {
                add("Panagiwths");
                add("Iakwvos");
                add("Spyros");
                add("Kelaidiths");
                add("Ntostoglou");
                add("Swthrhs");
                add("Periklhs");
            }

        };
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 42; i++) {
            System.out.printf("Va9mos[%d]: ", i);
            double va9mos = Double.parseDouble(scan.nextLine());
            if (i % 7 == 0) {
                System.out.println();
            }
            if (i <= 7) {
                list1.add(va9mos);
            } else if (i <= 14) {
                list2.add(va9mos);
            } else if (i <= 21) {
                list3.add(va9mos);
            } else if (i <= 28) {
                list4.add(va9mos);
            } else if (i <= 35) {
                list5.add(va9mos);
            } else {
                list6.add(va9mos);
            }
        }

        for (int i = 0; i < 7; i++) {
            megaList.add(list1.get(i) + list2.get(i) + list3.get(i) + list4.get(i) + list5.get(i) + list6.get(i));
        }
        for (Double num : megaList) {
            editedMegalist.add(num / 6);
        }

        double sum = 0.0;
        for (Double num : editedMegalist) {
            sum += num;

        }
        System.out.printf("Class average: %.2f\n\n", sum / editedMegalist.size());

//        for (int i = 0; i < 7; i++) {
//            if (names.get(editedMegalist.indexOf(Collections.max(editedMegalist))).equals("Spyros")) {
//                System.out.printf("%d. %s: \t\t %.2f\n", i + 1,
//                        names.get(editedMegalist.indexOf(Collections.max(editedMegalist))),
//                        Collections.max(editedMegalist));
//                names.remove(editedMegalist.indexOf(Collections.max(editedMegalist)));
//                editedMegalist.remove(editedMegalist.indexOf(Collections.max(editedMegalist)));
//            } else {
//                System.out.printf("%d. %s: \t %.2f\n", i + 1,
//                        names.get(editedMegalist.indexOf(Collections.max(editedMegalist))),
//                        Collections.max(editedMegalist));
//                names.remove(editedMegalist.indexOf(Collections.max(editedMegalist)));
//                editedMegalist.remove(editedMegalist.indexOf(Collections.max(editedMegalist)));
//            }
//        }

        for (int i = 0; i < 7; i++) {
            System.out.printf("%d. %s: \t %.2f\n", i + 1,
                    names.get(editedMegalist.indexOf(Collections.max(editedMegalist))),
                    Collections.max(editedMegalist));
            names.remove(editedMegalist.indexOf(Collections.max(editedMegalist)));
            editedMegalist.remove(editedMegalist.indexOf(Collections.max(editedMegalist)));

        }
        System.out.println();
    }
}



