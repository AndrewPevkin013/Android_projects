package com.example.widgetexploration;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.Button);
        final TextClock tClock = findViewById(R.id.textClock);
        final CheckBox cbTransparency = findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint = findViewById(R.id.checkBoxTint);
        final CheckBox cbReSize = findViewById(R.id.checkBoxResize);
        final ImageView imageView = findViewById(R.id.imageView);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        final TextView textView = findViewById(R.id.textView);

        textView.setVisibility(View.INVISIBLE);

        cbTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (cbTransparency.isChecked()) {
                    imageView.setAlpha(.1f);
                } else {
                    imageView.setAlpha(1f);
                }
            }
        });

        cbTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbTint.isChecked()) {
                    imageView.setColorFilter(Color.argb(150, 200, 0, 0));
                } else {
                    imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                }
            }
        });

        cbReSize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbReSize.isChecked()) {
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                } else {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);

                if (rb.getId() == R.id.radioButtonLondon) {
                    tClock.setTimeZone("Europe/London");
                } else if (rb.getId() == R.id.radioButtonBeijing) {
                    tClock.setTimeZone("Etc/GMT-8");
                } else if (rb.getId() == R.id.radioButtonNewYork) {
                    tClock.setTimeZone("America/New_York");
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText());
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setVisibility(View.INVISIBLE);
                }
            }
        });

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("https://jut.su/hajime-no-ippo/season-1/episode-29.html");
    }
}