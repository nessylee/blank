package com.example.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import kotlin.Unit;
import ru.cleverpumpkin.calendar.CalendarDate;
import ru.cleverpumpkin.calendar.CalendarView;


public class SheduleActivity extends AppCompatActivity {

    Button backButton;
    CalendarView calendarView;

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
        calendarView = findViewById(R.id.calendar_view);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 10, 27);
        CalendarDate initDate = new CalendarDate(calendar.getTime());

        calendar.set(2018, 10, 20);
        CalendarDate minDate = new CalendarDate(calendar.getTime());
        calendar.set(2018, 10, 30);
        CalendarDate maxDate = new CalendarDate(calendar.getTime());


        calendarView.setDatesIndicators(Arrays.asList(new TodayDateIndicator()));

        calendarView.setupCalendar(initDate, minDate, maxDate, CalendarView.SelectionMode.MULTIPLE, Collections.emptyList(),
                1, false);


        calendarView.setOnDateClickListener(date -> {

            List<CalendarView.DateIndicator> dateIndicators = calendarView.getDateIndicators(date);
            System.err.println(dateIndicators);
            System.err.println(dateIndicators.get(0).getColor());
            return Unit.INSTANCE;
                }
        );


    }

    public class TodayDateIndicator implements CalendarView.DateIndicator {

        @Override
        public int getColor() {
            return 100;
        }

        @NotNull
        @Override
        public CalendarDate getDate() {
            Calendar calendar = Calendar.getInstance();
            CalendarDate calendarDate = new CalendarDate(calendar.getTime());
            return calendarDate;
        }
    }

    private int userMakeChoice() {
        return new Random().nextBoolean() ? R.drawable.rawr : R.drawable.ic_keyboard_arrow_left_black_35dp;
    }
}