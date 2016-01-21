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

    private String aqi;
    private String co;
    private String no2;
    private String o3;
    private String pm10;
    private String pm25;
    private String qlty;
    private String so2;

    private String level;
    private String stat;
    private String title;
    private String txt;
    private String type;

    private String code;

    private String fl;
    private String hum;
    private String pcpn;
    private String pres;
    private String tmp;
    private String vis;
    private String deg;
    private String dir;
    private String sr;
    private String spd;

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

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getQlty() {
        return qlty;
    }

    public void setQlty(String qlty) {
        this.qlty = qlty;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

    public static WeatherBean createFromJsonString(String weatherInfo) {
        if (weatherInfo != null && weatherInfo.length() > 0) {
            WeatherBean weatherBean = new WeatherBean();
            try {
                JSONObject jsonObject = new JSONObject(weatherInfo);
                if (jsonObject.has("HeWeather data service 3.0")) {
                    JSONArray jsonArray = new JSONArray(jsonObject.getString("HeWeather data service 3.0"));
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    JSONObject jsonObject5 = jsonObject1.getJSONObject("basic");
                    JSONObject jsonObject2 = jsonObject1.getJSONObject("aqi");
                    JSONObject jsonObject3 = jsonObject2.getJSONObject("city");
                    JSONObject jsonObject4 = jsonObject1.getJSONObject("now");

                    weatherBean.setCity(jsonObject5.getString("city"));
                    weatherBean.setCountry(jsonObject5.getString("cnty"));

                    weatherBean.setAqi(jsonObject3.getString("aqi"));
                    weatherBean.setPm25(jsonObject3.getString("pm25"));
                    weatherBean.setQlty(jsonObject3.getString("qlty"));

                    weatherBean.setFl(jsonObject4.getString("fl"));
                    weatherBean.setHum(jsonObject4.getString("hum"));
                    weatherBean.setTmp(jsonObject4.getString("tmp"));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weatherBean;
        } else return null;

    }


}
