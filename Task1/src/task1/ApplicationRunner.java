package task1;

import java.util.Arrays;
import java.util.Vector;

public class ApplicationRunner {


    public static void main(String[] args) {
        FileReader read = new FileReader();

        Vector<String> vecty = read.read();

        Object[][] objectifiedAwards = Mechanics.objectifyData(vecty);
        Object[][] sortedInfoPerson = Mechanics.bubbleSort(Mechanics.makePersonMedalList(objectifiedAwards));
        Object[][] sortedInfoSport = Mechanics.bubbleSort(Mechanics.makeSportMedalsList(objectifiedAwards));

        System.out.println("Sorted by person");
        for (Object[] row : sortedInfoPerson) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Sorted by sport");
        for (Object[] row : sortedInfoSport) {
            System.out.println(Arrays.toString(row));
        }
    }
}
