package com.example.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SheduleActivity extends AppCompatActivity {
    Button backButton;
    CalendarView calendarView;
    List<EventDay> events = new ArrayList<>();

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shedule_activity);

        backButton = findViewById(R.id.button2);

        Button.OnClickListener onClickListener = v -> {
            Intent intent = new Intent(SheduleActivity.this, MainActivity.class);
            startActivity(intent);
        };

        backButton.setOnClickListener(onClickListener);
        calendarView = findViewById(R.id.calendarView);

        /*
        Calendar calendar = Calendar.getInstance();
        try {
            calendarView.setDate(calendar);
        } catch (OutOfDateRangeException e) {
            throw new RuntimeException(e); // todo сделать оповещалку, когда научишься
        }*/


        calendarView.setOnDayClickListener(eventDay -> {
                    int icon = userMakeChoice();
                    events.add(new EventDay(eventDay.getCalendar(), icon));
                    calendarView.setEvents(events);
                }
        );
    }

    private int userMakeChoice() {
        return new Random().nextBoolean() ? R.drawable.rawr : R.drawable.ic_keyboard_arrow_left_black_35dp;
    }
}