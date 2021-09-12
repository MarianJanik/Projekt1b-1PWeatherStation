package cz.marianjanik.ekurz;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        final String FILE1="B2BTUR01_07_2019.csv";

        WeatherForALongerPeriod weather;


        weather = WeatherForALongerPeriod.importFromTextFile(FILE1);

        System.out.println(weather.getAllDayInfo());


    }
}
