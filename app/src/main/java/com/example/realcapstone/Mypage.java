package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Mypage extends AppCompatActivity {
    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    Mypage.DatabaseHelper handler;

    Button inputspecbtn;
    Button userinfobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");

        inputspecbtn = (Button) findViewById(R.id.btn1);
        userinfobtn = (Button) findViewById(R.id.btn2);


        inputspecbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //스펙 수정 버튼 클릭시
                Intent intent = new Intent(Mypage.this, InputSpec.class);
                intent.putExtra("loginID", myData);
                //첫번째 인자는 STring타입의 키 / 두번째는 데이터

                startActivity(intent);
            }
        });

        userinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //사용자 정보 입력 버튼 클릭시
                Intent intent = new Intent(Mypage.this, Userinfo.class);
                intent.putExtra("loginID", myData);
                //첫번째 인자는 STring타입의 키 / 두번째는 데이터

                startActivity(intent);
            }
        });
    }

    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new Mypage.DatabaseHelper(this);
        if(f==false) {db = handler.getReadableDatabase();}
        else{db=handler.getWritableDatabase();}
    }
    private class DatabaseHelper extends SQLiteOpenHelper {
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