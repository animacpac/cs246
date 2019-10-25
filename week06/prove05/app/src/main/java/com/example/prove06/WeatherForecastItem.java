package com.example.prove06;

import java.util.List;
import java.util.Map;

public class WeatherForecastItem {
        private String dt_txt;
        private Map<String, Float> main;
        private List<Map<String, String>> weather;
        private Map<String, Float> wind;

        WeatherForecastItem() {

        }

    public String getDt_txt() {
        return dt_txt;
    }

    public Map<String, Float> getMain() {
        return main;
    }

    public List<Map<String, String>> getWeather() {
        return weather;
    }

    public Map<String, Float> getWind() {
        return wind;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public void setMain(Map<String, Float> main) {
        this.main = main;
    }

    public void setWeather(List<Map<String, String>> weather) {
        this.weather = weather;
    }

    public void setWind(Map<String, Float> wind) {
        this.wind = wind;
    }
}
