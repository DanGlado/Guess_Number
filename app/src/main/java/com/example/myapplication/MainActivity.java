package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int num = 0;
    int lev = 1;
    int max = 100;
    int a = (int) ( Math.random() * max );

    @Override
    protected void onCreate (Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tvInfo = (TextView) findViewById(R.id.textView);
    etInput = (EditText) findViewById(R.id.editText);
    bControl = (Button) findViewById(R.id.button);
    bControl = (Button) findViewById(R.id.button2);
    bControl = (Button) findViewById(R.id.button3);
}
    public void onClick (View v){

    try {
        num = Integer.parseInt(etInput.getText().toString());
        if (num == a) {
            tvInfo.setText(getResources().getString(R.string.hit));
            a = (int) ( Math.random() * max );
        } else if ((num > max) || (num < 0)) {
            tvInfo.setText(getResources().getString(R.string.out));
        } else if (num > a) {
            tvInfo.setText(getResources().getString(R.string.ahead));
        } else if (num < a) {
            tvInfo.setText(getResources().getString(R.string.behind));
        }
    } catch (NumberFormatException e) {
        tvInfo.setText(getResources().getString(R.string.error));
    }
}
    public void onClick2 (View v) {
        System.exit(0);
    }
    public void level (View v){
        try {
            lev = Integer.parseInt(etInput.getText().toString());
            if (lev == 1) {
                tvInfo.setText(getResources().getString(R.string.level1));
                max = 100;
            } else if (lev == 2) {
                tvInfo.setText(getResources().getString(R.string.level2));
                max = 200;
            } else if (lev == 3) {
                tvInfo.setText(getResources().getString(R.string.level3));
                max = 500;
            }
        } catch (NumberFormatException e) {
            tvInfo.setText(getResources().getString(R.string.error));
        }
    }
}

