package com.example.premraj.main1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button reset = (Button)findViewById(R.id.button4);
        Button add = (Button)findViewById(R.id.button3);
        EditText date = (EditText)findViewById(R.id.editText4);;
        EditText num = (EditText)findViewById(R.id.editText5);
        EditText name = (EditText)findViewById(R.id.editText2);
        SQLiteDatabase database = this.openOrCreateDatabase("files",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS docu(DOCU_NAME VARCHAR,DOCU_NUM VARCHAR,EXPIR_DATE DATE)");
        Cursor c = database.rawQuery("SELECT * FROM docu",null);
        String namee = name.getText().toString();
        String numm = num.getText().toString();
        String datee = date.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(database  namee);
        try{
            database.execSQL("INSERT INTO docu (DOCU_NAME,DOCU_NUM,EXPIR_DATE) VALUES(namee,numm,datee)");

        }
        catch ()

    }
}
