package com.example.scripturepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String book;
    int chapter;
    int verse;

    String scripture;

    EditText bookInput;
    EditText chapterInput;
    EditText verseInput;

    Button submitButton;

    public static final String EXTRA_MESSAGE = "com.example.scripturepicker.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookInput = (EditText) findViewById(R.id.book);
        chapterInput = (EditText) findViewById(R.id.chapter);
        verseInput = (EditText) findViewById(R.id.verse);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book = bookInput.getText().toString();
                chapter = Integer.valueOf(chapterInput.getText().toString());
                verse = Integer.valueOf(verseInput.getText().toString());

                scripture = book + " " + chapter + ":" + verse;

                displayScripture();
            }
        });
    }

    private void displayScripture() {
        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        intent.putExtra(EXTRA_MESSAGE, scripture);
        startActivity(intent);
    }
}
