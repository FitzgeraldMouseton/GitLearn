package listener;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {


        WeatherData weatherData = new WeatherData();
        CurrentWeatherDisplay currentWeatherDisplay = new CurrentWeatherDisplay(weatherData);
        while (true){
            weatherData.measurementsChanged();
            Thread.sleep(3000);
        }
    }
}
