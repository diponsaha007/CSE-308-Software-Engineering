package Packages;

import Hardware.Hardware;
import WeightMeasurement.WeightMeasurement;

public interface Package {
    Hardware hardware();
    WeightMeasurement weightMeasurement();
}
