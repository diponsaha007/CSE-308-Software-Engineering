package Server;

import java.util.ArrayList;
import java.util.Scanner;

import Client.*;
import Stock.*;
import util.*;

public class UserInput implements Runnable {
    private ArrayList<Stock> stocks;
    private Thread thr;
    private NetworkUtil nc;
    private iUser user;

    public UserInput(ArrayList<Stock> stocks, NetworkUtil nc, iUser obj) {
        this.stocks = stocks;
        this.nc = nc;
        user = obj;
        this.thr = new Thread (this);
        thr.start ();
    }

    public void print() {
        for (Stock st1 : stocks) {
            StockData st = st1.stockData;
            System.out.println (st.getName () + " " + st.getCnt () + " " + st.getPrice ());
        }
    }

    @Override
    public void run() {
        while (true) {
            Object o = nc.read ();
            String type = (String) o;
            o = nc.read ();
            String name = (String) o;
            //System.out.println (type + " " + name);
            int done = 0;
            for (int i = 0; i < stocks.size (); i++) {
                if (stocks.get (i).getName ().equals (name)) {
                    //System.out.println (i);
                    if (type.equals ("S")) {
                        done = stocks.get (i).add (user);
                    }
                    else if (type.equals ("U")) {
                        done = stocks.get (i).remove (user);
                    }
                    //System.out.println (done);
                    Integer x = done;
                    if (done == 1) {
                        nc.write (x);
                        nc.write (stocks.get (i).stockData);
                    }
                    else {
                        nc.write (x);
                    }
                    break;
                }
            }
            //nc.write (false);


        }
    }
}
