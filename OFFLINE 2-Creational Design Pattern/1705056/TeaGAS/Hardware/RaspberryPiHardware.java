package Hardware;

import Controller.Controller;
import Controller.TouchScreenController;
import Display.Display;
import Display.TouchScreen;
import Identification.Identification;
import Identification.NFC;
import Microcontroller.Microcontroller;
import Microcontroller.RaspberryPi;
import Storage.InternalStorage;
import Storage.Storage;

public class RaspberryPiHardware implements Hardware {

    @Override
    public Microcontroller microcontroller() {
        return new RaspberryPi ();
    }

    @Override
    public Identification identification() {
        return new NFC ();
    }

    @Override
    public Storage storage() {
        return new InternalStorage ();
    }

    @Override
    public Display display() {
        return new TouchScreen ();
    }

    @Override
    public Controller controller() {
        return new TouchScreenController ();
    }
}
