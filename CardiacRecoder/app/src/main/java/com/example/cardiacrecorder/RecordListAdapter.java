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
import java.util.List;

public class RecordListAdapter extends ArrayAdapter<Record> {

    private Context mContext;
    int mResource;

    public RecordListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Record> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String systolic = getItem(position).getSystolicPressure();
        String diastolic = getItem(position).getDiastolicPressure();
        String pulse = getItem(position).getPulse();
        String date = getItem(position).getDate();
        String time = getItem(position).getTime();
        String comment = getItem(position).getComment();
        int level = getItem(position).getLevel();

        Record record = new Record(systolic, diastolic, pulse, date, time, comment, level);


        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.row_data_layout, parent, false);

        TextView tvSystolic = convertView.findViewById(R.id.systolicId);
        TextView tvDiastolic = convertView.findViewById(R.id.diastolicId);
        TextView tvPulse = convertView.findViewById(R.id.pulseId);
        TextView tvDate = convertView.findViewById(R.id.dateId);
        TextView tvTime = convertView.findViewById(R.id.timeId);
        TextView tvComment = convertView.findViewById(R.id.commentId);
        TextView tvLevel = convertView.findViewById(R.id.levelId);
        View tvLevelBackground = convertView.findViewById(R.id.levelBackgroundId);

        tvSystolic.setText(systolic);
        tvDiastolic.setText(diastolic);
        tvPulse.setText(pulse);
        tvDate.setText(date);
        tvTime.setText(time);
        tvComment.setText(comment);

        return convertView;

    }
}
