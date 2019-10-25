package com.example.prove06;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {

    EditText cityName;

    Button currentTemp;
    Button weatherForecast;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (EditText) findViewById(R.id.cityName);
        currentTemp = (Button) findViewById(R.id.temp);
        weatherForecast = (Button) findViewById(R.id.forecast);
        list = (ListView) findViewById(R.id.list);
        List<String> weatherList = new ArrayList<>();
        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, weatherList);
        list.setAdapter(adapt);

        currentTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentTemp(cityName.getText().toString());
            }
        });

        weatherForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getForecast(cityName.getText().toString());
            }
        });

    }

    private void getCurrentTemp(String cityName) {
        new GetCurrentConditions(new WeakReference<Activity>(this), cityName).execute();
    }

    private void getForecast(String cityName) {
        new GetForecast(new WeakReference<Activity>(this), cityName).execute();
    }
}
