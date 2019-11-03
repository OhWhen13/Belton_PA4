import java.io.*;
import java.util.*;



public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException
    {
        String unique;
        uniqueWords = new HashSet<String>();
        Scanner scan = new Scanner(new File(dataFile));
        while(scan.hasNext()) {
            unique = scan.next();
            uniqueWords.add(unique);
        }
        scan.close();

    }

    public void write(String outputFile) throws IOException
    {
        File file;
        FileWriter f = null;
        file = new File(outputFile);

        if(file.exists()){
            f = new FileWriter(file,true);
            Iterator i = uniqueWords.iterator();

            while(i.hasNext())
            {
                String s = (String)i.next();
                f.write(s + "  ");
            }
            f.close();
            System.out.print("File appended");
        }
        else
        {
            file.createNewFile();
            f = new FileWriter(file);
            Iterator i = uniqueWords.iterator();
            while(i.hasNext())
            {
                String s = (String)i.next();
                f.write(s + " ");
            }
            f.close();
            System.out.print("File Created");
        }
    }
}
