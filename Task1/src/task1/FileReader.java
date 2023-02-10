package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FileReader {

    public Vector<String> read() {

        Vector<String> vectorisedFile = new Vector<>();

        try {
            String dataFile = System.getProperty("user.dir") + File.separator + "Task1/sports-personalities.txt";
            File file = new File(dataFile);
            if (!file.exists()) {
                //For debugging purposes
                System.out.println("File does not exist");
                return null;
            }
            if (!file.canRead()) {
                //For debugging purposes
                System.out.println("File cannot be read");
                return null;
            }
            try (Scanner reader = new Scanner(file)) {
                //Reads the file line by line
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    vectorisedFile.addElement(data);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return vectorisedFile;
    }

    public void printRead() {
        //For debugging purposes
        FileReader read = new FileReader();
        Vector<String> vecty = read.read();
        for (String s : vecty) {
            System.out.println(s);
        }
    }
}
