package Hardware;

import Controller.ButtonController;
import Controller.Controller;
import Display.Display;
import Display.LCD;
import Identification.Identification;
import Identification.RFID;
import Microcontroller.ATMega32;
import Microcontroller.Microcontroller;
import Storage.SDCard;
import Storage.Storage;

public class ATMega32Hardware implements Hardware {

    @Override
    public Microcontroller microcontroller() {
        return new ATMega32 ();
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
        return new LCD ();
    }

    @Override
    public Controller controller() {
        return new ButtonController ();
    }

}
