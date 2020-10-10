package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pass extends AppCompatActivity {


    Button mainbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        mainbtn = (Button)findViewById(R.id.button2);


        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Pass.this, MainMenu.class);
                startActivity(intent);
            }
        });


    }
}