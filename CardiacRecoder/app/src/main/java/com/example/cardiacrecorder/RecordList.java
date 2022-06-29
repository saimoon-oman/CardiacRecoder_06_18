package com.example.cardiacrecorder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordList extends ArrayAdapter<Record> {

    private ArrayList<Record> records;
    private Context context;

    public RecordList(Context context, ArrayList<Record> records) {
        super(context, 0, records);
        this.records = records;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.fragment_history_activity, parent, false);
        }

        Record record = records.get(position);

//        TextView cityName = view.findViewById(R.id.city_text);
//        TextView provinceName = view.findViewById(R.id.province_text);
//
//        cityName.setText(city.getCityName());
//        provinceName.setText(city.getProvinceName());

        return view;
    }

}
