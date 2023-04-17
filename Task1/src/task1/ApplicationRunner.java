package task1;

import java.util.HashMap;
import java.util.Vector;

public class ApplicationRunner {


    public static void main(String[] args) {
        FileReader read = new FileReader();
        //read.printRead();

        Vector<String> vecty = read.read();
        Object[][] objectifiedAwards = objectifyData(vecty);

        /* Testing objectifyAwards
        System.out.println(objectifiedAwards[0][0].toString());
        System.out.println(((SportsPerson)objectifiedAwards[0][1]).getName());
        System.out.println(((SportsPerson)objectifiedAwards[0][1]).getSport());
        */



        /*  Testing objectifyData
        Vector<String> sampleData = new Vector<>();
        sampleData.add("1995|Jonathan Edwards (ENG),Athletics|Frank Bruno (ENG),Boxing|Colin McRae (SCO),Rallying|Ryder Cup team (EU),Golf,Bernard Gallacher");
        sampleData.add("1996|Damon Hill (ENG),Formula One|Steve Redgrave (ENG),Rowing|Frankie Dettori (ITA),Horse racing|Olympic rowing pairs (UK),Rowing,N/A");
        sampleData.add("1997|Greg Rusedski (ENG),Tennis|Tim Henman (ENG),Tennis|Steve Redgrave (ENG),Rowing|British & Irish Lions squad (UK),Rugby union,Martin Johnson");

        Object[][] objectifiedData = objectifyData(sampleData);

        for (Object[] row : objectifiedData) {
            System.out.println(Arrays.toString(row));
        }

        */
         /* Testing mkArrayOfData
        System.out.println(vecty.get(0));
        System.out.println(vecty.get(1));
        System.out.println(createSportsAward(vecty.get(0)));
        Object[] ar = ObjectBuilder.mkArrayOfData(vecty.get(0));

        System.out.println(ar[0]);
        System.out.println(((SportsPerson)ar[1]).getName());
        System.out.println(((SportsPerson)ar[2]).getSport());
        System.out.println(ar[3].toString());
        System.out.println(ar[4].toString());
        System.out.println(ar[5].toString()); */

       // Menu.mainMenuLoop();


        /* Testing bubble sort
        Object[][] infoToSort = {
                {"Tennis", 5, 1, 1, 7},
                {"Athletics", 4, 3, 11, 18},
                {"Cycling", 4, 0, 0, 4},
                {"Formula One", 3, 5, 0, 8},
                {"Football", 3, 3, 3, 9},
                {"Boxing", 2, 1, 1, 4},
                {"Cricket", 2, 0, 1, 3}
        };

        Object[][] sortedInfo = bubbleSort(infoToSort);
        System.out.println(Arrays.deepToString(sortedInfo));
        */


    }
    /*1995|Jonathan Edwards (ENG),Athletics|Frank Bruno (ENG),Boxing|Colin McRae (SCO),Rallying|Ryder Cup team (EU),Golf,Bernard Gallacher
    1996|Damon Hill (ENG),Formula One|Steve Redgrave (ENG),Rowing|Frankie Dettori (ITA),Horse racing|Olympic rowing pairs (UK),Rowing,N/A
    1997|Greg Rusedski (ENG),Tennis|Tim Henman (ENG),Tennis|Steve Redgrave (ENG),Rowing|British & Irish Lions squad (UK),Rugby union,Martin Johnson
*/
    // Bubble sort method
    // Sorts by the second column of the 2D array which is the number of 1st place awards
    // It returns both with SportsPerson and Sports
    public static Object[][] bubbleSort (Object[][] infoToSort){

        //Object[][] sortedInfo = new Object[infoToSort.length][5];
        Object[] temp = new Object[5];
        for (int i = 0; i < infoToSort.length; i++){
            for (int j = 0; j < infoToSort.length; j++){
                if (((Integer)infoToSort[i][1]) > ((Integer)infoToSort[j][1])){
                    temp = infoToSort[i];
                    infoToSort[i] = infoToSort[j];
                    infoToSort[j] = temp;
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
    public static Object[][] objectifyData(Vector<String> vecty){
        Object[][] objectifiedAwards = new Object[vecty.size()][6];
        for (int i = 0; i < vecty.size(); i++){
            Object[] awards = objectifyString(vecty.get(i));
            objectifiedAwards[i] = awards;
        }
        return objectifiedAwards;
    }

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
