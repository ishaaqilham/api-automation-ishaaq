package util;

import org.json.JSONObject;

public class ResponseValidationUtil {
    JSONObject jsonObject;

    public String getValueForKey(String jsonResponse, String key) {
        jsonObject = new JSONObject(jsonResponse);
        return jsonObject.get(key).toString();
    }

    public String getValueForJSONObjectFromArray(String jsonResponse, String ArrayObjectKey, int arrayIndex, String key) {
        jsonObject = new JSONObject(jsonObject.getJSONArray(ArrayObjectKey).get(arrayIndex).toString());
        return jsonObject.get(key).toString();
    }
}
