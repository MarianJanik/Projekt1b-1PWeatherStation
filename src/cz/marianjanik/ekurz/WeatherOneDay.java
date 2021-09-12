package cz.marianjanik.ekurz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WeatherOneDay {
    LocalDate date;
    double averageTemperature;
    double maximumTemperature;
    double minimumTemperature;
    double pressure;
    double windSpeed;
    double humidity;
    double precipitation;

    public WeatherOneDay(LocalDate date, double averageTemperature, double maximumTemperature, double minimumTemperature,
                         double pressure, double windSpeed, double humidity, double precipitation) {
        this.date = date;
        this.averageTemperature = averageTemperature;
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.precipitation = precipitation;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public double getMaximumTemperature() {
        return maximumTemperature;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public String getAllInfo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        return formatter.format(this.date)
                + ":\n- průměrná teplota - " + this.averageTemperature
                + "\n- maximální teplota - " + this.maximumTemperature
                + "\n- maximální teplota - " + this.minimumTemperature
                + "\n- maximální teplota - " + this.pressure
                + "\n- maximální teplota - " + this.windSpeed
                + "\n- maximální teplota - " + this.humidity
                + "\n- maximální teplota - " + this.precipitation;
    }
}
