package cz.marianjanik.ekurz;

import java.util.Comparator;

public class TemperatureMaxComparator implements Comparator<WeatherOneDay> {
     @Override
     public int compare(WeatherOneDay first, WeatherOneDay second) {
            return (int) (second.getMaximumTemperature() - first.getMaximumTemperature());
    }
}
