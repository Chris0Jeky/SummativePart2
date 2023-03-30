
package task2;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRunner {
    private List<Member> members;
    private List<PGAInstructor> instructors;
    private List<Booking> bookings;

    public ApplicationRunner() {
        members = new ArrayList<>();
        instructors = new ArrayList<>();
        bookings = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
    }

    // The rest of the constructor and initialization methods remain the same

    private void bookOneToOneTuition() {
        // The method remains mostly the same, but create a OneToOneLesson object instead of a Lesson object
        OneToOneLesson oneToOneLesson = new OneToOneLesson(member, instructor, day, hour);
        Booking booking = new Booking(oneToOneLesson, day, hour);
        bookings.add(booking);
        System.out.println("One-to-one lesson booked successfully.");
    }

    private void bookJuniorGroupTuition() {
        // The method remains mostly the same, but create a GroupLesson object instead of a Lesson object
        GroupLesson groupLesson = new GroupLesson(member, instructor, day, hour, spacesAvailable - 1);
        Booking booking = new Booking(groupLesson, day, hour);
        bookings.add(booking);
        System.out.println("Junior group lesson booked successfully.");
    }

    private void listInstructorBookings() {
        // The method remains mostly the same, but use the tuition attribute of the Booking class
        for (Booking booking : bookings) {
            Tuition tuition = booking.getTuition();
            if (tuition.getInstructor().equals(instructor)) {
                String lessonType = tuition instanceof OneToOneLesson ? "one-to-one" : "group";
                System.out.println(booking.getDay() + " " + booking.getTime() + ":00 " + lessonType + " - " + tuition.getMember().getName());
            }
        }
    }

    private void listMemberBookings() {
        // The method remains mostly the same, but use the tuition attribute of the Booking class
        for (Booking booking : bookings) {
            Tuition tuition = booking.getTuition();
            if (tuition.getMember().equals(member)) {
                String lessonType = tuition instanceof OneToOneLesson ? "one-to-one" : "group";
                System.out.println(booking.getDay() + " " + booking.getTime() + ":00 " + lessonType + " - " + tuition.getInstructor().getName());
            }
        }
    }
}
