package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InterviewMenu extends AppCompatActivity {


    TextView no1;
    TextView no2;
    TextView no3;
    TextView yes;
    int score = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_menu);
    }
}