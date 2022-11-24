package com.uanl.automatizacion1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_automatización;
    Button btn_metrología;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_metrología = (Button)findViewById(R.id.btn_metrología);

        btn_metrología.setOnClickListener(v -> {
            Intent btn_metrología = new Intent(MainActivity.this, Login_metrologia.class);
            startActivity(btn_metrología);


        });


        btn_automatización=(Button)findViewById(R.id.btn_automatización);

        btn_automatización.setOnClickListener(v -> {
            Intent btn_automatización = new Intent(MainActivity.this, Login_automatizacion.class);
            startActivity(btn_automatización);


        });

    }


    }
