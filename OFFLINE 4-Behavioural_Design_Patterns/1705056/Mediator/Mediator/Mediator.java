package Mediator;

public interface Mediator {
    void notify(String sender, String service);

    void serve(String name);

}
