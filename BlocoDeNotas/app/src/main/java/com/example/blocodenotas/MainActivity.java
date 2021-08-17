package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.blocodenotas.controller.NotaController;
import com.example.blocodenotas.modelo.Nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Nota> listNotas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                exibirNota(position);
            }
        });

       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               excluirNota(position);
               return true;
           }
       });


    }

    public void novaNota(View v)
    {
        Intent intent = new Intent(this, ActivityExibirNota.class);
        intent.putExtra("id_nota", 0);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showNotas();
    }

    private void showNotas(){
        NotaController notaController = new NotaController(this);

        listNotas = notaController.listaNotas();
        ArrayList<String> listTitulos = notaController.listaTitulosNotas();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listTitulos);

        listView.setAdapter(adapter);
    }

    public void exibirNota(int p){
        Nota n = listNotas.get(p);

        Intent intent = new Intent(this, ActivityExibirNota.class);
        intent.putExtra("id_nota", n.getId());
        startActivity(intent);
    }

    public void excluirNota(int p){
        Nota n = listNotas.get(p);
        NotaController notaController = new NotaController(this);
        notaController.excluirNota(n);
        this.showNotas();
        Toast.makeText(this, "Nota excluída", Toast.LENGTH_LONG).show();
    }

}