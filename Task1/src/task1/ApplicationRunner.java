package task1;

import java.util.Arrays;
import java.util.Vector;

public class ApplicationRunner {


    public static void main(String[] args) {
        FileReader read = new FileReader();
        //read.printRead();

        Vector<String> vecty = read.read();

        Object[][] objectifiedAwards = objectifyData(vecty);
        System.out.println(objectifiedAwards[0][0].toString());
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
    public static Object[] objectifyString(String data){

        return ObjectBuilder.mkArrayOfData(data);
    }

    public static Object[][] objectifyData(Vector<String> vecty){
        Object[][] objectifiedAwards = new Object[vecty.size()][6];
        for (int i = 0; i < vecty.size(); i++){
            Object[] awards = objectifyString(vecty.get(i));
            objectifiedAwards[i] = awards;
        }
        return objectifiedAwards;
    }
}
