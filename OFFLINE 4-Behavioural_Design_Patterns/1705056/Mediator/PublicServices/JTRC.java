package PublicServices;

import Mediator.Mediator;

public class JTRC implements PublicService {
    private Mediator mediator;
    private int toServe;

    public JTRC(Mediator mediator) {
        this.mediator = mediator;
        toServe = 0;
    }

    @Override
    public String service_name() {
        return "JTRC";
    }

    @Override
    public String service_type() {
        return "TELECOM";
    }

    @Override
    public void serve() {
        toServe--;
    }

    @Override
    public void addService() {
        toServe++;
    }
}