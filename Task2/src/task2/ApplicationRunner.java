
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
        bookings.add(new Booking(new OneToOneLesson(members.get(0), instructors.get(0), "Monday", 9)));
        bookings.add(new Booking(new GroupLesson(members.get(2), instructors.get(2), "Monday", 16, 3)));
    }



    public static void bookOneToOneTuition(Member member, PGAInstructor instructor, String day, int time) {
        // Check if the member or the instructor already has a booking at the specified day and time
        for (Booking booking : bookings) {
            Tuition tuition = booking.getTuition();
            if ((tuition.getMember().equals(member) || tuition.getInstructor().equals(instructor)) &&
                    tuition.getDay().equalsIgnoreCase(day) && tuition.getTime() == time) {
                System.out.println("The selected member or the selected instructor already has a booking at the specified day/time.");
                return;
            }
        }

        // Create a new one-to-one lesson and add it to the bookings
        OneToOneLesson oneToOneLesson = new OneToOneLesson(member, instructor, day, time);
        Booking newBooking = new Booking(oneToOneLesson);
        bookings.add(newBooking);
        System.out.println("One-to-one lesson booked successfully.");
    }


    public static void bookJuniorGroupTuition(JuniorMember member, PGAInstructor instructor, String day, int time) {
        // Check if the junior member already has two group lesson bookings for the week
        int groupLessonCount = 0;
        for (Booking booking : bookings) {
            Tuition tuition = booking.getTuition();
            if (tuition instanceof GroupLesson && tuition.getMember().equals(member)) {
                groupLessonCount++;
            }
        }
        if (groupLessonCount >= 2) {
            System.out.println("The selected junior member already has two group lesson bookings for the week.");
            return;
        }

        // Create a new group lesson and add it to the bookings
        GroupLesson groupLesson = new GroupLesson(member, instructor, day, time, 3);
        Booking newBooking = new Booking(groupLesson);
        bookings.add(newBooking);
        System.out.println("Junior group lesson booked successfully.");
    }


    public static void listInstructorBookings(PGAInstructor instructor) {
        System.out.println("Bookings for " + instructor.getName() + ":");
        for (Booking booking : bookings) {
            Tuition tuition = booking.getTuition();
            if (tuition.getInstructor().equals(instructor)) {
                System.out.println("Day: " + tuition.getDay() + ", Time: " + tuition.getTime() + ", Type: " +
                        (tuition instanceof OneToOneLesson ? "One-to-One" : "Group") + ", Member: " + tuition.getMember().getName());
            }
        }
    }


    public static void listMemberBookings(Member member) {
        System.out.println("Bookings for " + member.getName() + ":");
        for (Booking booking : bookings) {
            Tuition tuition = booking.getTuition();
            if (tuition.getMember().equals(member)) {
                System.out.println("Day: " + tuition.getDay() + ", Time: " + tuition.getTime() + ", Type: " +
                        (tuition instanceof OneToOneLesson ? "One-to-One" : "Group") + ", Instructor: " + tuition.getInstructor().getName());
            }
        }
    }

}