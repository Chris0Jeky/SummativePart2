package task2;

import java.util.List;

import static task2.ApplicationRunner.*;

public class BookingManager {

    private static List<Booking> bookings;

    public BookingManager(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public static void bookOneToOneTuition(Member member, PGAInstructor instructor, String day, int time) {

        // Validate day input
        if (!isValidDay(day)) {
            System.out.println("Invalid day. Please enter a valid day (e.g., Monday, Tuesday, etc.).");
            return;
        }

        // Validate time input
        if (!isValidTime(time)) {
            System.out.println("Invalid time. Please enter a valid time between 9 and 18 (inclusive).");
            return;
        }
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

        // Validate day input
        if (!isValidWeekday(day)) {
            System.out.println("Invalid day. Please enter a valid weekday (e.g., Monday, Tuesday, etc.).");
            return;
        }

        // Validate time input
        if (time != 16 && time != 17) {
            System.out.println("Invalid time. Please enter a valid time (16 or 17).");
            return;
        }

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
}
