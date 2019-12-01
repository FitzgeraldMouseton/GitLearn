package listener;

import org.json.simple.JSONObject;

public class ForecastDisplay implements Observer, DisplayElement {

    @Override
    public void update(JSONObject jsonObject) {

    }

    @Override
    public void display() {
        System.out.println("Forecast");
    }
}
