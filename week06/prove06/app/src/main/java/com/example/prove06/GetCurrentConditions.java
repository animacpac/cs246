package com.example.prove06;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;


class GetCurrentConditions extends AsyncTask {

    private WeatherConditions wc;
    private WeakReference<Activity> activity;
    private String cityName;

    GetCurrentConditions(WeakReference<Activity> activity, String cityName) {
        this.activity = activity;
        this.cityName = cityName;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        Log.d("DEBUG", "Attempting to retrieve weather information");
        String apiKey = "";
        String currentURL = "https://api.openweathermap.org/data/2.5/weather?q=" + this.cityName +
                "&units=imperial&apikey=" + apiKey;
        String conditions = "";
        try {
            URLConnection connection = new URL(currentURL).openConnection();
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response, "UTF-8").useDelimiter("%A");

            conditions = scanner.hasNext() ? scanner.next() : "";
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson g = new Gson();
        wc = g.fromJson(conditions, WeatherConditions.class);

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        final Activity act = activity.get();

        if (act != null) {
            final CharSequence temp = wc.getMeasurements().get("temp") + " F";
            Toast toast = Toast.makeText(act.getApplicationContext(), (CharSequence) temp, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
