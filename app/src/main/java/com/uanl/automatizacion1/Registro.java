package com.uanl.automatizacion1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Registro extends AppCompatActivity {

    EditText et_correo_registro;
    EditText et_contraseña_registro;
    TextView tv_login;
    Button btn_registrar;

    FirebaseAuth mAuth;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_correo_registro = findViewById(R.id.et_correo_registro);
        et_contraseña_registro = findViewById(R.id.et_contraseña_registro);
        tv_login =  findViewById(R.id.tv_login);
        btn_registrar =  findViewById(R.id.btn_registrar);



        mAuth = FirebaseAuth.getInstance();
        btn_registrar.setOnClickListener(view  -> createUser());

        tv_login.setOnClickListener(view  -> startActivity(new Intent(Registro.this, Login_automatizacion.class)));

    }

    private void createUser(){
        String correo = Objects.requireNonNull(et_correo_registro.getText()).toString();
        String contraseña = Objects.requireNonNull(et_contraseña_registro.getText()).toString();

        if (TextUtils.isEmpty(correo)) {
            et_correo_registro.setError("email cannot be empty");
            et_correo_registro.requestFocus();
        }else if (TextUtils.isEmpty(contraseña)){
            et_contraseña_registro.setError("password cannot be empty");
            et_contraseña_registro.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(Registro.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registro.this, Login_automatizacion.class));
                }else{
                    Toast.makeText(Registro.this, "Registration error" + task.getException(), Toast.LENGTH_SHORT).show();
                }

            });

        }
    }
}