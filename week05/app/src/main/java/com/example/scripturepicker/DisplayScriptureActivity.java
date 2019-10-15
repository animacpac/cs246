package com.example.scripturepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScriptureActivity extends AppCompatActivity {

    String book;
    int chapter;
    int verse;
    Button saveScripture;
    Button loadScripture;
    TextView scriptureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        saveScripture = (Button) findViewById(R.id.saveScripture);
        loadScripture = (Button) findViewById(R.id.loadScripture);
        scriptureView = findViewById(R.id.scripture);

        Intent intent = getIntent();
        book = intent.getStringExtra(MainActivity.SEND_BOOK);
        chapter = Integer.valueOf(intent.getStringExtra(MainActivity.SEND_CHAPTER));
        verse = Integer.valueOf(intent.getStringExtra(MainActivity.SEND_VERSE));

        String scripture = book + " " + chapter + ":" + verse;
        scriptureView.setText(scripture);
        Log.d("DEBUG", "Successfully created intent");

        saveScripture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("SavedScriptures", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("book", book);
                editor.putInt("chapter", chapter);
                editor.putInt("verse", verse);

                editor.apply();

                Context context = getApplicationContext();
                CharSequence text = "Scripture saved";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        loadScripture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("SavedScriptures", 0);
                book = pref.getString("book", " ");
                chapter = pref.getInt("chapter", 0);
                verse = pref.getInt("verse", 0);
                Log.d("LOAD", "loading scripture");

                String scripture = book + " " + chapter + ":" + verse;

                TextView loadScriptureView = findViewById(R.id.loadedScripture);
                loadScriptureView.setText(scripture);
            }
        });
    }
}
