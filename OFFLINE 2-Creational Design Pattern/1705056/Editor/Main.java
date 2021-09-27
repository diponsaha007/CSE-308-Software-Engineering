import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Editor editor = Editor.getEditor ();
        Scanner scanner = new Scanner (System.in);
        while (true) {
            System.out.println ("\nEnter your choice [1-2]\n1.Input filename.\n2.Quit");
            int choice = scanner.nextInt ();
            if (choice == 1) {
                String name = scanner.next ();
                editor.openFile (name);
            }
            else {
                break;
            }
        }
    }
}
