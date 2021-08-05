package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editNome;
    private EditText editAltura;
    private EditText editPeso;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNome = findViewById(R.id.editNome);
        editAltura = findViewById(R.id.editAltura);
        editPeso = findViewById(R.id.editPeso);
    }

    public void enviarIMC(View v) {
        Intent i = new Intent(getApplicationContext(), IMC.class);
        i.putExtra("nome", editNome.getText().toString());
        i.putExtra("altura", editAltura.getText().toString());
        i.putExtra("peso", editPeso.getText().toString());
        startActivity(i);
    }
}