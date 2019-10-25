package com.example.prove06;

import java.util.List;

public class WeatherForecast {
    private class City {
        Integer id;
        String name;
    }

    private City city;
    private List<WeatherForecastItem> list;

    public String getCityName() {
        return city.name;
    }

    public List<WeatherForecastItem> getList() {
        return list;
    }

    public void display() {
        System.out.printf("ID: %d%n", city.id);
        System.out.printf("City: %s%n", city.name);
        for (WeatherForecastItem day : list) {
            System.out.printf("--------------------%n");
            System.out.printf("Date and Time: %s%n", day.getDt_txt());
            System.out.printf("Temp: %.1f F%n", day.getMain().get("temp"));
            System.out.printf("Weather: %s%n", day.getWeather().get(0).get("description"));
            System.out.printf("Wind: %.1f mph%n", day.getWind().get("speed"));
        }
    }
}