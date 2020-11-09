package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

//import nl.dionsegijn.konfetti.KonfettiView;
//import nl.dionsegijn.konfetti.models.Shape;
//import nl.dionsegijn.konfetti.models.Size;

public class Pass extends AppCompatActivity {

    ImageView pass_konfetti;
    Button mainbtn;
    Button enterinfobtn;
    TextView gap;

    Animation anipass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        //konfetti
        /*final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_heart);
        final Shape.DrawableShape drawableShape = new Shape.DrawableShape(drawable, true);
        final KonfettiView konfettiView = findViewById(R.id.konfetti_View);

        konfettiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                konfettiView.build()
                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                        .setDirection(0.0, 359.0)
                        .setSpeed(1f, 5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape)
                        .addSizes(new Size(12, 5f))
                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                        .streamFor(300, 5000L);
            }
        });*/

        anipass = AnimationUtils.loadAnimation(this,R.anim.anipass);

        mainbtn = (Button)findViewById(R.id.button2);
        //enterinfobtn = (Button)findViewById(R.id.button3);
        enterinfobtn = (Button)findViewById(R.id.specbtn);
        gap = (TextView)findViewById(R.id.gap);


        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");
        final int enterprisenumber = intent.getExtras().getInt("Enterprise");
        final String gapmessage = intent.getStringExtra("gapmessage");

        gap.setText(gapmessage);

        pass_konfetti = (ImageView)findViewById(R.id.imageView1);
        pass_konfetti.startAnimation(anipass);

        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pass.this, MainMenu.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름
                intent.putExtra("Enterprise",enterprisenumber);
                startActivity(intent);
            }
        });

        enterinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pass.this, Enterinfo.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름
                intent.putExtra("Enterprise",enterprisenumber);
                startActivity(intent);
            }
        });

    }
}