package com.example.prove06;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class GetForecast extends AsyncTask {

    private WeatherForecast wf;
    private WeakReference<Activity> activity;
    private String cityName;

    public GetForecast(WeakReference<Activity> activity, String cityName) {
        this.activity = activity;
        this.cityName = cityName;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String apiKey = "";
        String forecastURL = "https://api.openweathermap.org/data/2.5/forecast?q=" + this.cityName +
                "&units=imperial&apikey=" + apiKey;
        String conditions = "";
        try {
            URLConnection connection = new URL(forecastURL).openConnection();
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response, "UTF-8").useDelimiter("%A");

            conditions = scanner.hasNext() ? scanner.next() : "";
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson g = new Gson();
        wf = g.fromJson(conditions, WeatherForecast.class);

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        final Activity act = activity.get();
        if (act != null) {
            act.runOnUiThread(new Runnable() {
                public void run() {
                    ArrayList<String> forecastDays = new ArrayList<>();
                    for (WeatherForecastItem day : wf.getList()) {
                        String forecast = day.getDt_txt() + "     " + day.getMain().get("temp") + " F         " + day.getWeather().get(0).get("description");
                        forecastDays.add(forecast);
                    }
                    final ListView lv1 = act.findViewById(R.id.list);
                    lv1.setAdapter(new ArrayAdapter<>(act.getApplicationContext(), android.R.layout.simple_list_item_1, forecastDays));
                }
            });
        }
    }
}
