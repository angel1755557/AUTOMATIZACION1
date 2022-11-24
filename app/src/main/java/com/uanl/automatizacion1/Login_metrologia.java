package com.uanl.automatizacion1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_metrologia extends AppCompatActivity {
    EditText et_loginCorreo;
    EditText et_loginContraseña;
    Button btn_ingresarmet;
    Button Btn_registro_met;

    FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_metrologia);

        et_loginCorreo = findViewById(R.id.et_loginCorreo);
        et_loginContraseña = findViewById(R.id.et_loginContraseña);
        btn_ingresarmet = findViewById(R.id.btn_ingresarmet);
        Btn_registro_met = findViewById(R.id.Btn_registro_met);

        mAuth = FirebaseAuth.getInstance();

        btn_ingresarmet.setOnClickListener(view -> loginUser());

        Btn_registro_met=(Button)findViewById(R.id.Btn_registro_met);
        Btn_registro_met.setOnClickListener(view -> {
            Intent btn_registrarme = new Intent(Login_metrologia.this,Registro.class);
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
                        Toast.makeText(Login_metrologia.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login_metrologia.this, CARRITO.class));
                    }else {
                        Toast.makeText(Login_metrologia.this, "Log error" + task.getException(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}


