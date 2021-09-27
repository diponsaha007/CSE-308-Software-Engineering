package Packages;

import Hardware.Hardware;
import Hardware.RaspberryPiHardware;
import WeightMeasurement.LoadSensor;
import WeightMeasurement.WeightMeasurement;

public class Diamond implements Package {

    @Override
    public Hardware hardware() {
        return new RaspberryPiHardware ();
    }

    @Override
    public WeightMeasurement weightMeasurement() {
        return new LoadSensor ();
    }
}
