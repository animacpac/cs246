package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String getCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        return city;
    }

    private static String getURLString(String url) {
        String city = getCity();
        String key = "acff1addaf9d132dd11b199e618f0083";
        String units = "imperial";
        String query = url + city + "&units=" + units + "&apiKey=" + key;

        return query;
    }

    private static String getConditions(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        InputStream response = connection.getInputStream();
        Scanner scanner = new Scanner(response, StandardCharsets.UTF_8).useDelimiter("%A");
        String JSON = scanner.hasNext() ? scanner.next() : "";

        return JSON;
    }

    public static void partOne() {
        Gson g = new Gson();
        WeatherConditions wc;

        String currentURL = "https://api.openweathermap.org/data/2.5/weather?q=";
        String currentConditions = null;
        try {
            currentConditions = getConditions(getURLString(currentURL));
        } catch (IOException e) {
            e.printStackTrace();
        }
        wc = g.fromJson(currentConditions, WeatherConditions.class);

        wc.display();
    }

    public static void partTwo() {
        Gson g = new Gson();

        WeatherForecast wf;
        String forecastURL = "https://api.openweathermap.org/data/2.5/forecast?q=";
        String forecastConditions = null;
        try {
            forecastConditions = getConditions(getURLString(forecastURL));
        } catch (IOException e) {
            e.printStackTrace();
        }
        wf = g.fromJson(forecastConditions, WeatherForecast.class);

        wf.display();
    }

    public static void stretch() {
        Gson g = new Gson();
        List<CityInfo> cities = new ArrayList<CityInfo>();

        for (int i = 0; i < 5; i++) {
            //Get the forecast for a city
            WeatherForecast wf = new WeatherForecast();
            String forecastURL = "https://api.openweathermap.org/data/2.5/forecast?q=";
            String forecastConditions = null;
            try {
                forecastConditions = getConditions(getURLString(forecastURL));
            } catch (IOException e) {
                e.printStackTrace();
            }
            wf = g.fromJson(forecastConditions, WeatherForecast.class);

            //Get the max temp and max wind speed from the forecast
            Float maxTemp = -459.67f; // Lowest temp possible
            Float maxWindSpeed = 0f;  // Lowest wind speed possible
            for (WeatherForecastItem item : wf.getList()) {
                // Check if the temp is greater
                if (item.getMain().get("temp") > maxTemp) {
                    maxTemp = item.getMain().get("temp");
                }
                // Check if the wind speed is greater
                if (item.getWind().get("speed") > maxWindSpeed) {
                    maxWindSpeed = item.getWind().get("speed");
                }
            }
            cities.add(new CityInfo(wf.getCityName(), maxTemp, maxWindSpeed));
        }
        // Sort cities by maxTemp
        Collections.sort(cities, new SortByMaxTemp());
        System.out.printf("----------------------------------%n");
        System.out.printf("Sorted by max temp:%n");
        for (CityInfo city : cities) {
            System.out.printf("----------------------------------%n");
            city.display();
        }
        // Sort cities by maxWindSpeed
        Collections.sort(cities, new SortByMaxWindSpeed());
        System.out.printf("----------------------------------%n");
        System.out.printf("Sorted by max wind speed:%n");
        for (CityInfo city : cities) {
            System.out.printf("----------------------------------%n");
            city.display();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.printf("Enter a number: " +
                "\n\t1. Part 1: Weather conditions" +
                "\n\t2. Part 2: Weather forecast" +
                "\n\t3. Stretch: Forecast for 5 cities" +
                "\n>");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                partOne();
                break;
            case 2:
                partTwo();
                break;
            case 3:
                stretch();
                break;
        }
    }
}
