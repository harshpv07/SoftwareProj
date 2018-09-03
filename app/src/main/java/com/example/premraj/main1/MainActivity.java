package com.example.premraj.main1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int date;
    int month;
    int year;
    int remsetdate;
    int remsetmonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final TextView textView =(TextView) findViewById(R.id.textView);
        final Button accept = (Button) findViewById(R.id.button);
        final Button decline = (Button)findViewById(R.id.button2);
        final CalendarView setdate = findViewById(R.id.calendarView);
        final EditText editText = findViewById(R.id.editText);
        setdate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                date = i2;
                month = i1;           //get the date of the exipiry date.
                year = i;
                Toast.makeText(MainActivity.this, date + "/"+month+"/"+year, Toast.LENGTH_LONG).show();

            }
        });
        remsetdate=date-Integer.parseInt(editText.getText().toString());
        if(date<Integer.parseInt(editText.getText().toString())){
            month=month-1;
            date=date+30;
        }
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                spinner.setPrompt("");


            }
        });
        


        textView.setGravity(Gravity.CENTER);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.documents,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(this);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(this,);
                //startActivity(intent);// go to the storage page
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String string = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, "You have selected"+ string, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Select the date of exipiry from the calender", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please select an option from the above list", Toast.LENGTH_LONG).show();

    }



}
