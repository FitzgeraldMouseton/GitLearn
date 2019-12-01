package listener;

import org.json.simple.JSONObject;

public interface Observer {

    void update(JSONObject jsonObject);
}
