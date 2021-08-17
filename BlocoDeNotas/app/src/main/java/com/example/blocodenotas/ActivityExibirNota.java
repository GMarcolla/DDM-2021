package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blocodenotas.controller.NotaController;
import com.example.blocodenotas.modelo.Nota;

public class ActivityExibirNota extends AppCompatActivity {
    NotaController notaController;
    EditText edTitulo, edTexto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);
        notaController = new NotaController(this);
        this.edTitulo = findViewById(R.id.edTitulo);
        this.edTexto = findViewById(R.id.edNota);
        Bundle bundle = getIntent().getExtras();

        if (bundle.getInt("id_nota") != 0){
            NotaController notaController = new NotaController(this);
            Nota nota = notaController.getNota(bundle.getInt("id_nota"));

            this.edTitulo.setText(nota.getTitulo());
            this.edTexto.setText(nota.getTexto());
        }
    }

    public void salvarNota(View v){
        Bundle bundle = getIntent().getExtras();
        Nota n;

        if (bundle.getInt("id_nota") == 0){
            n = notaController.cadastrarNovaNota(new Nota(edTitulo.getText().toString(), edTexto.getText().toString()));
        }else{
            n = new Nota(bundle.getInt("id_nota"), edTitulo.getText().toString(), edTexto.getText().toString());
            notaController.atualizaNota(n);
        }

        Toast.makeText(this, "Nota salva", Toast.LENGTH_LONG).show();
    }
}