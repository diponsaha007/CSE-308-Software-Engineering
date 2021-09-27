package Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Client.*;
import Stock.*;
import util.*;

public class AdminInput implements Runnable {
    private ArrayList<Stock> stocks;
    private Thread thr;
    private HashMap<String, NetworkUtil> mp;

    public AdminInput(ArrayList<Stock> stocks) {
        this.stocks = stocks;
        mp = new HashMap<> ();
        this.thr = new Thread (this);
        thr.start ();
    }

    public void add(String s, NetworkUtil nc) {
        mp.put (s, nc);
    }

    public void print() {
        for (Stock st1 : stocks) {
            StockData st = st1.stockData;
            System.out.println (st.getName () + " " + st.getCnt () + " " + st.getPrice ());
        }
    }

    public void Notify(String notification, Stock stock) {
        for (iUser i : stock.observer) {
            if (!mp.containsKey (i.getUsername ()))
                continue;
            NetworkUtil nc = mp.get (i.getUsername ());
            StockData temp = new StockData (stock.stockData.getName (), stock.stockData.getCnt (), stock.stockData.getPrice ());
            nc.write (temp);
            nc.write (notification);
        }
    }

    @Override
    public void run() {
        Scanner input = new Scanner (System.in);

        while (true) {
            String type = input.next ();
            String name = input.next ();
            if (type.equals ("I")) {
                double amount = input.nextDouble ();
                for (int i = 0; i < stocks.size (); i++) {
                    if (stocks.get (i).getName ().equals (name)) {
                        stocks.get (i).increase (amount);
                        Notify ("Stock " + name + " price increased by " + amount, stocks.get (i));
                        break;
                    }
                }
            }
            else if (type.equals ("D")) {
                double amount = input.nextDouble ();
                for (int i = 0; i < stocks.size (); i++) {
                    if (stocks.get (i).getName ().equals (name)) {
                        stocks.get (i).increase (-amount);
                        Notify ("Stock " + name + " price decreased by " + amount, stocks.get (i));
                        break;
                    }
                }
            }
            else if (type.equals ("C")) {
                int val = input.nextInt ();
                for (int i = 0; i < stocks.size (); i++) {
                    if (stocks.get (i).getName ().equals (name)) {
                        stocks.get (i).change_count (val);
                        Notify ("Stock " + name + " count changed to " + val, stocks.get (i));
                        break;
                    }
                }
            }
        }
    }
}
