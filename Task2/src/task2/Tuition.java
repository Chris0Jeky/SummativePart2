package task2;

abstract class Tuition {
    protected Member member;
    protected PGAInstructor instructor;
    protected String day;
    protected int time;

    public Tuition(Member member, PGAInstructor instructor, String day, int time) {
        this.member = member;
        this.instructor = instructor;
        this.day = day;
        this.time = time;
    }
}
