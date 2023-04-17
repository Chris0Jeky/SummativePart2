package task1;

import java.util.Vector;

public class ApplicationRunner {

    // read file and save it in a vector
    static FileReader read = new FileReader();
    static Vector<String> vecty = read.read();

    // objectify the data
    static Object[][] objectifiedAwards = Mechanics.objectifyData(vecty);
    // sort the data
    static Object[][] sortedInfoPerson = Mechanics.bubbleSort(Mechanics.makePersonMedalList(objectifiedAwards));
    static Object[][] sortedInfoSport = Mechanics.bubbleSort(Mechanics.makeSportMedalsList(objectifiedAwards));

    // start menu
    public static void main(String[] args) {
        Menu.menuLoop();
    }
}
