package com.dkl.auser.myapplication;

import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DatePicker dp;
    private Button b;
    private Calendar cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = (DatePicker)findViewById(R.id.datePicker);
        b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year,month,date;

                year = dp.getYear();
                month = dp.getMonth();
                date = dp.getDayOfMonth();
                Toast.makeText(MainActivity.this, "年月日"+year+"/"+month+"/"+date+"/", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    cal = Calendar.getInstance();
                }


                DatePicker.OnDateChangedListener onDateChangedListener = new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {
                        Toast.makeText(MainActivity.this, "年月日"+year+"/"+monthofyear+"/"+dayofmonth+"/", Toast.LENGTH_LONG).show();
                    }
                };


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    dp.init(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),onDateChangedListener);
                }

            }
        });


    }
}
