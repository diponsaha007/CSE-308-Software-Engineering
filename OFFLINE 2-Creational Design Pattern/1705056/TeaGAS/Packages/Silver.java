package Packages;

import Hardware.ATMega32Hardware;
import Hardware.Hardware;
import WeightMeasurement.LoadSensor;
import WeightMeasurement.WeightMeasurement;

public class Silver implements Package {

    @Override
    public Hardware hardware() {
        return new ATMega32Hardware ();
    }

    @Override
    public WeightMeasurement weightMeasurement() {
        return new LoadSensor ();
    }
}
