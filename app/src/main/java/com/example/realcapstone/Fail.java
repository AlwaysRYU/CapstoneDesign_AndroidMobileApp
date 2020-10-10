package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fail extends AppCompatActivity {

    Button mainbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);

        mainbtn = (Button)findViewById(R.id.button2);


        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Fail.this, MainMenu.class);
                startActivity(intent);
            }
        });


    }
}