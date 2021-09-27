package PublicServices;

import Mediator.Mediator;

public class JRTA implements PublicService {
    private Mediator mediator;
    private int toServe;

    public JRTA(Mediator mediator) {
        this.mediator = mediator;
        toServe = 0;
    }

    @Override
    public String service_name() {
        return "JRTA";
    }

    @Override
    public String service_type() {
        return "TRANSPORT";
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
