package com.example.cardiacrecorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends Fragment {

    View view;
    ListView recordList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_history_activity, container, false);

        ListView recordList = view.findViewById(R.id.recordList);

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

        RecordListAdapter adapter = new RecordListAdapter(getContext(), R.id.rowLayout, recordArrayList);
        recordList.setAdapter(adapter);

        return view;
    }
}