package task1;

import java.util.Scanner;

public class Menu {
    ApplicationRunner app = new ApplicationRunner();

    public static void mainMenu(){
        System.out.println("--------------------");
        System.out.println("Sports award menu");
        System.out.println("--------------------");
        System.out.println("List .............. 1");
        System.out.println("Select ............ 2");
        System.out.println("Sort .............. 3");
        System.out.println("Exit .............. 0");
        System.out.println("--------------------");
    }

    public static void selectMenu(){
        System.out.println("--------------------");
        System.out.println("Select menu");
        System.out.println("--------------------");
        System.out.println("Select year of award");
        System.out.println("--------------------");
    }

    public static void listMenu(){
        System.out.println("--------------------");
        System.out.println("List result");
        System.out.println("--------------------");
    }

    public static void sortMenu(){
        System.out.println("--------------------");
        System.out.println("Sort menu");
        System.out.println("--------------------");
        System.out.println("Sort by sport .....1");
        System.out.println("Sort by person ....2");
        System.out.println("--------------------");
    }

    public static void menuLoop(){
        int choice = 5;
        while(choice != 0){
            mainMenu();
            choice = getInput(1);
            if (choice == 1) {
               //listOfYear();
            } else if (choice == 2) {
              //  selectMenuLoop();
            } else if (choice == 3) {
               // sortMenuLoop();
            } else if (choice == 0) {
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

    public static int getInput(int type){
        Scanner input = new Scanner(System.in);
        String inputString;
        if (type == 0) {
            System.out.println("Enter year: ");
            inputString = input.nextLine();
        } else if (type == 1) {
            System.out.println("Enter your choice: ");
        }
        return input.nextInt();
    }

    public static void validYear(Object[][] objectifiedAwards){
        int year = getInput(0);
        boolean valid = false;
        for (Object[] row : objectifiedAwards) {
            if (row[0].equals(year)) {
                valid = true;
            }
        }
        if (valid) {
            System.out.println("Valid year");
        } else {
            System.out.println("Invalid year");
        }
        waitForEnter();
    }
}
