package com.example.notetoself;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    private boolean mShowDividers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
        mEditor = mPrefs.edit();

        mShowDividers = mPrefs.getBoolean("dividers", true);

        Switch switch1 = findViewById(R.id.switch1);
        switch1.setChecked(mShowDividers);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mEditor.putBoolean("dividers", true);
                    mShowDividers = true;
                }else{
                    mEditor.putBoolean("dividers", false);
                    mShowDividers = false;
                }
            }
        });
    }


    @Override
    protected void onPause () {
        super.onPause();
        mEditor.commit();
    }
}