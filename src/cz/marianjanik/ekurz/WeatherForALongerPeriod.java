package cz.marianjanik.ekurz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class WeatherForALongerPeriod {
    private ArrayList <WeatherOneDay> oneDayArrayList = new ArrayList<>();

    DecimalFormat myFormat = new DecimalFormat("#.0");

    public void add(WeatherOneDay addDay){
        oneDayArrayList.add(addDay);
    }

    public void remove(WeatherOneDay removeDay){
        oneDayArrayList.remove(removeDay);
    }

    public static WeatherForALongerPeriod importFromTextFile(String fileName) throws FileNotFoundException {
        WeatherForALongerPeriod summary = new WeatherForALongerPeriod();

        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                String[] items = inputLine.split(",");
                int year = Integer.valueOf(items[0]);
                int month = Integer.valueOf(items[1]);
                int day = Integer.valueOf(items[2]);
                WeatherOneDay oneDay = new WeatherOneDay(LocalDate.of(year, month, day), Double.valueOf(items[3]),
                        Double.valueOf(items[4]), Double.valueOf(items[5]), Double.valueOf(items[6]),
                        Double.valueOf(items[7]), Double.valueOf(items[8]), Double.valueOf(items[9]));
                summary.add(oneDay);
            }
            return summary;
        }
    }

    public String getAverageTemperature() {
        double sum = 0;
        for (WeatherOneDay weatherOneDay:oneDayArrayList) {
            sum+=weatherOneDay.getAverageTemperature();
        }
        double average = sum / oneDayArrayList.size();
        String text = "Average temperature for the reporting period: " + myFormat.format(average) + "°C";
        return text;
    }

    public String getMinTemperature() {
        WeatherOneDay minimumDay = Collections.min(oneDayArrayList,new TemperatureMinComparator());
        String text = "Minimum temperature for the reporting period: " + minimumDay.getDate() + " was "
                + myFormat.format(minimumDay.getMinimumTemperature()) +"°C";
        return text;
    }

    public String getMaxTemperature() {
        WeatherOneDay maximumDay = Collections.min(oneDayArrayList,new TemperatureMaxComparator());
        String text = "Maximum temperature for the reporting period: " + maximumDay.getDate() + " was "
                + myFormat.format(maximumDay.getMaximumTemperature()) +"°C";
        return text;
    }

    public String getAllDayInfo() {
        StringBuilder builder = new StringBuilder();
        for (WeatherOneDay day: oneDayArrayList) {
            builder.append(day.getAllInfo() + "\n");
        }
        return builder.toString();
    }



    public String getStandardGreeting() {
        return getLine() + "\nWelcome to the application for Meteorological Data Analysis.";
    }

    public String getSize() {
        String text = getLine() + "\nWe have " + oneDayArrayList.size() + " meteorological daily records to analyze.";
        return text;
    }


    private String getLine(){
        return "\n-----------------------------------------------------------------------";
    }

}
