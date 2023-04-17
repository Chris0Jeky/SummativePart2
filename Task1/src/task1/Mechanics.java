package task1;

import java.util.HashMap;
import java.util.Vector;

public class Mechanics {
    // Sorts a 2D array of Objects by the 2nd, 3rd, and 4th columns
    public static Object[][] bubbleSort(Object[][] infoToSort) {
        Object[] temp;
        for (int i = 0; i < infoToSort.length - 1; i++) {
            for (int j = 0; j < infoToSort.length - 1 - i; j++) {
                boolean shouldSwap = false;

                for (int col = 1; col <= 3; col++) {
                    int comparison = ((Integer) infoToSort[j][col]).compareTo((Integer) infoToSort[j + 1][col]);
                    if (comparison < 0) {
                        shouldSwap = true;
                        break;
                    } else if (comparison > 0) {
                        break;
                    }
                }

                if (shouldSwap) {
                    temp = infoToSort[j];
                    infoToSort[j] = infoToSort[j + 1];
                    infoToSort[j + 1] = temp;
                }
            }
        }
        return infoToSort;
    }

    // Creates an array of Objects from a String
    public static Object[] objectifyString(String data){

        return ObjectBuilder.mkArrayOfData(data);
    }

    // does the previous method on a Vector of Strings
    // and returns a 2D array of Objects
    public static Object[][] objectifyData(Vector<String> vecty){
        Object[][] objectifiedAwards = new Object[vecty.size()][6];
        for (int i = 0; i < vecty.size(); i++){
            Object[] awards = objectifyString(vecty.get(i));
            objectifiedAwards[i] = awards;
        }
        return objectifiedAwards;
    }

    // Creates a HashMap of SportsPerson objects
    // keeps track of medals per person or sport
    // takes in the name of the person or the name of the sport
    // and the index of the medal type (gold, silver, bronze)
    // and increments the value at that index
    public static void incrementOrAdd(String name, HashMap<String, Integer[]> map, int index){
        if (map.containsKey(name)){
            Integer[] temp = map.get(name);
            temp[index] += 1;
            map.put(name, temp);
        } else {
            Integer[] temp = {0, 0, 0};
            temp[index] += 1;
            map.put(name, temp);
        }
    }

    // Transforms a HashMap into a 2D array
    // the first column is the key
    // the second column is the number of gold medals
    // the third column is the number of silver medals
    // the fourth column is the number of bronze medals
    // the fifth column is the total number of medals
    public static Object[][] transformIntoBiArr(HashMap<String, Integer[]> map){
        Object[][] biArr = new Object[map.size()][5];
        int i = 0;
        for (String key : map.keySet()){
            biArr[i][0] = key;
            biArr[i][1] = map.get(key)[0];
            biArr[i][2] = map.get(key)[1];
            biArr[i][3] = map.get(key)[2];
            biArr[i][4] = (Integer)biArr[i][1] + (Integer)biArr[i][2] + (Integer)biArr[i][3];
            i++;
        }
        return biArr;
    }

    // Creates a 2D array of Objects for holding the list of sports and medals
    public static Object[][] makeSportMedalsList(Object[][] objectifiedAwards){
        Object[][] sportsMedalsList = new Object[objectifiedAwards.length][5];
        HashMap<String, Integer[]> sportMap = new HashMap<>();
        for (Object[] objectifiedAward : objectifiedAwards) {
            incrementOrAdd(((SportsPerson) objectifiedAward[1]).getSport(), sportMap, 0);
            incrementOrAdd(((SportsPerson) objectifiedAward[2]).getSport(), sportMap, 1);
            incrementOrAdd(((SportsPerson) objectifiedAward[3]).getSport(), sportMap, 2);
        }
        sportsMedalsList = transformIntoBiArr(sportMap);
        return sportsMedalsList;
    }

    // Creates a 2D array of Objects for holding the list of people and medals
    public static Object[][] makePersonMedalList(Object[][] objectifiedAwards){
        Object[][] personMedalList = new Object[objectifiedAwards.length][5];
        HashMap<String, Integer[]> personMap = new HashMap<>();
        for (Object[] objectifiedAward : objectifiedAwards) {
            incrementOrAdd(((SportsPerson) objectifiedAward[1]).getName(), personMap, 0);
            incrementOrAdd(((SportsPerson) objectifiedAward[2]).getName(), personMap, 1);
            incrementOrAdd(((SportsPerson) objectifiedAward[3]).getName(), personMap, 2);
        }
        personMedalList = transformIntoBiArr(personMap);
        return personMedalList;
    }
}
