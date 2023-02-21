package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mCurrentHeight, mCurrentAge, mCurrentWeight;
    ImageView mIncrementAge, mIncrementWeight, mDecrementWeight, mDecrementAge;
    SeekBar mSeekbar;
    RelativeLayout mMale, mFemale;

    int intWeight = 55;
    int intAge = 22;
    int currentProgress;
    String mProgress = "170";
    String typeOfUser = "0";
    String weight = "55";
    String age = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateBtn = findViewById(R.id.calculate);

        mCurrentAge = findViewById(R.id.currentAge);
        mCurrentHeight = findViewById(R.id.currentHeight);
        mCurrentWeight = findViewById(R.id.currentWeight);
        mIncrementAge = findViewById(R.id.incrementAge);
        mIncrementWeight = findViewById(R.id.incrementWeight);
        mDecrementWeight = findViewById(R.id.decrementWeight);
        mDecrementAge = findViewById(R.id.decrementAge);
        mSeekbar = findViewById(R.id.seekbarforheight);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);


        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selectbg));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.notselect));
                typeOfUser = "Male";
            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selectbg));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.notselect));
                typeOfUser = "Female";
            }
        });


        mSeekbar.setMax(300);
        mSeekbar.setProgress(170);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentProgress = i;
                mProgress = String.valueOf(currentProgress);
                mCurrentHeight.setText(mProgress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge = intAge + 1;
                age = String.valueOf(intAge);
                mCurrentAge.setText(age);
            }
        });


        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight = intWeight + 1;
                weight = String.valueOf(intWeight);
                mCurrentWeight.setText(weight);
            }
        });

        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight = intWeight - 1;
                weight = String.valueOf(intWeight);
                mCurrentWeight.setText(weight);
            }
        });

        mDecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge = intAge - 1;
                age = String.valueOf(intAge);
                mCurrentAge.setText(age);
            }
        });


        calculateBtn.setOnClickListener(view -> {
            if (typeOfUser.equals("0")) {
                Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
            } else if (mProgress.equals("0")) {
                Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
            } else if (intAge == 0 || intAge < 0) {
                Toast.makeText(getApplicationContext(), "Age is Incorrect", Toast.LENGTH_SHORT).show();
            } else if (intWeight == 0 || intWeight < 0) {
                Toast.makeText(getApplicationContext(), "Weight is Incorrect", Toast.LENGTH_SHORT).show();
            } else {

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

                intent.putExtra("gender", typeOfUser);
                intent.putExtra("height", mProgress);
                intent.putExtra("weight", weight);
                intent.putExtra("age", age);


                startActivity(intent);
                finish();
            }
        });
    }
}