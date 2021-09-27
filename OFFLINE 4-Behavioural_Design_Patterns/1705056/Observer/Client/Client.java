package Client;


import java.util.Scanner;
import Stock.*;
import util.*;

public class Client {
    private String serverAddress = "127.0.0.1";
    private int serverPort = 33333;
    private static User user;

    public Client() {
        try {
            NetworkUtil nc = new NetworkUtil (serverAddress, serverPort);
            Scanner scanner = new Scanner (System.in);
            //reading username
            System.out.println ("Enter Username : ");
            String username = scanner.next ();
            user = new User (username);
            //writing user object
            nc.write (user);
            //Showing all the stock data to user
            int n = (int) nc.read ();
            for (int i = 0; i < n; i++) {
                Object o = nc.read ();
                if (o != null && o instanceof StockData) {
                    StockData stockData = (StockData) o;
                    System.out.println (stockData.getName () + " " + stockData.getCnt () + " " + stockData.getPrice ());
                }
            }
            //keep taking user input
            WriteUser writeUser = new WriteUser (user, nc);
            ReadUser readUser = new ReadUser (user, nc);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) {
        Client client = new Client ();
    }
}
