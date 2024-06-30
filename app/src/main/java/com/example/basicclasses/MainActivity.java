package com.example.basicclasses;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int value = 0;
    private Button btnAdd;
    private Button btnTake;
    private TextView txtValue;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnGrow = findViewById(R.id.btnGrow);
        btnHide = findViewById(R.id.btnHide);
        btnReset = findViewById(R.id.btnReset);
        btnTake = findViewById(R.id.btnTake);
        btnShrink = findViewById(R.id.btnShrink);
        txtValue = findViewById(R.id.txtValue);

        btnShrink.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        txtValue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float size;

        if (view.getId() == R.id.btnAdd) {
            value++;
        txtValue.setText("" + value);
        } else if (view.getId() == R.id.btnTake) {
            value--;
            txtValue.setText("" + value);
        } else if (view.getId() == R.id.btnReset) {
            value = 0;
            txtValue.setText("" + value);
        } else if (view.getId() == R.id.btnGrow) {
            size = txtValue.getTextScaleX();
            txtValue.setTextScaleX(size + 1);
        } else if (view.getId() == R.id.btnShrink) {
            size = txtValue.getTextScaleX();
            txtValue.setTextScaleX(size - 1);
        }else if (view.getId() == R.id.btnHide) {
            if (txtValue.getVisibility() == View.VISIBLE) {
                txtValue.setVisibility(View.INVISIBLE);
                btnHide.setText("Show");
            } else {
                txtValue.setVisibility(View.VISIBLE);
                btnHide.setText("Hide");
            }
        }
    }
}