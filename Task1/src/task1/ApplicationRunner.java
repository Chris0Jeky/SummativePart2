package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ApplicationRunner {


    public static void main(String[] args) {
        FileReader read = new FileReader();
        Vector<String> vecty = read.read();
        for (String s : vecty) {
            System.out.println(s);
        }
    }
}
