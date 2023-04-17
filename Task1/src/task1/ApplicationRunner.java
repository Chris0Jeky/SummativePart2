package task1;

import java.util.Arrays;
import java.util.Vector;

public class ApplicationRunner {

    static FileReader read = new FileReader();
    static Vector<String> vecty = read.read();

    static Object[][] objectifiedAwards = Mechanics.objectifyData(vecty);
    static Object[][] sortedInfoPerson = Mechanics.bubbleSort(Mechanics.makePersonMedalList(objectifiedAwards));
    static Object[][] sortedInfoSport = Mechanics.bubbleSort(Mechanics.makeSportMedalsList(objectifiedAwards));

    public static void main(String[] args) {

        /*System.out.println("Sorted by person");
        for (Object[] row : sortedInfoPerson) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Sorted by sport");
        for (Object[] row : sortedInfoSport) {
            System.out.println(Arrays.toString(row));
        }*/
        Menu.menuLoop();
    }
}
