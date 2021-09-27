import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SumFromFile sumFromFile = new SumAdapter ();
        Scanner scanner = new Scanner (System.in);
        while (true)
        {
            System.out.println ("Enter filename : ");
            String filename = scanner.next ();
            System.out.println ("Enter file type (int,char) : ");
            String type = scanner.next ();
            System.out.println (sumFromFile.calculateSum (filename,type));
        }
    }
}
