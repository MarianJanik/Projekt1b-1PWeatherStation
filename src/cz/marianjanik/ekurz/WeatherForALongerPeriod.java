package cz.marianjanik.ekurz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherForALongerPeriod {
    private ArrayList <WeatherOneDay> oneDayArrayList = new ArrayList<>();

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

    public String getAllDayInfo(){
        StringBuilder builder = new StringBuilder();
        for (WeatherOneDay day: oneDayArrayList) {
            builder.append(day.getAllInfo() + "\n");
        }
        return builder.toString();
    }
}
