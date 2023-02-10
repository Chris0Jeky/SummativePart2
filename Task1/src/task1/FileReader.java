package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FileReader {

    public static Vector read() {

        Vector vectorisedFile = new Vector();
        try {
            String dataFile = System.getProperty("user.dir") + File.separator + "sports-personalities.txt";
            File file = new File(dataFile);
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNext()) {
                    String data = reader.next();
                    vectorisedFile.addElement(data);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return vectorisedFile;
    }
}
