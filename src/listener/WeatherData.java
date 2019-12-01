package listener;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherData implements Subject {

    ArrayList<Observer> observers = new ArrayList<>();
    JSONObject weatherObject = new JSONObject();
    URL url;

    {
        try {
            url = new URL("https://api.darksky.net/forecast/63d0da6ac4c36d5248ae4e85a2842e15/37.8267,-122.4233?units=si");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    protected WeatherData() {
    }

    public JSONObject getWeatherObject() {
        JSONParser parser = new JSONParser();
        InputStream is = null;
        try {
            is = url.openStream();
            Scanner dis = new Scanner(is);
            JSONObject object = (JSONObject) parser.parse(dis.nextLine());
            JSONObject newObject = (JSONObject) object.get("currently");
            weatherObject.put("temperature", newObject.get("temperature"));
            weatherObject.put("pressure", newObject.get("pressure"));
            weatherObject.put("humidity", newObject.get("humidity"));
            weatherObject.put("apparentTemperature", newObject.get("apparentTemperature"));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return weatherObject;
    }

    @Override
    public void setMeasurements() {
        measurementsChanged();
    }

    void measurementsChanged(){
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        weatherObject = getWeatherObject();
        observers.forEach(o -> o.update(weatherObject));
    }
}
