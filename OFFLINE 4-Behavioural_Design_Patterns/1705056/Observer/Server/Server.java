package Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import Client.*;
import Stock.*;
import util.*;

public class Server {
    private ServerSocket serverSocket;
    private static ArrayList<Stock> stocks;
    private AdminInput adminInput;

    public Server() {
        try {
            read_stocks ();
            adminInput = new AdminInput (stocks);
            serverSocket = new ServerSocket (33333);
            while (true) {
                Socket clientSocket = serverSocket.accept ();
                serve (clientSocket);
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void serve(Socket clientSocket) {
        NetworkUtil nc = new NetworkUtil (clientSocket);
        //Reading the user object
        iUser obj;
        while (true) {
            Object o = nc.read ();
            if (o != null) {
                if (o instanceof iUser) {
                    obj = (iUser) o;
                    break;
                }
            }
        }
        System.out.println (obj.getUsername () +" connected.");
        //Now write all the Stock data to the user
        nc.write (stocks.size ());
        for (Stock st : stocks) {
            nc.write (st.stockData);
        }
        adminInput.add (obj.getUsername (), nc);
        //Start thread
        UserInput userInput = new UserInput (stocks, nc, obj);
    }

    public void read_stocks() throws FileNotFoundException {
        Scanner scanner = new Scanner (new File ("Stocks.txt"));
        stocks = new ArrayList<> ();
        while (scanner.hasNext ()) {
            String name = scanner.next ();
            int cnt = scanner.nextInt ();
            double price = scanner.nextDouble ();
            stocks.add (new Stock (new StockData (name, cnt, price)));
            //System.out.println (name+ " "+cnt+" "+price);
        }
    }

    public static void main(String[] args) {
        Server server = new Server ();
    }
}
