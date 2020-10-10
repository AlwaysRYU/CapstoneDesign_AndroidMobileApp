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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //기본
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    MainActivity.DatabaseHelper handler;
    TextView Tv;

    //선언
    EditText id;
    EditText pw;
    Button Loginbtn;
    TextView registerButton;

    Cursor C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //선언
        //받아온 아이디와 비밀번호

        id = (EditText)findViewById(R.id.IDtext);
        pw = (EditText)findViewById(R.id.in1);
        Loginbtn = (Button)findViewById(R.id.loginbutton);
        registerButton = (TextView) findViewById(R.id.registerbutton);


        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);
                //받아온 텍스트
                String idt = id.getText().toString();
                String pwt = pw.getText().toString();

                if(idt.length() == 0 || pwt.length() == 0 ){
                    Toast toast = Toast.makeText(MainActivity.this, "입력해라..", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                String sql = "SELECT Id FROM User WHERE Id = '" + idt + "'";
                C = db.rawQuery(sql,null);

                if(C.getCount() != 1 ){
                    Toast toast = Toast.makeText(MainActivity.this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                sql = "SELECT Password FROM User WHERE Id = '" + idt + "'";
                C = db.rawQuery(sql,null);
                C.moveToNext();
                if(!pwt.equals(C.getString(0))){
                    Toast toast = Toast.makeText(MainActivity.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    //로그인 성공시!!!
                    Toast toast = Toast.makeText(MainActivity.this, "환영합니다!", Toast.LENGTH_SHORT);
                    toast.show();


                    Intent intent = new Intent(getApplicationContext(),MainMenu.class);
                    intent.putExtra("loginID", idt);
                    //첫번째 인자는 STring타입의 키 / 두번째는 데이터
                    startActivityForResult(intent,0);
                    finish();
                }
                C.close();

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

    }



    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new MainActivity.DatabaseHelper(this);
        if(f==false) {db = handler.getReadableDatabase();}
        else{db=handler.getWritableDatabase();}
    }

    //private void println(String msg) { Tv.append(msg + "\n"); }
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

    //로그인
    public void Login(){

    }


}