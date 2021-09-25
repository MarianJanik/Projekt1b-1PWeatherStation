package cz.marianjanik.ekurz;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        final String FILE1="B2BTUR01_07_2019.csv";

        WeatherForALongerPeriod weather;


        weather = WeatherForALongerPeriod.importFromTextFile(FILE1);

        System.out.println(weather.getStandardGreeting());
        System.out.println(weather.getSize());
        System.out.println(weather.getAverageTemperature());
        System.out.println(weather.getMaxTemperature());
        System.out.println(weather.getMinTemperature());
        System.out.println(weather.getWindInfo());
        System.out.println(weather.getSummaryPrecipitationInDecades());
        System.out.println(weather.graph());

        
//        System.out.println(weather.getAllDayInfo());


    }
}
