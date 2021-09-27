package Packages;

import Hardware.Hardware;
import Hardware.RaspberryPiHardware;
import WeightMeasurement.WeightMeasurement;
import WeightMeasurement.WeightModule;

public class Platinum implements Package {

    @Override
    public Hardware hardware() {
        return new RaspberryPiHardware ();
    }

    @Override
    public WeightMeasurement weightMeasurement() {
        return new WeightModule ();
    }
}
