package Connection;

public class Ethernet implements Connection {
    @Override
    public String type() {
        return "Using Ethernet connection";
    }
}
