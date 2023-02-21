package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    TextView bmiDisplay, bmiCategory, mGender;
    Intent intent;
    ImageView imageView;
    String bmi;
    float fBmi;

    String height;
    String weight;
    float intHeight, intWeight;
    RelativeLayout background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activtiy);

        Button recalculateBtn = findViewById(R.id.recalculate);

        intent = getIntent();
        bmiDisplay = findViewById(R.id.displayBmi);
        bmiCategory = findViewById(R.id.category);
        mGender = findViewById(R.id.resultGender);
        background = findViewById(R.id.resultLayout);
        imageView = findViewById(R.id.resultImage);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");
        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight / 100;
        fBmi = intWeight / (intHeight * intHeight);

        bmi = Float.toString(fBmi);

        if (fBmi < 16) {
            bmiCategory.setText("Severe Thinnes");
            imageView.setImageResource(R.drawable.crosspng);
        } else if (fBmi < 16.9 && fBmi > 16) {
            bmiCategory.setText("Moderate Thinnes");
            imageView.setImageResource(R.drawable.warning);
        } else if (fBmi < 18.4 && fBmi > 17) {
            bmiCategory.setText("Mild Thinnes");
            imageView.setImageResource(R.drawable.warning);
        } else if (fBmi < 25 && fBmi > 18.5) {
            bmiCategory.setText("Normal");
            imageView.setImageResource(R.drawable.tick);
        } else if (fBmi < 29.4 && fBmi > 24.9) {
            bmiCategory.setText("Overweight");
            imageView.setImageResource(R.drawable.warning);
        } else {
            bmiCategory.setText("Obese");
            imageView.setImageResource(R.drawable.crosspng);
        }

        mGender.setText(intent.getStringExtra("gender"));
        bmiDisplay.setText(bmi);

        recalculateBtn.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        });

    }
}