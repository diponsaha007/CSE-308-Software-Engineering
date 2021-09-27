import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class SumAdapter extends SumFromFile {
    public int calculateSum(String filename, String sumType) {
        if (sumType.equalsIgnoreCase ("char")) {
            String new_filename = make_int_file (filename);
            if (new_filename.isEmpty ())
                return -1;
            return calculateSum (new_filename);
        }
        else if (sumType.equalsIgnoreCase ("int")) {
            return calculateSum (filename);
        }
        else {
            System.out.println ("Invalid Sum Type!");
            return -1;
        }
    }

    public String make_int_file(String filename) {
        try {
            String new_filename = "int_file.txt";
            if (new_filename.equals (filename)) {
                new_filename = "int_file1.txt";
            }
            FileWriter fileWriter = new FileWriter (new_filename);
            Scanner scanner = new Scanner (new File (filename));
            while (scanner.hasNext ()) {
                String s = scanner.next ();
                for (int i = 0; i < s.length (); i++) {
                    int x = (int) s.charAt (i);
                    fileWriter.write (String.valueOf (x));
                }
                fileWriter.write (" ");
            }
            fileWriter.close ();
            return new_filename;
        } catch (Exception e) {
            System.out.println ("An error occurred.");
            e.printStackTrace ();
            return "";
        }
    }
}
