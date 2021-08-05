package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IMC extends AppCompatActivity {
    private TextView txNome, txAltura, txPeso, txIMC;
    private ImageView imgView;
    private double peso, altura;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        txNome = findViewById(R.id.textNome);
        txAltura = findViewById(R.id.textAltura);
        txPeso = findViewById(R.id.textPeso);
        txIMC = findViewById(R.id.textIMC);
        imgView = findViewById(R.id.imageView);

        preencherTexts();
    }

    private void preencherTexts(){
        Bundle bundle = getIntent().getExtras();
        peso = Double.parseDouble(bundle.getString("peso"));
        altura = Double.parseDouble(bundle.getString("altura"));

        txNome.setText(bundle.getString("nome"));
        txPeso.setText(bundle.getString("peso") + " Kg");
        txAltura.setText(bundle.getString("altura") + " m");

        DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");

        txIMC.setText("IMC " + decimalFormat.format(calcularIMC()).toString());
        alterarImg();
    }

    private double calcularIMC(){
        return peso / (altura * altura);
    }

    private void alterarImg(){
        double imc = calcularIMC();

        if(imc < 18.5)
            imgView.setImageResource(R.drawable.imc02);
        else if (imc >= 18.5 && imc < 25)
            imgView.setImageResource(R.drawable.imc03);
        else if (imc >= 25 && imc < 30)
            imgView.setImageResource(R.drawable.imc04);
        else
            imgView.setImageResource(R.drawable.imc05);
    }
}