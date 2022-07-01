package com.example.cardiacrecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class EditDelete extends AppCompatActivity {

    ListView recordListEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);
        getSupportActionBar().hide();

        recordListEdit = findViewById(R.id.recordListEdit);

        Record r1 = new Record("100", "70", "65", "28-JUN-2022", "10:30 AM", "Sick..", 1);
        Record r2 = r1;
        Record r3 = r1;
        Record r4 = r1;
        Record r5 = r1;
        Record r6 = r1;
        Record r7 = r1;
        Record r8 = r1;
        Record r9 = r1;
        Record r10 = r1;

        ArrayList<Record> recordArrayList = new ArrayList<>();

        recordArrayList.add(r1);
        recordArrayList.add(r2);
        recordArrayList.add(r3);
        recordArrayList.add(r4);
        recordArrayList.add(r5);
        recordArrayList.add(r6);
        recordArrayList.add(r7);
        recordArrayList.add(r8);
        recordArrayList.add(r9);
        recordArrayList.add(r10);

        RecordListEditAdapter adapter = new RecordListEditAdapter(this, R.id.rowLayoutEdit, recordArrayList);
        recordListEdit.setAdapter(adapter);

    }
}