package Client;

import Stock.StockData;

import java.io.Serializable;
import java.util.ArrayList;
import Stock.*;
import util.*;

public class User implements iUser, Serializable {
    private String username;
    private ArrayList<StockData> stocks;

    public User(String username) {
        this.username = username;
        stocks = new ArrayList<> ();
    }

    @Override
    public void addStock(StockData st) {
        stocks.add (st);
    }

    @Override
    public void removeStock(StockData st) {
        int idx = -1;
        for (int i = 0; i < stocks.size (); i++) {
            if (stocks.get (i).getName ().equals (st.getName ())) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            stocks.remove (idx);
        }
    }
    @Override
    public boolean hasStock(StockData st) {
        int idx = -1;
        for (int i = 0; i < stocks.size (); i++) {
            if (stocks.get (i).getName ().equals (st.getName ())) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            return true;
        }
        return false;
    }

    @Override
    public String getUsername() {
        return username;
    }
    public void print() {
        for (StockData st: stocks) {
            System.out.println (st.getName () + " " + st.getCnt () + " " + st.getPrice ());
        }
    }
    @Override
    public void update(StockData stockData, String notification) {
        for (int i = 0; i < stocks.size (); i++) {
            if (stocks.get (i).getName ().equals (stockData.getName ())) {
                stocks.set (i, stockData);
                break;
            }
        }
        System.out.println (notification);
        System.out.print ("New Stock data : ");
        System.out.println (stockData.getName () + " " + stockData.getCnt () + " " + stockData.getPrice ());
    }
}
