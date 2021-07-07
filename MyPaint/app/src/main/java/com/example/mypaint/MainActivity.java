package com.example.mypaint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private PaintView paintView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = findViewById(R.id.paintView);
    }

    public void alterarRed (View view) {
        paintView.alterarCor(Color.RED);
    }

    public void alterarBlue (View view) {
        paintView.alterarCor(Color.BLUE);
    }

    public void alterarGreen (View view) {
        paintView.alterarCor(Color.GREEN);
    }

}