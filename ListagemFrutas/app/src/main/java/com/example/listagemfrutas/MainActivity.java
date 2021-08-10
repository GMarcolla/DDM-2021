package com.example.listagemfrutas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        FrutaController frutaController = new FrutaController();

        FrutaAdapter frutaAdapter = new FrutaAdapter(this, R.layout.layout_frutas, frutaController.FRUTAS);
        listView.setAdapter(frutaAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ExibeFrutas.class);

                intent.putExtra("id", position);

                startActivity(intent);
            }
        });
    }
}