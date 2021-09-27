package PublicServices;

import Mediator.Mediator;

public class JWSA implements PublicService {
    private Mediator mediator;
    private int toServe;

    public JWSA(Mediator mediator) {
        this.mediator = mediator;
        toServe = 0;
    }

    @Override
    public String service_name() {
        return "JWSA";
    }

    @Override
    public String service_type() {
        return "WATER";
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
