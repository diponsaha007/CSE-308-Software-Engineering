package Connection;

public class WiFi implements Connection {

    @Override
    public String type() {
        return "Using WiFi connection";
    }
}
