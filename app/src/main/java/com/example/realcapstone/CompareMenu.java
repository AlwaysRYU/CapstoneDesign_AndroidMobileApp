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

public class CompareMenu extends AppCompatActivity {
    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    CompareMenu.DatabaseHelper handler;

    ImageView number1;
    ImageView number2;

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
        setContentView(R.layout.activity_compare_menu);


        number1 = (ImageView) findViewById(R.id.number1);
        number2 = (ImageView) findViewById(R.id.number2);

        nextpage = (Button)findViewById(R.id.nextbtn);


        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");


        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 1;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);


                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu.this, Pass.class);
                    intent.putExtra("compareID",1);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu.this, Fail.class);
                    intent.putExtra("compareID",1);
                    startActivity(intent);
                }


            }
        });


        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOpen(true);

                String sql1 = "SELECT Specscore FROM User WHERE Id = '" + myData + "';";
                String sql2 = "SELECT cSpecscore FROM Enterprise WHERE cId = 2;";

                Cursor C1 = db.rawQuery(sql1,null);
                Cursor C2 = db.rawQuery(sql2, null);
                C1.moveToNext();
                C2.moveToNext();

                int userP = C1.getInt(0);
                int EnterP = C2.getInt(0);


                if (userP >= EnterP ) {
                    //합격시
                    Intent intent = new Intent(CompareMenu.this, Pass.class);
                    intent.putExtra("compareID",2);
                    startActivity(intent);

                }else if (userP < EnterP) {
                    //불합격시
                    Intent intent = new Intent(CompareMenu.this, Fail.class);
                    intent.putExtra("compareID",2);
                    startActivity(intent);
                }


            }
        });


        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompareMenu.this, CompareMenu2.class);
                startActivity(intent);

            }
        });
    }


    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new CompareMenu.DatabaseHelper(this);
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