package com.example.pruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity4 extends AppCompatActivity {
    private TextView tvRecuperar,tvDescripcion;
    private TextInputLayout tilUsuario,tilRespuesta;
    private Spinner spnPregunta;
    private Button btnRecuperar,btnVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        referencias();
    }

    private void referencias(){
        tvRecuperar = findViewById(R.id.tvNuevaPass);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tilUsuario = findViewById(R.id.tilNewPass);
        tilRespuesta = findViewById(R.id.tilRespuesta);
        spnPregunta = findViewById(R.id.spnPregunta);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        btnVolver = findViewById(R.id.btnVolver);
    }
}