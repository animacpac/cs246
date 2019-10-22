package com.company;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class WeatherConditions {
    private Integer id;
    private String name;
    @SerializedName("main")
    private Map <String, Float> measurements;

    public WeatherConditions() {
        this.id = 0;
        this.name = "";
        this.measurements = new HashMap<String, Float>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void display() {
        System.out.printf("ID: %d%n", id);
        System.out.printf("City: %s%n", name);
        for (Map.Entry<String, Float> x : measurements.entrySet()) {
            System.out.printf("%s: %f%n", x.getKey(), x.getValue());
        }
    }
}
