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

public class Register extends AppCompatActivity {
    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    Register.DatabaseHelper handler;

    //선언
    TextView Tv;
    Button regi;
    EditText id;
    EditText pw;
    EditText Name;
    Cursor C;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        //기타 선언
        regi = (Button) findViewById(R.id.registerbutton);
        id = (EditText)findViewById(R.id.IDtext);
        pw = (EditText)findViewById(R.id.in1);
        Name = (EditText)findViewById(R.id.in2);

        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);
                //받아온 텍스트
                String idt = id.getText().toString();
                String pwt = pw.getText().toString();
                String Namet = Name.getText().toString();

                //스트링
                String sql = "";

                if(idt.length() == 0 || pwt.length() == 0  || Namet.length() ==0){
                    Toast toast = Toast.makeText(Register.this, "빈칸을 채워주시오", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                else if (db != null){
                    //회원가입 완료
                    db.execSQL("INSERT INTO User (Id, Password, Name) VALUES ('" + idt +"', '"+ pwt + "', '" + Namet + "');" );
                    Toast toast = Toast.makeText(Register.this, "회원가입 완료!", Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(Register.this, "회원가입실패", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });



    }

    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new Register.DatabaseHelper(this);
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