import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DuplicateCounter {
    HashMap<String, Integer> hm;

    public DuplicateCounter() {
        hm = new HashMap<>();
    }

    public void count(String dataFile) throws Exception {
        Scanner scnr = new Scanner(new File(dataFile));

        while (scnr.hasNext()) {
            // Get the next value
            String temp = scnr.next();

            if (hm.containsKey(temp)) {
                int t = hm.get(temp) + 1;
                hm.put(temp, t);
            }
            else {
                hm.put(temp, 1);
            }
        }

        scnr.close();
    }

    public void write(String outputFile) throws Exception {
        FileWriter writer = new FileWriter(outputFile);

        for (String name: hm.keySet()){
            String key = name.toString();
            String value = hm.get(name).toString();
            System.out.println(key + " " + value);
            writer.write(key + " " + value);

        }
    }
}
