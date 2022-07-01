package com.example.cardiacrecorder;

public class RecordEdit extends Record {
    protected boolean isChecked;

    public RecordEdit(String systolicPressure, String diastolicPressure, String pulse, String date, String time, String comment, int level, boolean isChecked) {
        super(systolicPressure, diastolicPressure, pulse, date, time, comment, level);
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
