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

public class Userinfo extends AppCompatActivity {
    //기본으로는
    String databasename = "capstone.db";
    String sql = "";
    int dbversion = 1;
    SQLiteDatabase db;
    Userinfo.DatabaseHelper handler;

    Button mainbtn;

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
//intent값 전달받기

        Intent intent = getIntent();
        //myData는 아이디 이다.
        final String myData = intent.getStringExtra("loginID");
        final String myName = intent.getStringExtra("loginName");
        mainbtn = (Button)findViewById(R.id.button2);

        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Userinfo.this, MainMenu.class);
                intent.putExtra("loginID", myData);
                //첫번째 인자는 STring타입의 키 / 두번째는 데이터
                intent.putExtra("loginName",myName);
                startActivity(intent);
                startActivity(intent);
            }
        });


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



        databaseOpen(true);

        String sql1 = "SELECT * FROM User WHERE Id = '" + myData + "';";

        Cursor C1 = db.rawQuery(sql1,null);

        C1.moveToNext();

        String aa = C1.getString(0);
        a.setText(aa);
        String bb = C1.getString(1);
        b.setText(bb);
        String cc = C1.getString(4);
        c.setText(cc);
        String dd = C1.getString(5);
        d.setText(dd);
        String ee = C1.getString(6);
        e.setText(ee);
        String ff = C1.getString(7);
        f.setText(ff);
        String gg = C1.getString(8);
        g.setText(gg);
        String hh = C1.getString(9);
        h.setText(hh);
        String ii = C1.getString(10);
        i.setText(ii);
        String jj = C1.getString(11);
        j.setText(jj);
        String kk = C1.getString(12);
        k.setText(kk);
        String ll = C1.getString(13);
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