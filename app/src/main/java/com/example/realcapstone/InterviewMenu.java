package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class InterviewMenu extends AppCompatActivity {


    TextView no1;
    TextView no2;
    TextView no3;
    TextView yes;
    int score = 0;
    TextView interview_text;
    Animation anidown;
    Button startInterview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_menu);

        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");

        anidown= AnimationUtils.loadAnimation(this,R.anim.anidown);
        interview_text = (TextView) findViewById(R.id.maintext);
        interview_text.startAnimation(anidown);


        Button Interviewbtn = (Button)findViewById(R.id.interviewbtn);

        Interviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterviewMenu.this, Interview.class);
                intent.putExtra("loginName", myName);
                intent.putExtra("loginID", myData);
                startActivity(intent);

            }
        });




    }
}