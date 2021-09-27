package Hardware;

import Controller.Controller;
import Display.Display;
import Identification.Identification;
import Microcontroller.Microcontroller;
import Storage.Storage;

public interface Hardware {
    Microcontroller microcontroller();

    Identification identification();

    Storage storage();

    Display display();

    Controller controller();
}
