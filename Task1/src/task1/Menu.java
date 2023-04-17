package task1;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

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
            choice = Integer.parseInt(getInput(1));
            if (choice == 1) {
               //listOfYear();
            } else if (choice == 2) {
                String year = getInput(0);
                displayYear(ApplicationRunner.objectifiedAwards, year);
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

    public static String getInput(int type){
        Scanner input = new Scanner(System.in);
        String inputString = "";
        if (type == 0) {
            System.out.println("Enter year: ");
            inputString = input.nextLine();
            while (!validYear(ApplicationRunner.objectifiedAwards, inputString) && !inputString.equals("0")) {
                System.out.println("Enter year: ");
                inputString = input.nextLine();
            }

        } else if (type == 1) {
            System.out.println("Enter your choice: ");
            inputString = input.nextLine();
        }
        return inputString;
    }

    public static boolean validYear(Object[][] objectifiedAwards, String year){
        boolean valid = false;
        for (Object[] row : objectifiedAwards) {
            if (row[0].equals(year)) {
                valid = true;
                break;
            }
        }
        if (valid) {
            System.out.println("Valid year");
        }
        else if (year.equals("0")) {
            System.out.println("Exiting...");
        }else {
            System.out.println("Invalid year, enter 0 to exit");
        }
        return valid;
    }

    public static void listOfYear(){
        System.out.println("List of years");
        for (Object[] row : ApplicationRunner.objectifiedAwards) {
            System.out.println(row[0]);
        }
    }

    public static void displayYear(Object[][] objectifiedAwards, String year) {
        if (year.equals("0")) {
            return;
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("|                Individual Sports Person                |                    Team                          |");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        for (Object[] row : objectifiedAwards) {
            if (row[0].equals(year)) {
                SportsPerson winner = (SportsPerson) row[1];
                SportsPerson second = (SportsPerson) row[2];
                SportsPerson third = (SportsPerson) row[3];
                SportsTeam team = (SportsTeam) row[4];

                System.out.printf("| %-6s | %-15s | %-10s | %-10s | %-25s |\n", "Winner", winner.getName(), winner.getSport(), winner.getNation(), team.getTeamName());
                System.out.printf("| %-6s | %-15s | %-10s | %-10s | %-25s |\n", "Second", second.getName(), second.getSport(), second.getNation(), "Captain: " + team.getTeamCaptain());
                System.out.printf("| %-6s | %-15s | %-10s | %-10s | %-25s |\n", "Third", third.getName(), third.getSport(), third.getNation(), team.getNation());
                System.out.println("-------------------------------------------------------------------------------------------------------------");
            }
        }
    }

}
