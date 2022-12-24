package com.example.pruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private TextInputLayout tilUserR,tilPasswordR,tilRespuestaR;
    private Spinner spnPreguntaSecreta;
    private Button btnRegistrar,btnVolver;
    private ArrayList <registrarUsuario> Registro; //cliente - los clientes;
    private String [] arraySpn;
    private ArrayAdapter<String> adaptadorSpn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        referencias();
        eventos();
        poblar();
    }

    private void grabarUsuario(){
        String user, password,pregunta,respuesta;
        user = tilUserR.getEditText().getText().toString();
        password = tilPasswordR.getEditText().getText().toString();
        pregunta = spnPreguntaSecreta.getSelectedItem().toString();
        respuesta = tilRespuestaR.getEditText().getText().toString();

        registrarUsuario register = new registrarUsuario(user,password,pregunta,respuesta);

        registrarEnBD(register);
        Toast.makeText(this,"registro exitoso",Toast.LENGTH_SHORT).show();
    }

    public void registrarEnBD(registrarUsuario register){


        try  {
            AdministradorBD adbd = new AdministradorBD(this, "BDAplicacion", null,1);
            SQLiteDatabase miBD = adbd.getWritableDatabase();

            ContentValues reg = new ContentValues();
            reg.put("usuario",register.getUser());
            reg.put("password",register.getPassword());
            reg.put("pregunta",register.getPregunta());
            reg.put("respuesta",register.getRespuesta());
            miBD.insert("usuarios",null,reg);



            miBD.close();
        }catch (Exception ex){
            Log.e("TAG_", ex.toString());
        }
    }


    //region Referencias y eventos

    private void eventos(){
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG_","boton registrar");
                Log.d("TAG_","" + spnPreguntaSecreta.getSelectedItem());
                grabarUsuario();
                finish();

            }
        });
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void referencias (){
        tilUserR = findViewById(R.id.tilUserR);
        tilPasswordR = findViewById(R.id.tilPasswordR);
        spnPreguntaSecreta = findViewById(R.id.spnPreguntaSecreta);
        tilRespuestaR = findViewById(R.id.tilRespuestaR);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVolver = findViewById(R.id.btnVolverLogIn);
        arraySpn = new String [6];
    }
    //endregion
    private void poblar(){
        arraySpn [0] = "Seleccione pregunta secreta";
        arraySpn [1] = "¿Cuál es tu comida favorita?";
        arraySpn [2] = "¿Cuál es el nombre de su primer profesor?";
        arraySpn [3] = "¿Cuál es el segundo nombre de tu padre?";
        arraySpn [4] = "¿Cuál es tu ciudad natal?";
        arraySpn [5] = "¿Cuál es el nombre de tu mascota?";
        adaptadorSpn = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySpn);
        spnPreguntaSecreta.setAdapter(adaptadorSpn);
    }
}