package listener;

import org.json.simple.JSONObject;

public class CurrentWeatherDisplay implements Observer, DisplayElement {

    private float temperature;
    private float pressure;
    private float humidity;
    private float apparentTemperature;
    private Subject weatherData;

    public CurrentWeatherDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(JSONObject object) {
        temperature = Float.parseFloat(object.get("temperature").toString());
        pressure = Float.parseFloat(object.get("pressure").toString());
        humidity = Float.parseFloat(object.get("humidity").toString());
        apparentTemperature = Float.parseFloat(object.get("apparentTemperature").toString());
        display();
    }

    @Override
    public void display() {
        System.out.println("Temperature: " + temperature + "\nPressure: " + pressure + "\nHumidity: " + humidity + "\napparentTemperature: " + apparentTemperature);
    }
}
