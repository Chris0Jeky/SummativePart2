package task1;

import java.util.Vector;

public class ApplicationRunner {


    public static void main(String[] args) {
        FileReader read = new FileReader();
        //read.printRead();
        Vector<String> vecty = read.read();
        System.out.println(vecty.get(0));
        System.out.println(createSportsAward(vecty.get(0)));
        Object[] ar = ObjectBuilder.mkArrayOfData(vecty.get(0));
        System.out.println(ar[0]);
        System.out.println(ar[1].toString());
        System.out.println(ar[2].toString());
        System.out.println(ar[3].toString());
        System.out.println(ar[4].toString());
        System.out.println(ar[5].toString());

        Menu.mainMenuLoop();

    }
    /*1995|Jonathan Edwards (ENG),Athletics|Frank Bruno (ENG),Boxing|Colin McRae (SCO),Rallying|Ryder Cup team (EU),Golf,Bernard Gallacher
    1996|Damon Hill (ENG),Formula One|Steve Redgrave (ENG),Rowing|Frankie Dettori (ITA),Horse racing|Olympic rowing pairs (UK),Rowing,N/A
    1997|Greg Rusedski (ENG),Tennis|Tim Henman (ENG),Tennis|Steve Redgrave (ENG),Rowing|British & Irish Lions squad (UK),Rugby union,Martin Johnson
*/

    public static SportsAward createSportsAward(String data){

        ObjectBuilder.mkArrayOfData(data);


        return null;
    }
}
