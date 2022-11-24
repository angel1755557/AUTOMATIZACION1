package com.uanl.automatizacion1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PracticasMetro extends AppCompatActivity {
    Button Btn_A1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practicas_metro);

        Btn_A1= findViewById(R.id.Btn_M1);

        Btn_A1.setOnClickListener(v -> {
            Intent Btn_A1 = new Intent(PracticasMetro.this, practica_auto_1.class);
            startActivity(Btn_A1);
        });
    }
}