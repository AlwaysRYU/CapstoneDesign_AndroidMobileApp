package com.example.realcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Userinfo extends AppCompatActivity {
    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    Userinfo.DatabaseHelper handler;

    //출력을 위한 변수 선언
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        //값 할당
        TextView a = (TextView) findViewById(R.id.text1);
        TextView b = (TextView) findViewById(R.id.text2);
        TextView c = (TextView) findViewById(R.id.text3);
        TextView d = (TextView) findViewById(R.id.text4);
        TextView e = (TextView) findViewById(R.id.text5);
        TextView f = (TextView) findViewById(R.id.text6);
        TextView g = (TextView) findViewById(R.id.text7);
        TextView h = (TextView) findViewById(R.id.text8);
        TextView i = (TextView) findViewById(R.id.text9);
        TextView j = (TextView) findViewById(R.id.text10);
        TextView k = (TextView) findViewById(R.id.text11);
        TextView l = (TextView) findViewById(R.id.text12);

        //intent값 전달받기
        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");

        databaseOpen(true);

        String sql1 = "SELECT * FROM User WHERE Id = '" + myData + "';";

        Cursor C1 = db.rawQuery(sql1,null);

        C1.moveToNext();

        String aa = C1.getString(0);
        a.setText(aa);
        String bb = C1.getString(1);
        b.setText(bb);
        int cc = C1.getInt(4);
        c.setText(cc);
        int dd = C1.getInt(5);
        d.setText(dd);
        int ee = C1.getInt(6);
        e.setText(ee);
        int ff = C1.getInt(7);
        f.setText(ff);
        int gg = C1.getInt(8);
        g.setText(gg);
        int hh = C1.getInt(9);
        h.setText(hh);
        int ii = C1.getInt(10);
        i.setText(ii);
        int jj = C1.getInt(11);
        j.setText(jj);
        int kk = C1.getInt(12);
        k.setText(kk);
        int ll = C1.getInt(13);
        l.setText(ll);

    }

    //기본으로 해줘야할 것
    private void databaseOpen(boolean f){
        handler = new Userinfo.DatabaseHelper(this);
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