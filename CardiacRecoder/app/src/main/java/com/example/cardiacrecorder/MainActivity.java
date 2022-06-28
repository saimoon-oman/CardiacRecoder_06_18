package com.example.cardiacrecorder;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button measureButton, historyButton;
    private View measureUnderline, historyUnderline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        measureButton = findViewById(R.id.measureButton);
        historyButton = findViewById(R.id.historyButton);
        measureUnderline = findViewById(R.id.measureUnderline);
        historyUnderline = findViewById(R.id.historyUnderline);

        replaceFragment(new MeasureActivity());
        measureUnderline.setVisibility(View.VISIBLE);
        historyUnderline.setVisibility(View.INVISIBLE);

        measureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                measureUnderline.setVisibility(View.VISIBLE);
                historyUnderline.setVisibility(View.INVISIBLE);

                replaceFragment(new MeasureActivity());

            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                measureUnderline.setVisibility(View.INVISIBLE);
                historyUnderline.setVisibility(View.VISIBLE);

                replaceFragment(new HistoryActivity());

            }
        });

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateRecord.class);
                intent.putExtra("fromWhichActivity", "mainactivity");
                startActivity(intent);
            }
        });

    }

    private void replaceFragment(Fragment historyActivity) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, historyActivity);
        fragmentTransaction.commit();
    }
}