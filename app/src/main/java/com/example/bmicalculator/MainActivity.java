package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateBtn = findViewById(R.id.calculate);

        calculateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            startActivity(intent);
            finish();
        });
    }
}