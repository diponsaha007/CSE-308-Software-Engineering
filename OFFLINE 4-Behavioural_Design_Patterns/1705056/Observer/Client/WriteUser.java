package Client;

import util.NetworkUtil;

import java.util.Scanner;

import Stock.*;
import util.*;

public class WriteUser implements Runnable {
    private iUser user;
    private Thread thr;
    private NetworkUtil nc;

    public WriteUser(iUser user, NetworkUtil nc) {
        this.user = user;
        this.nc = nc;
        this.thr = new Thread (this);
        thr.start ();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner (System.in);
        while (true) {
            String type = scanner.next ();
            String name = scanner.next ();
            nc.write (type);
            nc.write (name);

        }
    }
}
