package Packages;

import Hardware.ArduinoMegaHardware;
import Hardware.Hardware;
import WeightMeasurement.WeightMeasurement;
import WeightMeasurement.WeightModule;

public class Gold implements Package {

    @Override
    public Hardware hardware() {
        return new ArduinoMegaHardware ();
    }

    @Override
    public WeightMeasurement weightMeasurement() {
        return new WeightModule ();
    }
}
