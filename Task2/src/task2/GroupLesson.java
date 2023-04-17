package task2;

class GroupLesson extends Tuition {
    private final int spacesAvailable;

    public GroupLesson(Member member, PGAInstructor instructor, String day, int time, int spacesAvailable) {
        super(member, instructor, day, time);
        this.spacesAvailable = spacesAvailable;
    }

    public int getSpacesAvailable() {
        return spacesAvailable;
    }
}
