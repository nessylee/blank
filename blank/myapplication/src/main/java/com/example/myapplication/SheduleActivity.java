package com.example.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import java.util.Calendar;
import java.util.Collections;
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
        calendar.set(2018, 00, 01);
        CalendarDate initDate = new CalendarDate(calendar.getTime());

        calendar.set(2018, 11, 01);
        CalendarDate minDate = new CalendarDate(calendar.getTime());
        calendar.set(2018, 11, 31);
        CalendarDate maxDate = new CalendarDate(calendar.getTime());

        calendarView.setupCalendar(initDate, minDate, maxDate, CalendarView.SelectionMode.MULTIPLE, Collections.emptyList(),
                1, false);


               /* calendarView.setDatesIndicators(Arrays.asList(new TodayDateIndicator()));



                calendarView.setOnDateClickListener(date -> {

                            List<CalendarView.DateIndicator> dateIndicators = calendarView.getDateIndicators(date);
                           return Unit.INSTANCE;
                        }
                );

            }

           public class TodayDateIndicator implements CalendarView.DateIndicator {

                @Override
                public int getColor() {
                    return 0;
                }

                @NotNull
                @Override
                public CalendarDate getDate() {
                    return null;
                }
            }

            private int userMakeChoice() {
                return new Random().nextBoolean() ? R.drawable.rawr : R.drawable.ic_keyboard_arrow_left_black_35dp;*/

            }
        }

