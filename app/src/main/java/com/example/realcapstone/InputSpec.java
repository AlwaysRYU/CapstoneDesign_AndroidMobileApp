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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class InputSpec extends AppCompatActivity {

    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    InputSpec.DatabaseHelper handler;

    //선언
    Button next;
    EditText Gpointt;
    EditText Toeict;
    EditText Toeicst;
    EditText Foreignt;
    RadioGroup Opict;
    Cursor C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_spec);


        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        String message = myData + "님! 당신의 스펙을 입력하세요.";
        TextView temp1;
        temp1 = (TextView) findViewById(R.id.tv6);
        //값 매칭
        temp1.setText(message);

        //기타 선언
        next = (Button) findViewById(R.id.inputcomplete);
        Opict = (RadioGroup)findViewById(R.id.radioGroup1);
        Gpointt = (EditText)findViewById(R.id.IDtext);
        Toeict = (EditText)findViewById(R.id.in1);
        Toeicst = (EditText)findViewById(R.id.in2);
        Foreignt = (EditText)findViewById(R.id.in3);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);
                //받아온 텍스트
                //받아온 텍스트
                double GP = Double.parseDouble(Gpointt.getText().toString());
                double TP = Double.parseDouble(Toeict.getText().toString());
                double TSP = Double.parseDouble(Toeicst.getText().toString());
                double FP = Double.parseDouble(Foreignt.getText().toString());

                double OpicP = 6;
                //getCheckedRadioButtonId() 의 리턴값은 선택된 RadioButton 의 id 값.
                //이부분 수정 필요
                int temp = Opict.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(temp);
                String temp2 = rb.getText().toString();

                //수정완료 이거하느라 이틀고민했네짱나
                if("Advanced Low".equals(temp2)) {
                    OpicP = 5;
                }else if ("IH - IM3".equals(temp2)) {
                    OpicP = 4;
                }else if ("IM2 - IM1".equals(temp2)) {
                    OpicP = 3;
                }else if ("IL".equals(temp2)){
                    OpicP = 2;
                }else if ("NH 이하".equals(temp2)) {
                    OpicP = 1;
                }

                sql = "UPDATE User " +
                        "SET Gpoint =" + GP + "," +
                        "Toeic =" +   TP + "," +
                        "Toeicspeak =" + TSP + "," +
                        "Opic =" + OpicP + "," +
                        "Foreignt = " + FP +
                        " WHERE Id =" + "'" + myData + "';";

                if (db != null) {
                    //입력완료
                    db.execSQL(sql);
                    Toast toast = Toast.makeText(InputSpec.this, "완료! 계속 진행해 주세요.", Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(getApplicationContext(), InputSpec2.class);
                    intent.putExtra("loginID", myData);
                    startActivity(intent);

                }


            }
        });
    }


    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new InputSpec.DatabaseHelper(this);
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