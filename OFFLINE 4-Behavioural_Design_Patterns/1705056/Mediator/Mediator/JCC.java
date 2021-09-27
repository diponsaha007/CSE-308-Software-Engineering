package Mediator;

import PublicServices.*;

import java.util.LinkedList;
import java.util.Queue;

public class JCC implements Mediator {
    Queue<String>[] queue;
    PublicService[] publicServices;

    public JCC() {
        publicServices = new PublicService[4];
        publicServices[0] = new JWSA (this);
        publicServices[1] = new JPDC (this);
        publicServices[2] = new JRTA (this);
        publicServices[3] = new JTRC (this);
        queue = new Queue[4];
        for (int i = 0; i < 4; i++) {
            queue[i] = new LinkedList<> ();
        }
        System.out.println ("All four services are initiated through mediator");
    }

    @Override
    public void notify(String sender, String service) {

        int id1 = -1, id2 = -1;
        for (int i = 0; i < 4; i++) {
            if (publicServices[i].service_name ().equalsIgnoreCase (sender)) {
                id1 = i;
            }
            if (publicServices[i].service_type ().equalsIgnoreCase (service)) {
                id2 = i;
            }
        }
        if (id1 == -1 || id2 == -1) {
            System.out.println ("Invalid Request");
            return;
        }
        System.out.println (sender + " requests for " + service + " service");
        queue[id2].add (sender);
        publicServices[id2].addService ();
    }

    @Override
    public void serve(String name) {
        int id1 = -1;
        for (int i = 0; i < 4; i++) {
            if (publicServices[i].service_name ().equalsIgnoreCase (name)) {
                id1 = i;
            }
        }
        if (id1 == -1) {
            System.out.println ("Invalid Request");
            return;
        }
        if(queue[id1].isEmpty ())
        {
            System.out.println ("Currently no service in queue.");
            return;
        }
        String s = queue[id1].poll ();
        publicServices[id1].serve ();
        System.out.println (name + " serves the request of " + s);
    }
}
