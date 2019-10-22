package com.company;

public class CityInfo {
    private String city;
    private Float maxTemp;
    private Float maxWindSpeed;

    CityInfo(String city, Float maxTemp, Float windSpeed) {
        this.city = city;
        this.maxTemp = maxTemp;
        this.maxWindSpeed = windSpeed;
    }

    public String getCity() {
        return city;
    }

    public Float getMaxTemp() {
        return maxTemp;
    }

    public Float getMaxWindSpeed() {
        return maxWindSpeed;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMaxTemp(Float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setWindSpeed(Float windSpeed) {
        this.maxWindSpeed = windSpeed;
    }

    public void display() {
        System.out.format("City name: %s%nMax Temp: %.1f F%nMax Wind Speed: %.1f mph%n",
                city, maxTemp, maxWindSpeed);
    }
}
