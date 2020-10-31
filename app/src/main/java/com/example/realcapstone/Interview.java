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

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Interview extends AppCompatActivity {
    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    Interview.DatabaseHelper handler;

    int temppp=0;

    //이창에서쓰는것들
    TextView Question;
    String Q = "";
    Button A,B,C,D;
    TextView imsi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
        //데베 오픈
        databaseOpen(true);

        //선언
        Question = (TextView)findViewById(R.id.tv9);
        A = (Button)findViewById(R.id.answer1);
        B = (Button)findViewById(R.id.answer2);
        C = (Button)findViewById(R.id.answer3);
        D = (Button)findViewById(R.id.answer4);

        imsi = (TextView)findViewById(R.id.tv8);

        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");

        imsi.setText(myData);


        //랜덤 문 설정
        Random r = new Random();
        final int[] temp = {2,3,4,5};
        String[] temp2 =new String[]{"","","",""};
        for (int i = 0; i<4; i++ ){
            temp[i] = r.nextInt(4) + 2;
            for(int j= 0; j<i;j++){
                if(temp[i] == temp[j]) {
                    i--;
                }
            }
        }


        //문제설정
        final int quest = r.nextInt(3) + 1;

        //문제
        sql = "SELECT * FROM Interview WHERE id = " + quest +";";
        final Cursor C1 = db.rawQuery(sql,null);
        C1.moveToNext();
        Q = C1.getString(1);

        for(int i=0; i<4; i++){
            temp2[i] = C1.getString(temp[i]);
        }

        //화면에 하기
        A.setText(temp2[0]);
        B.setText(temp2[1]);
        C.setText(temp2[2]);
        D.setText(temp2[3]);
        Question.setText(Q);

        C1.close();

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp3 = C1.getColumnName(temp[0]);
                if("Ans".equals(temp3)){

                    Intent intent = new Intent(getApplicationContext(), Interview_Pass.class);
                    //인터뷰 성공시"SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                    String sql2 = "SELECT InterviewPoint FROM User WHERE Id = '"+ myData  + "';";
                    final Cursor C2 = db.rawQuery(sql2, null);
                    C2.moveToFirst();

                    temppp  = C2.getInt(0);
                    temppp += 1;

                    sql2 = "UPDATE User " +
                            "SET InterviewPoint =" + temppp +
                            " WHERE Id =" + "'" + myData + "';";
                    db.execSQL(sql2);

                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName", myName);
                    intent.putExtra("questnumber", quest);
                    startActivity(intent);

                }else{
                    Intent intent = new Intent(getApplicationContext(), Interview_Fail.class);

                    //인터뷰 실패시
                    String sql2 = "SELECT InterviewPoint FROM User WHERE Id = '"+ myData  + "';";
                    final Cursor C2 = db.rawQuery(sql2, null);
                    C2.moveToNext();
                    temppp = C2.getInt(0);

                    if(temppp == 0 ){
                        temppp = 0;
                    } else temppp -= 1;

                    sql2 = "UPDATE User " +
                            "SET InterviewPoint =" + temppp  +
                            " WHERE Id =" + "'" + myData + "';";
                    db.execSQL(sql2);

                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName", myName);
                    intent.putExtra("questnumber", quest);
                    startActivity(intent);
                }
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp3 = C1.getColumnName(temp[1]);
                if("Ans".equals(temp3)){

                    Intent intent = new Intent(getApplicationContext(), Interview_Pass.class);
                    //인터뷰 성공시"SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                    String sql2 = "SELECT InterviewPoint FROM User WHERE Id = '"+ myData  + "';";
                    final Cursor C2 = db.rawQuery(sql2, null);
                    C2.moveToFirst();

                    temppp  = C2.getInt(0);
                    temppp += 1;

                    sql2 = "UPDATE User " +
                            "SET InterviewPoint =" + temppp +
                            " WHERE Id =" + "'" + myData + "';";
                    db.execSQL(sql2);

                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName", myName);
                    intent.putExtra("questnumber", quest);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), Interview_Fail.class);
                    //인터뷰 실패시
                    String sql2 = "SELECT InterviewPoint FROM User WHERE Id = '"+ myData  + "';";
                    final Cursor C2 = db.rawQuery(sql2, null);
                    C2.moveToNext();
                    temppp = C2.getInt(0);

                    if(temppp == 0 ){
                        temppp = 0;
                    } else temppp -= 1;

                    sql2 = "UPDATE User " +
                            "SET InterviewPoint =" + temppp  +
                            " WHERE Id =" + "'" + myData + "';";
                    db.execSQL(sql2);
                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName", myName);
                    intent.putExtra("questnumber", quest);
                    startActivity(intent);
                }
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp3 = C1.getColumnName(temp[2]);
                if("Ans".equals(temp3)){

                    Intent intent = new Intent(getApplicationContext(), Interview_Pass.class);
                    //인터뷰 성공시

                    //인터뷰 성공시"SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                    String sql2 = "SELECT InterviewPoint FROM User WHERE Id = '"+ myData  + "';";
                    final Cursor C2 = db.rawQuery(sql2, null);
                    C2.moveToFirst();

                    temppp  = C2.getInt(0);
                    temppp += 1;

                    sql2 = "UPDATE User " +
                            "SET InterviewPoint =" + temppp +
                            " WHERE Id =" + "'" + myData + "';";
                    db.execSQL(sql2);

                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName", myName);
                    intent.putExtra("questnumber", quest);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), Interview_Fail.class);
                    //인터뷰 실패시
                    String sql2 = "SELECT InterviewPoint FROM User WHERE Id = '"+ myData  + "';";
                    final Cursor C2 = db.rawQuery(sql2, null);
                    C2.moveToNext();
                    temppp = C2.getInt(0);

                    if(temppp == 0 ){
                        temppp = 0;
                    } else temppp -= 1;

                    sql2 = "UPDATE User " +
                            "SET InterviewPoint =" + temppp  +
                            " WHERE Id =" + "'" + myData + "';";
                    db.execSQL(sql2);
                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName", myName);
                    intent.putExtra("questnumber", quest);
                    startActivity(intent);
                }

            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp3 = C1.getColumnName(temp[3]);
                if("Ans".equals(temp3)){

                    Intent intent = new Intent(getApplicationContext(), Interview_Pass.class);
                    //인터뷰 성공시
                    //인터뷰 성공시"SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                    String sql2 = "SELECT InterviewPoint FROM User WHERE Id = '"+ myData  + "';";
                    final Cursor C2 = db.rawQuery(sql2, null);
                    C2.moveToFirst();

                    temppp  = C2.getInt(0);
                    temppp += 1;

                    sql2 = "UPDATE User " +
                            "SET InterviewPoint =" + temppp +
                            " WHERE Id =" + "'" + myData + "';";
                    db.execSQL(sql2);
                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName", myName);
                    intent.putExtra("questnumber", quest);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), Interview_Fail.class);
                    //인터뷰 실패시
                    String sql2 = "SELECT InterviewPoint FROM User WHERE Id = '"+ myData  + "';";
                    final Cursor C2 = db.rawQuery(sql2, null);
                    C2.moveToNext();
                    temppp = C2.getInt(0);

                    if(temppp == 0 ){
                        temppp = 0;
                    } else temppp -= 1;

                    sql2 = "UPDATE User " +
                            "SET InterviewPoint =" + temppp  +
                            " WHERE Id =" + "'" + myData + "';";
                    db.execSQL(sql2);
                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName", myName);
                    intent.putExtra("questnumber", quest);
                    startActivity(intent);
                }
            }
        });





    }




    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new Interview.DatabaseHelper(this);
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