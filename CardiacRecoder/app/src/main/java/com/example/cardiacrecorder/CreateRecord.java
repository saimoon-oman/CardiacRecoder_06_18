package com.example.cardiacrecorder;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateRecord extends AppCompatActivity {

    private Button selectDate, selectTime, saveButton;
    private String entryDate, entryTime, entryNotes;
    private int entrySystolic, entryDiastolic, entryPulse;
    private EditText systolic, diastolic, pulse, notes;
    private ImageView tickMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_record);

        getSupportActionBar().hide();

        Intent intent = getIntent();

        selectDate = findViewById(R.id.date);
        selectTime = findViewById(R.id.time);
        saveButton = findViewById(R.id.saveButton);
        tickMark = findViewById(R.id.tickButton);
        systolic = findViewById(R.id.systolic);
        diastolic = findViewById(R.id.diastolic);
        pulse = findViewById(R.id.pulse);
        notes = findViewById(R.id.notes);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int min = calendar.get(Calendar.MINUTE);



        SimpleDateFormat format = new SimpleDateFormat("HH:mm a");

        String time = format.format(calendar.getTime());
        selectTime.setText(time);
        selectTime.setTextColor(Color.parseColor("#000000"));

        String dateStr = "04/05/2010";

        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String date = curFormater.format(dateObj);
        selectDate.setText(date);
        selectDate.setTextColor(Color.parseColor("#000000"));

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(CreateRecord.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        selectDate.setText(date);
                        selectDate.setTextColor(Color.parseColor("#000000"));


                    }
                }, year, month, day);
                dialog.show();
            }
        });

        selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(CreateRecord.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String AM_PM;
                        if (hourOfDay>=0&&hourOfDay<12){
                            AM_PM=" AM";
                        }else {
                            AM_PM=" PM";
                         }
                        if (hourOfDay == 0 || hourOfDay == 12) hourOfDay = 12;
                        else hourOfDay = hourOfDay%12;
                    selectTime.setText ( hourOfDay + ":" + minute+""+AM_PM );
                    }
                }, hour, min, false);
                timePickerDialog.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                entryDate = selectDate.getText().toString();
                entryTime = selectTime.getText().toString();
                entrySystolic = Integer.parseInt(systolic.getText().toString());
                entryDiastolic = Integer.parseInt(diastolic.getText().toString());
                entryPulse = Integer.parseInt(pulse.getText().toString());
                entryNotes = notes.getText().toString();


                    Intent intent1 = new Intent(CreateRecord.this, MainActivity.class);
                    startActivity(intent1);
                    finish();

            }
        });

        tickMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entryDate = selectDate.getText().toString();
                entryTime = selectTime.getText().toString();
                entrySystolic = Integer.parseInt(systolic.getText().toString());
                entryDiastolic = Integer.parseInt(diastolic.getText().toString());
                entryPulse = Integer.parseInt(pulse.getText().toString());
                entryNotes = notes.getText().toString();

                    Intent intent2 = new Intent(CreateRecord.this, MainActivity.class);
                    startActivity(intent2);
                    finish();

            }
        });

    }
}