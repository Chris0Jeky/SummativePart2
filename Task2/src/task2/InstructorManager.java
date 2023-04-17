package task2;

import java.util.List;
import java.util.Scanner;

public class InstructorManager {

    private static List<PGAInstructor> instructors;

    public InstructorManager(List<PGAInstructor> instructors) {
        this.instructors = instructors;
    }

    public static PGAInstructor selectInstructor(Scanner scanner) {
        System.out.println("Select an instructor:");
        int instructorChoice = -1;
        do {
            for (int i = 0; i < instructors.size(); i++) {
                System.out.println((i + 1) + ". " + instructors.get(i).getName() + " (Level " + instructors.get(i).getCoachLevel() + ")");
            }
            System.out.print("Enter your choice: ");
            instructorChoice = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline character

            if (instructorChoice < 0 || instructorChoice >= instructors.size()) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (instructorChoice < 0 || instructorChoice >= instructors.size());

        return instructors.get(instructorChoice);
    }
}