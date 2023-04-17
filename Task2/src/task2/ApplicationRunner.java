
package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {

        private static List<Member> members;
        private static List<PGAInstructor> instructors;
        private static List<Booking> bookings;

        public static void main(String[] args) {
            // Initialize the required data structures and load dummy data.
            members = new ArrayList<>();
            instructors = new ArrayList<>();
            bookings = new ArrayList<>();

            loadDummyData();

            boolean running = true;
            Scanner scanner = new Scanner(System.in);

            while (running) {
                System.out.println("\nGolf Lesson Booking System");
                System.out.println("1. Book one-to-one tuition");
                System.out.println("2. Book junior group tuition");
                System.out.println("3. List instructor bookings");
                System.out.println("4. List member bookings");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        bookOneToOneTuition();
                        break;
                    case 2:
                        bookJuniorGroupTuition();
                        break;
                    case 3:
                        listInstructorBookings();
                        break;
                    case 4:
                        listMemberBookings();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }

            scanner.close();
        }

        // Additional methods for loading dummy data and handling each use case go here.

    private static void loadDummyData() {
        // Add dummy data for members
        members.add(new AdultMember("Alice"));
        members.add(new AdultMember("Bob"));
        members.add(new JuniorMember("Charlie"));
        members.add(new JuniorMember("David"));

        // Add dummy data for instructors
        instructors.add(new PGAInstructor("Instructor 1", 4));
        instructors.add(new PGAInstructor("Instructor 2", 4));
        instructors.add(new PGAInstructor("Instructor 3", 3));
        instructors.add(new PGAInstructor("Instructor 4", 3));
        instructors.add(new PGAInstructor("Instructor 5", 3));

        // Add dummy data for bookings
        bookings.add(new Booking(members.get(0), new OneToOneLesson(), instructors.get(0), "Monday", "09:00"));
        bookings.add(new Booking(members.get(2), new GroupLesson(3), instructors.get(2), "Monday", "16:00"));
    }


    private static void bookOneToOneTuition() {
            // Handle booking one-to-one tuition.
        }

        private static void bookJuniorGroupTuition() {
            // Handle booking junior group tuition.
        }

        private static void listInstructorBookings() {
            // List instructor bookings.
        }

        private static void listMemberBookings() {
            // List member bookings.
        }
}