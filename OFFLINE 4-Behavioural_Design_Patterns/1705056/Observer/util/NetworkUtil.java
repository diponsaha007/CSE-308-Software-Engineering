package util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkUtil {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public NetworkUtil(String s, int port) {
        try {
            this.socket = new Socket(s, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("In NetworkUtil : " + e);
        }
    }

    public NetworkUtil(Socket s) {
        try {
            this.socket = s;
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("In NetworkUtil : " + e);
        }
    }

    public Object read() {
        Object o = null;
        try {
            o = ois.readObject();
        } catch (IOException|ClassNotFoundException e) {
            // System.out.println("Reading Error in networkutil : " + e);
            /*Just handle this exception Here*/
        }
        return o;
    }

    public void write(Object o) {
        try {
            oos.writeObject(o);
        } catch (IOException e) {
            System.out.println("Writing  Error in networkutil : " + e);
        }
    }

    public void closeConnection() {
        try {
            ois.close();
            oos.close();
        } catch (IOException e) {
            System.out.println("Closing Error in network : " + e);
        }
    }
}

/*OK*/