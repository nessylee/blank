package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.util.Locale;

public class SheduleActivity extends AppCompatActivity {

    CalendarView calendarView;
    Button button2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shedule_activity);

        //Back button

        button2 = (Button) findViewById(R.id.button2);
        View.OnClickListener oclBt = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SheduleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };

        button2.setOnClickListener(oclBt);


        //Change language

        String languageToLoad = "ru";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        //как блеать с этим работать :(

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {


            }
    });
    }
}
