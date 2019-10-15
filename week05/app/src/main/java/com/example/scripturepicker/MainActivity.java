package com.example.scripturepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String book;
    String chapter;
    String verse;

    String scripture;

    EditText bookInput;
    EditText chapterInput;
    EditText verseInput;

    Button submitButton;

    public static final String SEND_BOOK = "com.example.scripturepicker.SEND_BOOK";
    public static final String SEND_CHAPTER = "com.example.scripturepicker.SEND_CHAPTER";
    public static final String SEND_VERSE = "com.example.scripturepicker.SEND_VERSE";

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
                chapter = chapterInput.getText().toString();
                verse = verseInput.getText().toString();

                displayScripture();
            }
        });
    }

    private void displayScripture() {
        Log.d("DEBUG", "About to create scripture intent");
        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        intent.putExtra(SEND_BOOK, book);
        intent.putExtra(SEND_CHAPTER, chapter);
        intent.putExtra(SEND_VERSE, verse);
        startActivity(intent);
    }
}
