package Connection;

public class GSM implements Connection {
    @Override
    public String type() {
        return "Using GSM connection";
    }
}
