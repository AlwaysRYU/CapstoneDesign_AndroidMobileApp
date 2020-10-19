package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pass extends AppCompatActivity {


    Button mainbtn;
    Button enterinfobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        mainbtn = (Button)findViewById(R.id.button2);
        enterinfobtn = (Button)findViewById(R.id.button3);

        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String enterID = intent.getStringExtra("compareID");

        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Pass.this, MainMenu.class);
                startActivity(intent);
            }
        });

        enterinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Pass.this, Enterinfo.class);
                intent.putExtra("compareID",enterID);
                startActivity(intent);
            }
        });

    }
}