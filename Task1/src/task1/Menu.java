package task1;

import java.util.Scanner;

public class Menu {
    public static void mainMenu(){
        System.out.println("--------------------");
        System.out.println("Sports award menu");
        System.out.println("--------------------");
        System.out.println("List .............. 1");
        System.out.println("Select ............ 2");
        System.out.println("Sort .............. 3");
        System.out.println("Exit .............. 4");
        System.out.println("--------------------");
    }

    public static void listMenu(){
        System.out.println("--------------------");
        System.out.println("List menu");
        System.out.println("--------------------");
        System.out.println("All ............... 1");
        System.out.println("By sport .......... 2");
        System.out.println("By nation ......... 3");
        System.out.println("By team ........... 4");
        System.out.println("Back .............. 6");
        System.out.println("--------------------");
    }

    public static void selectMenu(){
        System.out.println("--------------------");
        System.out.println("Select menu");
        System.out.println("--------------------");
        System.out.println("By year ........... 1");
        System.out.println("By name ........... 2");
        System.out.println("By sport .......... 3");
        System.out.println("By nation ......... 4");
        System.out.println("By team ........... 5");
        System.out.println("Back .............. 6");
        System.out.println("--------------------");
    }

    public static void mainMenuLoop(){
        int choice = 0;
        while(choice != 4){
            mainMenu();
            choice = getInput();
            switch (choice) {
                case 1 -> listMenuLoop();
                case 2 -> selectMenuLoop();
                case 3 -> sortMenuLoop();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void listMenuLoop() {
        choice();
    }

    private static void sortMenuLoop() {
        choice();
    }

    private static void choice() {
        int choice = 0;
        while(choice != 6){
            listMenu();
            choice = getInput();
            switch (choice) {
                case 1 -> System.out.println("All");
                case 2 -> System.out.println("By sport");
                case 3 -> System.out.println("By nation");
                case 4 -> System.out.println("By team");
                case 6 -> System.out.println("Back");
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void selectMenuLoop() {
        int choice = 0;
        while(choice != 6){
            selectMenu();
            choice = getInput();
            switch (choice) {
                case 1 -> System.out.println("By year");
                case 2 -> System.out.println("By name");
                case 3 -> System.out.println("By sport");
                case 4 -> System.out.println("By nation");
                case 5 -> System.out.println("By team");
                case 6 -> System.out.println("Back");
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static int getInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        return input.nextInt();
    }
}
