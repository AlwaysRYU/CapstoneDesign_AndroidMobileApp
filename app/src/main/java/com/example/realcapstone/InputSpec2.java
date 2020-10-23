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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class InputSpec2 extends AppCompatActivity {

    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    InputSpec2.DatabaseHelper handler;


    //선언
    Button next;
    EditText Licenset;
    EditText Abroadt;
    EditText Internt;
    EditText Awardst;
    EditText Schoolt;
    Cursor C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_spec2);


        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");
        final double realspecscore = intent.getExtras().getDouble("SpecScore");
        String message = myData + "님! 부가적인 스펙을 입력하세요.";
        TextView temp1;
        temp1 = (TextView) findViewById(R.id.inputspec2_tv2);
        //값 매칭
        temp1.setText(message);

        //기타 선언
        next = (Button) findViewById(R.id.inputcomplete);
        Licenset = (EditText)findViewById(R.id.in1);
        Abroadt = (EditText)findViewById(R.id.in2);
        Internt = (EditText)findViewById(R.id.in3);//인턴
        Awardst = (EditText)findViewById(R.id.in4);
        Schoolt = (EditText)findViewById(R.id.in5); //봉사활동


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Licenset.length() == 0 ||
                        Abroadt.length() == 0 ||
                        Internt.length() == 0 ||
                        Awardst.length() == 0 ||
                        Schoolt.length() == 0 ){
                    Toast toast = Toast.makeText(InputSpec2.this, "입력하지 않은 항목이 있습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                databaseOpen(true);
                //받아온 텍스트
                //받아온 텍스트

                double LicenseP = Double.parseDouble(Licenset.getText().toString());
                double tempLP = LicenseP * 50;

                double AbroadP = Double.parseDouble(Abroadt.getText().toString());
                double tempAbroadP = AbroadP * 90;

                double InternP = Double.parseDouble(Internt.getText().toString());
                double tempInternP = InternP * 120;

                double AwardP = Double.parseDouble(Awardst.getText().toString());
                double tempAwardP = AwardP * 110;

                double VP = Double.parseDouble(Schoolt.getText().toString());
                double tempVP = VP * 60;

                double REALSC = 0;
                REALSC = realspecscore + tempLP + tempAbroadP + tempInternP + tempAwardP + tempVP;

                sql = "UPDATE User " +
                        "SET " +
                        "Specscore = " + REALSC + "," +
                        "License =" + LicenseP + "," +
                        "Abroad =" +   AbroadP + "," +
                        "Intern =" + InternP + "," +
                        "Award =" + AwardP + "," +
                        "School = " + VP +
                        " WHERE Id =" + "'" + myData + "';";

                if (db != null) {
                    //입력완료
                    db.execSQL(sql);
                    Toast toast = Toast.makeText(InputSpec2.this, "스펙입력완료!.", Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                    intent.putExtra("loginID", myData);
                    intent.putExtra("loginName",myName);
                    startActivity(intent);
                    finish();
                }


            }
        });

    }




    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new InputSpec2.DatabaseHelper(this);
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