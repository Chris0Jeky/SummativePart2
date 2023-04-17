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
        System.out.println("Exit ............. 0");
        System.out.println("--------------------");
    }

    //  Method to get input from user
    // and keeping the menu open
    // calls every other meny method
    public static void menuLoop(){
        int choice = 5;
        while(choice != 0){
            mainMenu();
            try {
                choice = Integer.parseInt(getInput(1));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                choice = -1; // Set choice to -1 to continue the loop without exiting.
                continue;
            }
            if (choice == 1) {
               listOfYear();
               waitForEnter();
            } else if (choice == 2) {
                String year = getInput(0);
                displayYear(ApplicationRunner.objectifiedAwards, year);
                waitForEnter();
            } else if (choice == 3) {
                sortMenu();
                sortMenuLoop();
            } else if (choice == 0) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
                waitForEnter();
            }
        }
    }

    // and keeping the menu open for sortMenu
    public static void sortMenuLoop(){
        int choice = 5;
        while(choice != 0){
            sortMenu();
            try {
                choice = Integer.parseInt(getInput(1));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                choice = -1; // Set choice to -1 to continue the loop without exiting.
                continue;
            }
            if (choice == 1) {
                System.out.println("Sorted by sport");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("| Sport     | 1st Place(s) | 2nd Place(s) | 3rd Place(s) | Total |");
                System.out.println("------------------------------------------------------------------------------------");
                for (Object[] row : ApplicationRunner.sortedInfoSport) {
                    String sport = (String) row[0];
                    int firstPlace = (int) row[1];
                    int secondPlace = (int) row[2];
                    int thirdPlace = (int) row[3];
                    int total = firstPlace + secondPlace + thirdPlace;

                    System.out.printf("| %-9s | %-12d | %-12d | %-12d | %-5d |\n", sport, firstPlace, secondPlace, thirdPlace, total);
                }
                System.out.println("------------------------------------------------------------------------------------");
                waitForEnter();
            } else if (choice == 2) {
                System.out.println("Sorted by person");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("| Person              | 1st Place(s) | 2nd Place(s) | 3rd Place(s) | Total |");
                System.out.println("------------------------------------------------------------------------------------");
                for (Object[] row : ApplicationRunner.sortedInfoPerson) {
                    String person = (String) row[0];
                    int firstPlace = (int) row[1];
                    int secondPlace = (int) row[2];
                    int thirdPlace = (int) row[3];
                    int total = firstPlace + secondPlace + thirdPlace;

                    System.out.printf("| %-18s | %-12d | %-12d | %-12d | %-5d |\n", person, firstPlace, secondPlace, thirdPlace, total);
                }
                System.out.println("------------------------------------------------------------------------------------");
                waitForEnter();
            } else if (choice == 0) {
                System.out.println("Exiting...");
                menuLoop();
            } else {
                System.out.println("Invalid choice");
                waitForEnter();
            }
        }
    }

    // method to add a pause in the displaying of information
    private static void waitForEnter() {
        Scanner input = new Scanner(System.in);
        System.out.println("Press enter to continue... (press it again)");
        input.nextLine(); // wait for enter
    }

    // method to display the list of years
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

    // method for input validation of year
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

    // method to display the list of years associated with the awards
    public static void listOfYear(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|   Year  |    Individual Award     |           Team Award               |");
        System.out.println("--------------------------------------------------------------------------");
        for (Object[] row : ApplicationRunner.objectifiedAwards) {
            String year = (String) row[0];
            SportsPerson winnerPerson = (SportsPerson) row[1];
            SportsTeam teamPerson = (SportsTeam) row[4];

            System.out.printf("| %-4s | %-17s | %-32s |\n", year, winnerPerson.getName(), teamPerson.getTeamName());
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    // associated with the select option
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
