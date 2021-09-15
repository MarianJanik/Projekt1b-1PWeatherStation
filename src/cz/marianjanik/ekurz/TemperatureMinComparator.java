package cz.marianjanik.ekurz;

import java.util.Comparator;

public class TemperatureMinComparator implements Comparator<WeatherOneDay> {
    @Override
    public int compare(WeatherOneDay first, WeatherOneDay second) {
        return (int) (first.getMinimumTemperature() - second.getMinimumTemperature());
    }
}
