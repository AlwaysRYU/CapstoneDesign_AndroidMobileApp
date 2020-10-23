package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fail extends AppCompatActivity {

    Button mainbtn;
    Button enterinfobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);

        mainbtn = (Button)findViewById(R.id.button2);
        enterinfobtn = (Button)findViewById(R.id.specbtn);

        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");
        final int enterprisenumber = intent.getExtras().getInt("Enterprise");


        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fail.this, MainMenu.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름
                intent.putExtra("Enterprise",enterprisenumber);
                startActivity(intent);
            }
        });

        enterinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fail.this, Enterinfo.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름
                intent.putExtra("Enterprise",enterprisenumber);
                startActivity(intent);
            }
        });


    }
}