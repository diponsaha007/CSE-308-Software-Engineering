package Client;

import Stock.*;
import util.*;

public class ReadUser implements Runnable{
    private iUser user;
    private Thread thr;
    private NetworkUtil nc;

    public ReadUser(iUser user, NetworkUtil nc) {
        this.user = user;
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run() {
        while (true)
        {
            Object o = nc.read ();
            if(o instanceof StockData) {
                StockData stockData = (StockData) o;
                o = nc.read ();
                String notification = (String) o;
                user.update (stockData, notification);
            }
            else if(o instanceof Integer)
            {
                int done;
                done = (Integer) o;
                if (done == 0) {
                    System.out.println ("Operation not successful");
                }
                else {
                    Object ob = nc.read ();
                    StockData stockData = (StockData) ob;
                    boolean found = user.hasStock (stockData);

                    if (!found) {
                        System.out.println ("Successfully Subscribed to Stock " + stockData.getName ());
                        user.addStock (stockData);
                    }
                    else {
                        System.out.println ("Successfully Unsubscribed to Stock " + stockData.getName ());
                        user.removeStock (stockData);
                    }
                }
            }
        }
    }
}
