package com.example.exploringlayouts;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
    }

    public void loadConstraintLayout(View v) {
        setContentView(R.layout.activity_main);
    }

    public void LoadMenuLayout(View v) {
        setContentView(R.layout.main_menu);
    }

    public void loadTableLayout(View v) {
        setContentView(R.layout.my_table_layout);
    }
}