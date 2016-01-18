package com.dreamyrao.jianweather.bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by raomengyang on 1/18/16.
 */
public class WeatherBean {
    public static String TAG = WeatherBean.class.getSimpleName();

    private String weatherServiceName;
    private String basic;

    private String city;
    private String country;
    private String cityId;
    private String lat;
    private String lon;

    public String getWeatherServiceName() {
        return weatherServiceName;
    }

    public void setWeatherServiceName(String weatherServiceName) {
        this.weatherServiceName = weatherServiceName;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public static WeatherBean createFromJsonString(String weatherInfo) {
        if (weatherInfo != null && weatherInfo.length() > 0) {
            WeatherBean weatherBean = new WeatherBean();
            try {
                JSONObject jsonObject = new JSONObject(weatherInfo);
                if (jsonObject.has("HeWeather data service 3.0")) {
                    JSONArray jsonArray = new JSONArray(jsonObject.getString("HeWeather data service 3.0"));
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
//                    Log.e(TAG, jsonObject1.getString("basic").toString());
                    JSONObject jsonObject2 = jsonObject1.getJSONObject("basic");
                    weatherBean.setCity(jsonObject2.getString("city"));
                    weatherBean.setCountry(jsonObject2.getString("cnty"));
//                    for (int i = 0; i < jsonArray1.length(); i++) {
//                        JSONObject jsonObject2 = new JSONArray().getJSONObject(i);
//                        Log.e(TAG, jsonObject2.getString("city"));
//                        weatherBean.setCity(jsonObject2.getString("city"));
//                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weatherBean;
        } else return null;

    }


}
