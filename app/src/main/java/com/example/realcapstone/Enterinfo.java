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
import android.widget.TextView;

public class Enterinfo extends AppCompatActivity {
    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    Enterinfo.DatabaseHelper handler;

    Button mainbtn;

    //출력을 위한 변수 선언
    TextView a1;
    TextView a2;
    TextView a3;
    TextView a4;
    TextView a5;
    TextView a6;
    TextView a7;
    TextView a8;
    TextView a9;
    TextView a10;
    TextView a11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterinfo);

        mainbtn = (Button)findViewById(R.id.button2);

        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Enterinfo.this, MainMenu.class);
                startActivity(intent);
            }
        });

        //값 할당
        TextView a1 = (TextView) findViewById(R.id.text1);
        TextView a2 = (TextView) findViewById(R.id.text3);
        TextView a3 = (TextView) findViewById(R.id.text4);
        TextView a4 = (TextView) findViewById(R.id.text5);
        TextView a5 = (TextView) findViewById(R.id.text6);
        TextView a6 = (TextView) findViewById(R.id.text7);
        TextView a7 = (TextView) findViewById(R.id.text8);
        TextView a8 = (TextView) findViewById(R.id.text9);
        TextView a9 = (TextView) findViewById(R.id.text10);
        TextView a10 = (TextView) findViewById(R.id.text11);
        TextView a11 = (TextView) findViewById(R.id.text12);

        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        //enterID는 기업 이다.
        final String enterID = intent.getStringExtra("compareID");

        databaseOpen(true);

        String sql2 = "SELECT * FROM Enterprise WHERE cId = enterID;";

        Cursor C2 = db.rawQuery(sql2,null);

        C2.moveToNext();

        String aa1 = C2.getString(1);
        a1.setText(aa1);
        String a22 = C2.getString(4);
        a2.setText(a22);
        String a33 = C2.getString(5);
        a3.setText(a33);
        String a44 = C2.getString(6);
        a4.setText(a44);
        String a55 = C2.getString(7);
        a5.setText(a55);
        String a66 = C2.getString(8);
        a6.setText(a66);
        String a77 = C2.getString(9);
        a7.setText(a77);
        String a88 = C2.getString(10);
        a8.setText(a88);
        String a99 = C2.getString(11);
        a9.setText(a99);
        String a1010 = C2.getString(12);
        a10.setText(a1010);
        String a1111 = C2.getString(13);
        a11.setText(a1111);

    }

    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new Enterinfo.DatabaseHelper(this);
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