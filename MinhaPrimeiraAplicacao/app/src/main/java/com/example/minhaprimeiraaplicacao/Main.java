package com.example.minhaprimeiraaplicacao;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Main extends AppCompatActivity {
    TextView txMin, txMax, txSorteio;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        txMin = findViewById(R.id.txMin);
        txMax = findViewById(R.id.txMax);
        txSorteio = findViewById(R.id.txSorteio);
    }

    public void SortearNumero (View view) {
        int max = Integer.parseInt(txMax.getText().toString());
        int min = Integer.parseInt(txMin.getText().toString());
        txSorteio.setText(String.valueOf((int) Math.floor(Math.random() * (max - min + 1) + min)));
    }
}
