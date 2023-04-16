package task1;

import java.util.Arrays;
import java.util.Vector;

public class ApplicationRunner {


    public static void main(String[] args) {
        FileReader read = new FileReader();
        //read.printRead();
        /*
        Vector<String> vecty = read.read();
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


        int[][] test = {{1,2,3},{4,5,6},{7,8,9},{7,8,9},{7,8,9},{7,8,9}};
        System.out.println(test.length);
        int[][] test2 = new int[6][3];
        System.out.println(test2[2].length);

    }
    /*1995|Jonathan Edwards (ENG),Athletics|Frank Bruno (ENG),Boxing|Colin McRae (SCO),Rallying|Ryder Cup team (EU),Golf,Bernard Gallacher
    1996|Damon Hill (ENG),Formula One|Steve Redgrave (ENG),Rowing|Frankie Dettori (ITA),Horse racing|Olympic rowing pairs (UK),Rowing,N/A
    1997|Greg Rusedski (ENG),Tennis|Tim Henman (ENG),Tennis|Steve Redgrave (ENG),Rowing|British & Irish Lions squad (UK),Rugby union,Martin Johnson
*/

    public static Object[][] bubbleSort (Object[][] infoToSort){

        //Object[][] sortedInfo = new Object[infoToSort.length][5];
        System.out.println(Arrays.toString(infoToSort));
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
        System.out.println(Arrays.toString(infoToSort));
        return infoToSort;

    }
    public static SportsAward createSportsAward(String data){

        ObjectBuilder.mkArrayOfData(data);


        return null;
    }
}
