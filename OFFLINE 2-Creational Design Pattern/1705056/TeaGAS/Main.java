import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ComponentBuilder componentBuilder = new ComponentBuilder ();
        String package_name, connection, webserver;
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Welcome to TeaGAS.");
        System.out.println ("Choose your Package.\n1.Silver -- ATMega32 with load sensor");
        System.out.println ("2.Gold -- Arduino with weight module");
        System.out.println ("3.Diamond -- Raspberry Pi with load sensor");
        System.out.println ("4.Platinum -- Raspberry Pi with weight module");
        package_name = scanner.next ();

        System.out.println ("Choose your connection.\n1.WiFi\n2.Ethernet\n3.GSM");
        connection = scanner.next ();

        System.out.println ("Choose your Web Server.\n1.Django\n2.Spring\n3.Laravel");
        webserver = scanner.next ();

        Components components = componentBuilder.buildComponents (package_name, connection, webserver);
        if (components == null) {
            System.exit (1);
        }
        Admin admin = new Admin (components);

        while (true) {
            System.out.println ("Choose any one.[1-6]");
            System.out.println ("1.Measure weight as a leaf collector.");
            System.out.println ("2.Add leaf collector.");
            System.out.println ("3.Remove leaf collector.");
            System.out.println ("4.Analyze data.");
            System.out.println ("5.Show Hardware Info.");
            System.out.println ("6.Quit.");
            int choice = scanner.nextInt ();

            if (choice == 1) {
                String name;
                System.out.println ("Enter your name : ");
                name = scanner.next ();
                admin.weightMeasurement (name);
            }
            else if (choice == 2) {
                String name;
                System.out.println ("Enter name : ");
                name = scanner.next ();
                admin.add (name);
            }
            else if (choice == 3) {
                String name;
                System.out.println ("Enter name : ");
                name = scanner.next ();
                admin.remove (name);
            }
            else if (choice == 4) {
                admin.analyze ();
            }
            else if (choice == 5) {
                admin.show ();
            }
            else {
                break;
            }
        }

    }
}
