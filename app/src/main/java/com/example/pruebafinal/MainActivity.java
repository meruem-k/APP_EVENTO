package com.example.pruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilUser, tilPassword;
    private Button btnLogin, btnRegister, btnOlvide;
    private TextView setError;
    String user, password, pregunta, respuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referencias();
        eventos();
    }
    private void grabarUsuario(){



    }

//REFERENCIAS

    private void referencias(){
        tilUser = findViewById(R.id.tilUser);
        tilPassword = findViewById(R.id.tilPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnOlvide = findViewById(R.id.btnOlvide);
        setError = findViewById(R.id.setError);
    }
    private void pantallaregistrar() {
        Intent pantallaregistrar = new Intent(this, MainActivity2.class);
        user = tilUser.getEditText().getText().toString();
        pantallaregistrar.putExtra("nombreUsuario",user);
        startActivity(pantallaregistrar);
    }
    private void login() {
        user = tilUser.getEditText().getText().toString();
        password = tilPassword.getEditText().getText().toString();

        try {
            AdministradorBD adbd = new AdministradorBD(this, "BDAplicacion", null, 1);
            SQLiteDatabase miBD = adbd.getWritableDatabase();

            Cursor c = miBD.rawQuery("Select * from usuarios ", null);
            if (c.moveToFirst()) {
                Log.d("TAG_", "Registros recuperados " + c.getCount());
                do {
                    if
                    (user.isEmpty() || password.isEmpty()){
                        setError.setText("Rellene todos los campos!");
                        setError.setTextColor(Color.parseColor("#FF0000"));
                    }
                    else if (user.equals(c.getString(0))  && password.equals(c.getString(1))){
                        Toast.makeText(this, "Ingreso correcto!!", Toast.LENGTH_SHORT).show();
                        miBD.close();
                        Intent pantallaregistrar = new Intent(this, MainActivity3.class);
                        startActivity(pantallaregistrar);
                    }
                    else if
                    (!user.equals(c.getString(0)) || !password.equals(c.getString(1))){
                        setError.setText("Usuario o contraseña incorrecto!");
                        setError.setTextColor(Color.parseColor("#FF0000"));
                    }
                }while (c.moveToNext());
            }
        } catch (Exception ex) {
            Log.e("TAG_", ex.toString());
        }
    }



    private void eventos(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pantallaregistrar();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG_","boton LOGIN");
                login();
            }
        });
        btnOlvide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG_","boton olvidé");
            }
        });
    }
}