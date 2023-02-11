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
            if (choice == 1) {
                listMenuLoop();
            } else if (choice == 2) {
                selectMenuLoop();
            } else if (choice == 3) {
                sortMenuLoop();
            } else if (choice == 4) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice");
                waitForEnter();
            }
        }
    }

    private static void waitForEnter() {
        Scanner input = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        input.nextLine(); // wait for enter
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
            if (choice == 1) {
                System.out.println("All");
            } else if (choice == 2) {
                System.out.println("By sport");
            } else if (choice == 3) {
                System.out.println("By nation");
            } else if (choice == 4) {
                System.out.println("By team");
            } else if (choice == 6) {
                System.out.println("Back");
            } else {
                System.out.println("Invalid choice");
                waitForEnter();
            }
        }
    }

    private static void selectMenuLoop() {
        int choice = 0;
        while(choice != 6){
            selectMenu();
            choice = getInput();
            if (choice == 1) {
                System.out.println("By year");
            } else if (choice == 2) {
                System.out.println("By name");
            } else if (choice == 3) {
                System.out.println("By sport");
            } else if (choice == 4) {
                System.out.println("By nation");
            } else if (choice == 5) {
                System.out.println("By team");
            } else if (choice == 6) {
                System.out.println("Back");
            } else {
                System.out.println("Invalid choice");
                waitForEnter();
            }
        }
    }

    public static int getInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        return input.nextInt();
    }
}
