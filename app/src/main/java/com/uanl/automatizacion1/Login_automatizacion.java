package com.uanl.automatizacion1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_automatizacion extends AppCompatActivity {


    EditText et_loginCorreo;
    EditText et_loginContraseña;
    Button btn_ingresarauto;
    Button btn_registrarme;

    FirebaseAuth mAuth;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginauto);

        et_loginCorreo = findViewById(R.id.et_loginCorreo);
        et_loginContraseña = findViewById(R.id.et_loginContraseña);
        btn_ingresarauto = findViewById(R.id.btn_ingresarauto);
        btn_registrarme = findViewById(R.id.btn_registrarme);

        mAuth = FirebaseAuth.getInstance();

        btn_ingresarauto.setOnClickListener(view -> {
            loginUser();
        });

        btn_registrarme=(Button)findViewById(R.id.btn_registrarme);
        btn_registrarme.setOnClickListener(view -> {
            Intent btn_registrarme = new Intent(Login_automatizacion.this,Registro.class);
            startActivity((btn_registrarme));
        });



    }

    private void loginUser(){
        String correo = et_loginCorreo.getText().toString();
        String contraseña = et_loginContraseña.getText().toString();

        if (TextUtils.isEmpty(correo)) {
            et_loginCorreo.setError("email cannot be empty");
            et_loginCorreo.requestFocus();
        }else if (TextUtils.isEmpty(contraseña)){
            et_loginContraseña.setError("password cannot be empty");
            et_loginContraseña.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Login_automatizacion.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login_automatizacion.this, PracticasMetro.class));
                    }else {
                        Toast.makeText(Login_automatizacion.this, "Log error" + task.getException(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}