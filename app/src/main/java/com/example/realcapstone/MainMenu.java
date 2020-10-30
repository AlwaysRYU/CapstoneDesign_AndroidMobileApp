package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainMenu extends AppCompatActivity {
    //선언
    ImageView mypagebtn;
    ImageView comparebtn;
    ImageView Interviewbtn;
    ImageView inputspecbtn;
    TextView i_text, i_info;
    Animation atg, atgtwo, atgthree; //애니메이션

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        atg= AnimationUtils.loadAnimation(this,R.anim.atg); // 애니메이션
        atgtwo= AnimationUtils.loadAnimation(this,R.anim.atgtwo);
        atgthree= AnimationUtils.loadAnimation(this,R.anim.atgthree);

        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");

        String message = "반갑습니다. " + myName + "님!";
        TextView temp1;
        temp1 = (TextView) findViewById(R.id.tv5);
        //값 매칭
        temp1.setText(message);

        //선언해주기
        mypagebtn = (ImageView) findViewById(R.id.ic_myinfo); //userinfobtn으로
        comparebtn = (ImageView) findViewById(R.id.ic_apply);
        Interviewbtn = (ImageView) findViewById(R.id.ic_interview);
        inputspecbtn = (ImageView) findViewById(R.id.ic_spec);
        i_text = (TextView) findViewById(R.id.interview_text);
        i_info = (TextView) findViewById(R.id.interview_info);

        // pass an animation
        Interviewbtn.startAnimation(atg);
        i_text.startAnimation(atg);
        i_info.startAnimation(atg);

        mypagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //스펙 입력 버튼 클릭시
                Intent intent = new Intent(MainMenu.this, Mypage.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름

                //첫번째 인자는 STring타입의 키 / 두번째는 데이터

                startActivity(intent);
            }
        });

        comparebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, CompareMenu.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름

                startActivity(intent);
            }
        });

        Interviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, InterviewMenu.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름

                startActivity(intent);
            }
        });


    }

}