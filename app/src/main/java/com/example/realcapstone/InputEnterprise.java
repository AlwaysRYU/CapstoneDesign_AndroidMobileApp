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

public class InputEnterprise extends AppCompatActivity {

    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    InputEnterprise.DatabaseHelper handler;

    //선언
    Button next;
    EditText Gpointt;
    EditText Toeict;
    EditText Toeicst;
    EditText Foreignt;
    EditText copname;
    RadioGroup Opict;
    Cursor C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_enterprise);

        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");

        String message = myName + "님! 기업 스펙 입력하세요.";
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
        copname = (EditText)findViewById(R.id.inputcopname);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                //기업아이디
                String sql3 = "SELECT * FROM Enterprise ;";
                final Cursor C3 = db.rawQuery(sql3, null);
                int idnumber = 0;
                idnumber = C3.getCount() + 1;

                //기업이름
                String realcopname = copname.getText().toString();

                double tempScore = 0; //넘겨줄 스펙 스코어
                if(Toeict.length() == 0 ||
                        Gpointt.length() == 0 ||
                        Toeicst.length() == 0 ||
                        Foreignt.length() == 0){
                    Toast toast = Toast.makeText(InputEnterprise.this, "입력하지 않은 항목이 있습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                //받아온 텍스트
                //받아온 텍스트
                double GP = Double.parseDouble(Gpointt.getText().toString());
                double tempGP = 0;
                //학점의 범위에 따라
                if(GP == 4.5 ){
                    tempGP = 110;
                } else if ((4 <= GP) && (GP < 4.5)){
                    tempGP = 100;
                } else if ((3.5 <= GP) && (GP < 4)){
                    tempGP = 50;
                } else if ((2 <= GP) && (GP < 3.5)){
                    tempGP = 0;
                } else if ((0 <= GP) && (GP < 2)) {
                    tempGP = -30;
                } else {
                    Toast toast = Toast.makeText(InputEnterprise.this, "학점은 0 ~ 4.5의 범위안에서 입력해주세요", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                double TP = Double.parseDouble(Toeict.getText().toString());
                double tempTP = 0;
                //토익의 범위에 따라
                if(TP == 990 ){
                    tempTP = 120;
                } else if ((900 <= TP) && (TP < 990)){
                    tempTP = 100;
                } else if ((850 <= TP) && (TP < 900)) {
                    tempTP = 90;
                } else if ((750 <= TP) && (TP < 850)){
                    tempTP = 80;
                } else if ((0 <= TP) && (TP < 750)) {
                    tempTP = (TP * 0.1);
                } else {
                    Toast toast = Toast.makeText(InputEnterprise.this, "토익은  0 ~ 990의 범위안에서 입력해주세요", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                double TSP = Double.parseDouble(Toeicst.getText().toString());
                double tempTSP = 0;
                //토익스피킹의 범위
                if(TSP == 8 ){
                    tempTSP = 120;
                } else if (TSP == 7){
                    tempTSP = 100;
                } else if (TSP == 6 ) {
                    tempTSP = 70;
                } else if (TSP == 5) {
                    tempTSP = 50;
                } else if (( 0 <= TSP ) && (TSP <=4)) {
                    tempTSP = 0;
                } else {
                    Toast toast = Toast.makeText(InputEnterprise.this, "1부터 8까지의 레벨로 입력 해주세요.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                double FP = Double.parseDouble(Foreignt.getText().toString());
                double tempFP = (FP * 40); //언어자격증

                double OpicP = 6;
                double tempOpicP = 0;
                //getCheckedRadioButtonId() 의 리턴값은 선택된 RadioButton 의 id 값.
                //이부분 수정 필요
                int temp = Opict.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(temp);
                String temp2 = rb.getText().toString();

                //수정완료 이거하느라 이틀고민했네짱나
                if("Advanced Low".equals(temp2)) {
                    OpicP = 5;
                    tempOpicP = 95;
                }else if ("IH".equals(temp2)) {
                    OpicP = 4;
                    tempOpicP = 85;
                }else if ("IM3".equals(temp2)) {
                    OpicP = 3;
                    tempOpicP = 65;
                }else if ("IM2".equals(temp2)){
                    OpicP = 2;
                    tempOpicP = 50;
                }else if ("IM1 이하".equals(temp2)) {
                    OpicP = 1;
                    tempOpicP = 20;
                }

                if (tempTP >= tempTSP ){
                    //토익이 제일 클경우
                    if (tempTSP >= tempOpicP){
                        tempScore = tempGP + tempFP + tempTP + (tempTSP * 0.8) + (tempOpicP * 0.8);
                    } else if ( tempTP >= tempOpicP ) {
                        tempScore = tempGP + tempFP + tempTP + (tempTSP * 0.8) + (tempOpicP * 0.8);
                    }
                }

                if (tempTSP >= tempTP ){
                    //토스가 제일 클경우
                    if (tempTP >= tempOpicP){
                        tempScore = tempGP + tempFP + tempTSP + (tempOpicP * 0.8) + (tempTP * 0.8);
                    } else if ( tempTSP >= tempOpicP ) {
                        tempScore = tempGP + tempFP + tempTSP + (tempOpicP * 0.8) + (tempTP * 0.8);
                    }
                }

                if (tempOpicP >= tempTP ){
                    //오픽이제일 클경우
                    if (tempTP >= tempTSP){
                        tempScore = tempGP + tempFP + tempOpicP + (tempTSP * 0.8) + (tempTP * 0.8);
                    } else if ( tempOpicP >= tempTSP ) {
                        tempScore = tempGP + tempFP + tempOpicP + (tempTSP * 0.8) + (tempTP * 0.8);
                    }
                }

//                sql = "UPDATE Enterprise " +
//                        "SET " + "" +
//                        "cId = " + idnumber + "," +
//                        "cName = '" + realcopname + "'," +
//                        "cGpoint =" + GP + "," +
//                        "cToeic =" +   TP + "," +
//                        "cToeicspeak =" + TSP + "," +
//                        "cOpic =" + OpicP + "," +
//                        "cForeign = " + FP +
//                        ";";

                sql = "INSERT" +
                        " INTO Enterprise (cId, cName, cGpoint, cToeic, cToeicspeak, cOpic, cForeign) " +
                        " VALUES ( " + idnumber + ",'" + realcopname + "', " + GP +  ", " + TP + "," + TSP + "," + OpicP +  "," + FP + " ) ;";


                if (db != null) {
                    //입력완료
                    db.execSQL(sql);
                    Toast toast = Toast.makeText(InputEnterprise.this, "완료! 계속 진행해 주세요.", Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(getApplicationContext(), InputEnterprise2.class);
                    intent.putExtra("loginID", myData); // user아이디
                    intent.putExtra("loginName",myName);
                    intent.putExtra("SpecScore", tempScore);
                    intent.putExtra("enterid", idnumber);
                    startActivity(intent);

                }


            }
        });
    }


    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new InputEnterprise.DatabaseHelper(this);
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