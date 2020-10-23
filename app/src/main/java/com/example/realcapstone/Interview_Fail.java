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

public class Interview_Fail extends AppCompatActivity {
    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    Interview_Fail.DatabaseHelper handler;

    //
    String explain;
    TextView explainTV;
    Button again;
    Button mainmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview__fail);

        //db오픈
        databaseOpen(true);
        //
        explainTV = (TextView)findViewById(R.id.tv9);
        again = (Button)findViewById(R.id.againbtn);
        mainmenu = (Button)findViewById(R.id.mainbtn);


        //intent값 전달받기
        Intent intent = getIntent();
        //문제 넘버 받기
        final int questNumberr = intent.getIntExtra("questnumber",1);
        //myData는 아이디 이다.
        final String myName = intent.getStringExtra("loginName");
        final String myData = intent.getStringExtra("loginID");



        //문제
        sql = "SELECT * FROM Interview WHERE id = " + questNumberr +";";
        final Cursor C1 = db.rawQuery(sql,null);
        C1.moveToNext();
        explain = C1.getString(6);

        explainTV.setText(explain);


        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Interview.class);

                intent.putExtra("loginID", myData);
                intent.putExtra("loginName",myName);
                startActivity(intent);

            }
        });

        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainMenu.class);

                intent.putExtra("loginID", myData);
                intent.putExtra("loginName",myName);
                startActivity(intent);

            }
        });


    }


    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new Interview_Fail.DatabaseHelper(this);
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
