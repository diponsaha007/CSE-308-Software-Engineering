package Stock;

import Client.*;

import java.util.ArrayList;

public class Stock {
    public StockData stockData;
    public ArrayList<iUser> observer;

    public Stock(StockData stockData) {
        this.stockData = stockData;
        observer = new ArrayList<> ();
    }

    public int add(iUser x) {
        for (int i = 0; i < observer.size (); i++) {
            if (observer.get (i).getUsername () == x.getUsername ()) {
                return 0;
            }
        }
        observer.add (x);
        return 1;
    }

    public int remove(iUser x) {
        int idx = -1;
        for (int i = 0; i < observer.size (); i++) {
            if (observer.get (i).getUsername () == x.getUsername ()) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            observer.remove (idx);
            return 1;
        }
        return 0;
    }

    public void increase(double x) {
        stockData.setPrice (stockData.getPrice () + x);
    }

    public void change_count(int x) {
        stockData.setCnt (x);
    }

    public String getName() {
        return stockData.getName ();
    }
}
