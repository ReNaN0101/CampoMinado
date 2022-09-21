package com.example.campominado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class tela3 extends AppCompatActivity {
    TextView tv01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        tv01 = findViewById(R.id.tv01);
        int i ;
        i = getIntent().getIntExtra("tentativas",0);
        tv01.setText(Integer.toString(i));

    }
}