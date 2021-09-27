package PublicServices;

import Mediator.Mediator;

public class JPDC implements PublicService {
    private Mediator mediator;
    private int toServe;

    public JPDC(Mediator mediator) {
        this.mediator = mediator;
        toServe = 0;
    }

    @Override
    public String service_name() {
        return "JPDC";
    }

    @Override
    public String service_type() {
        return "POWER";
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
