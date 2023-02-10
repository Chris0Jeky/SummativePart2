package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ApplicationRunner {


    public static void main(String[] args) {
        FileReader read = new FileReader();
        //read.printRead();
        Vector<String> vecty = read.read();
        System.out.println(vecty.get(0));
    }
    /*1995|Jonathan Edwards (ENG),Athletics|Frank Bruno (ENG),Boxing|Colin McRae (SCO),Rallying|Ryder Cup team (EU),Golf,Bernard Gallacher
    1996|Damon Hill (ENG),Formula One|Steve Redgrave (ENG),Rowing|Frankie Dettori (ITA),Horse racing|Olympic rowing pairs (UK),Rowing,N/A
    1997|Greg Rusedski (ENG),Tennis|Tim Henman (ENG),Tennis|Steve Redgrave (ENG),Rowing|British & Irish Lions squad (UK),Rugby union,Martin Johnson
*/

    public static SportsAward createSportsAward(String data){

        ObjectBuilder.createSportsAward(data);


        return null;
    }
}
