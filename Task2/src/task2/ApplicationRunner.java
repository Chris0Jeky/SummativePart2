
package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static task2.BookingManager.bookJuniorGroupTuition;
import static task2.BookingManager.bookOneToOneTuition;
import static task2.InstructorManager.selectInstructor;
import static task2.MemberManager.selectJuniorMember;
import static task2.MemberManager.selectMember;

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

        MemberManager memberManager = new MemberManager(members);
        InstructorManager instructorManager = new InstructorManager(instructors);
        BookingManager bookingManager = new BookingManager(bookings);

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            displayMenu();  // Display the menu
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Member member = selectMember(scanner);
                    PGAInstructor instructor = selectInstructor(scanner);
                    String day;
                    int time;
                    boolean validInput;
                    do {
                        validInput = true;
                        System.out.print("Enter the day for the lesson: ");
                        day = scanner.nextLine();
                        System.out.print("Enter the time for the lesson (9 to 18): ");
                        time = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (!isValidDay(day)) {
                            System.out.println("Invalid day. Please enter a valid day (e.g., Monday, Tuesday, etc.).");
                            validInput = false;
                        } else if (!isValidTime(time)) {
                            System.out.println("Invalid time. Please enter a valid time between 9 and 18 (inclusive).");
                            validInput = false;
                        }
                    } while (!validInput);
                    bookOneToOneTuition(member, instructor, day, time);
                    break;
                case 2:
                    JuniorMember selectedJuniorMember = selectJuniorMember(scanner);
                    PGAInstructor selectedGroupInstructor = selectInstructor(scanner);
                    String groupDay;
                    int groupTime;
                    do {
                        validInput = true;
                        System.out.print("Enter the day for the group lesson: ");
                        groupDay = scanner.nextLine();
                        System.out.print("Enter the time for the group lesson (16 or 17): ");
                        groupTime = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (!isValidWeekday(groupDay)) {
                            System.out.println("Invalid day. Please enter a valid weekday (e.g., Monday, Tuesday, etc.).");
                            validInput = false;
                        } else if (groupTime != 16 && groupTime != 17) {
                            System.out.println("Invalid time. Please enter a valid time (16 or 17).");
                            validInput = false;
                        }
                    } while (!validInput);
                    bookJuniorGroupTuition(selectedJuniorMember, selectedGroupInstructor, groupDay, groupTime);
                    break;
                case 3:
                    PGAInstructor instructorToCheck = selectInstructor(scanner);
                    listInstructorBookings(instructorToCheck);
                    break;
                case 4:
                    Member memberToCheck = selectMember(scanner);
                    listMemberBookings(memberToCheck);
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

    private static void displayMenu() {
        System.out.println("\nGolf Lesson Booking System");
        System.out.println("1. Book one-to-one tuition");
        System.out.println("2. Book junior group tuition");
        System.out.println("3. List instructor bookings");
        System.out.println("4. List member bookings");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

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

    public static boolean isValidDay(String day) {
        String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return Arrays.stream(validDays).anyMatch(d -> d.equalsIgnoreCase(day));
    }

    public static boolean isValidWeekday(String day) {
        String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return Arrays.stream(validDays).anyMatch(d -> d.equalsIgnoreCase(day));
    }

    public static boolean isValidTime(int time) {
        return time >= 9 && time <= 18;
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