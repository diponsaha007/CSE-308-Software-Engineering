import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class SumFromFile {
    public int calculateSum(String filename) {
        try {
            Scanner scanner = new Scanner (new File (filename));
            int sum = 0;
            while (scanner.hasNextInt ()) {
                int number = scanner.nextInt ();
                sum += number;
            }
            return sum;
        } catch (FileNotFoundException e) {
            System.out.println ("File not found!");
            return -1;
        }
    }
    abstract int calculateSum(String filename, String sumType);
}
