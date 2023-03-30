package task2;

class Booking {
    private Tuition tuition;
    private String day;
    private int time;

    public Booking(Tuition tuition, String day, int time) {
        this.tuition = tuition;
        this.day = day;
        this.time = time;
    }

    public Tuition getTuition() {
        return tuition;
    }

    public String getDay() {
        return day;
    }

    public int getTime() {
        return time;
    }
    // getters and other methods

}
