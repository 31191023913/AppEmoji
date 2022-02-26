package com.example.appemojigame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class YWinActivity extends AppCompatActivity {
    Button btnWin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ywin);

        btnWin = findViewById(R.id.btnWin);
        btnWin.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), MainActivity.class);
            startActivity(myIntent);
        });
    }
}