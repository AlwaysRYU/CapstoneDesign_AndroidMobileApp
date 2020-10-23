package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainMenu extends AppCompatActivity {
    //선언
    Button mypagebtn;
    Button comparebtn;
    Button Interviewbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

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
        mypagebtn = (Button) findViewById(R.id.btn1);
        comparebtn = (Button) findViewById(R.id.btn2);
        Interviewbtn = (Button)findViewById(R.id.btn3);


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