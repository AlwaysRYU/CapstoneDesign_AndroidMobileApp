package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CompareMenu5 extends AppCompatActivity {

    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    CompareMenu5.DatabaseHelper handler;

    ImageView number1;
    ImageView number2;
    ImageView number3;
    ImageView number4;
    ImageView number5;
    ImageView number6;
    ImageView number7;
    ImageView number8;
    ImageView number9;
    ImageView number10;
    ImageView number11;
    ImageView number12;

    //선언
    boolean pass = true; // 합격
    TextView Tv;
    Button nextpage;
    EditText id;
    EditText pw;
    EditText Name;
    Cursor C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_menu5);


        number1 = (ImageView) findViewById(R.id.number1);
        number2 = (ImageView) findViewById(R.id.number2);
        number3 = (ImageView) findViewById(R.id.number3);
        number4 = (ImageView) findViewById(R.id.number4);
        number5 = (ImageView) findViewById(R.id.number5);
        number6 = (ImageView) findViewById(R.id.number6);
        number7 = (ImageView) findViewById(R.id.number7);
        number8 = (ImageView) findViewById(R.id.number8);
        number9 = (ImageView) findViewById(R.id.number9);
        number10 = (ImageView) findViewById(R.id.number10);
        number11 = (ImageView) findViewById(R.id.number11);
        number12 = (ImageView) findViewById(R.id.number12);




        //intent에서 값 받아오기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");




        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 33;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);
                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }

                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 33);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise",33);
                    startActivity(intent);
                }
            }
        });


        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 34;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);
                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }

                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 34);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 34);
                    startActivity(intent);
                }
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 35;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);
                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }

                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 35);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 35);
                    startActivity(intent);
                }
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 36;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);
                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }

                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 36);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 36);
                    startActivity(intent);
                }
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 37;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);
                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }

                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 37);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 37);
                    startActivity(intent);
                }
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 38;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);
                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }

                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 38);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 38);
                    startActivity(intent);
                }
            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 39;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);

                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }
                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 39);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 39);
                    startActivity(intent);
                }
            }
        });

        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 40;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);

                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }
                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 40);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 40);
                    startActivity(intent);
                }
            }
        });

        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 41;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);
                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }

                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 41);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 41);
                    startActivity(intent);
                }
            }
        });

        number10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 42;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);
                //차이
                double gap = (userP - EnterP);
                String gapmessage = "";
                if(gap >= 500 ){
                    gapmessage = "너무 월등합니다!";
                } else if ((300 <= gap) && (gap < 500)){
                    gapmessage = "우수한 인재 입니다..!!";
                } else if (( 0<= gap) && (gap < 300)) {
                    gapmessage = "우수합니다!";
                } else if (( -300 <= gap) && (gap < 0)){
                    gapmessage = "조금만 더 노력하면됩니다!";
                } else if ((gap  < -300)) {
                    gapmessage = "아직 많이 부족합니다...!!";
                }

                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu5.this, Pass.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 42);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu5.this, Fail.class);
                    intent.putExtra("gapmessage", gapmessage);
                    intent.putExtra("loginID",myData);
                    intent.putExtra("loginName", myName); //유저의 이름
                    intent.putExtra("Enterprise", 42);
                    startActivity(intent);
                }
            }
        });

        number11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompareMenu5.this, CompareMenu4.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름

                startActivity(intent);
            }
        });

        number12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompareMenu5.this, CompareMenu.class);
                intent.putExtra("loginID", myData);
                intent.putExtra("loginName", myName); //유저의 이름

                startActivity(intent);
            }
        });


//        nextpage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CompareMenu.this, CompareMenu2.class);
//                intent.putExtra("loginID", myData);
//                startActivity(intent);
//
//            }
//        });
    }


    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new CompareMenu5.DatabaseHelper(this);
        if(f==false) {db = handler.getReadableDatabase();}
        else{db=handler.getWritableDatabase();}
    }
    class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, databasename, null, dbversion);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            //println("DB 생성");
        }
        @Override
        public void onOpen(SQLiteDatabase db) { super.onOpen(db); }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("upgrade", "업그레이드했스비다. " + oldVersion + "to " +newVersion + ",");
        }
    }
    //여기까지는 해줘라

}