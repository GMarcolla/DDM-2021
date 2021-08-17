package com.example.exemplosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase Banco;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Banco = openOrCreateDatabase("banco", getBaseContext().MODE_PRIVATE, null);
        Banco.execSQL("CREATE TABLE IF NOT EXISTS alunos (_id INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT )");
    }

    public void insereAluno(){

    }

    public void showAlunos(){

    }
}
