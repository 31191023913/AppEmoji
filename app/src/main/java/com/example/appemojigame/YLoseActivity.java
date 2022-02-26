package com.example.appemojigame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class YLoseActivity extends AppCompatActivity {
    Button btnLose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ylose);

        btnLose = findViewById(R.id.btnLose);
        btnLose.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), MainActivity.class);
            startActivity(myIntent);
        });
    }
}