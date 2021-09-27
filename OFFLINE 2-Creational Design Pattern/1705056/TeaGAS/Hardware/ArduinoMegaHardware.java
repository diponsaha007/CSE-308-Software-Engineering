package Hardware;

import Controller.ButtonController;
import Controller.Controller;
import Display.Display;
import Display.LED;
import Identification.Identification;
import Identification.RFID;
import Microcontroller.ArduinoMega;
import Microcontroller.Microcontroller;
import Storage.SDCard;
import Storage.Storage;

public class ArduinoMegaHardware implements Hardware {

    @Override
    public Microcontroller microcontroller() {
        return new ArduinoMega ();
    }

    @Override
    public Identification identification() {
        return new RFID ();
    }

    @Override
    public Storage storage() {
        return new SDCard ();
    }

    @Override
    public Display display() {
        return new LED ();
    }

    @Override
    public Controller controller() {
        return new ButtonController ();
    }
}
