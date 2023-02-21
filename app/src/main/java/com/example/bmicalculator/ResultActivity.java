package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activtiy);

        Button recalculateBtn = findViewById(R.id.recalculate);

        recalculateBtn.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        });

    }
}