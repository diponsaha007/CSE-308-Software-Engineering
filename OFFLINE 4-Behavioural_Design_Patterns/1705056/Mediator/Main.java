import Mediator.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Mediator mediator;
        while (true) {
            String cmd = scanner.next ();
            if (cmd.equalsIgnoreCase ("init")) {
                mediator = new JCC ();
                break;
            }
        }
        while (true) {
            String cmd = scanner.next ();
            String type = scanner.next ();
            if (type.equalsIgnoreCase ("SERVE")) {
                mediator.serve (cmd);
            }
            else {
                mediator.notify (cmd, type);
            }
        }
    }
}
