package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Startpage extends AppCompatActivity {
    //기본
    //선언
    Button Btn;
    ImageView imageView;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

        imageView = (ImageView) findViewById(R.id.imageView);
        if (imageView == null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.animation_loading);
        anim = (AnimationDrawable) imageView.getBackground();
        anim.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

        protected void onPause(){
            super.onPause();
            finish();
        }

       // Btn = (Button)findViewById(R.id.startbutton);

     //   Btn.setOnClickListener(new View.OnClickListener() {
       //     @Override
         //   public void onClick(View view) {
           //     Intent intent = new Intent(Startpage.this, MainActivity.class);
            //    startActivity(intent);
         //   }
       // });
   // }
}