package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] dados = new String[] { "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich",
                                        "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "oreo", "pie"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dados
                );
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (dados[position]){
                    case "Cupcake":
                        Toast.makeText(getApplicationContext(), "Versão 1.5 Lançada em 2009", Toast.LENGTH_SHORT).show();
                        break;
                    case "Donut":
                        Toast.makeText(getApplicationContext(), "Versão 1.6 Lançada em 2009", Toast.LENGTH_LONG).show();
                        break;
                    case "Eclair":
                        Toast.makeText(getApplicationContext(), "Versão 2.1 Lançada em 2010", Toast.LENGTH_LONG).show();
                        break;
                    case "Froyo":
                        Toast.makeText(getApplicationContext(), "Versão 2.2 Lançada em 2010", Toast.LENGTH_LONG).show();
                        break;
                    case "Gingerbread":
                        Toast.makeText(getApplicationContext(), "Versão 2.3 Lançada em 2011", Toast.LENGTH_LONG).show();
                        break;
                    case "Honeycomb":
                        Toast.makeText(getApplicationContext(), "Versão 3.0 Lançada em 2011", Toast.LENGTH_LONG).show();
                        break;
                    case "Ice Cream Sandwich":
                        Toast.makeText(getApplicationContext(), "Versão 4.0 Lançada em 2011", Toast.LENGTH_LONG).show();
                        break;
                    case "Jelly Bean":
                        Toast.makeText(getApplicationContext(), "Versão 4.1 Lançada em 2012", Toast.LENGTH_LONG).show();
                        break;
                    case "KitKat":
                        Toast.makeText(getApplicationContext(), "Versão 4.4 Lançada em 2013", Toast.LENGTH_LONG).show();
                        break;
                    case "Lollipop":
                        Toast.makeText(getApplicationContext(), "Versão 5.0 Lançada em 2014", Toast.LENGTH_LONG).show();
                        break;
                    case "Marshmallow":
                        Toast.makeText(getApplicationContext(), "Versão 6.0 Lançada em 2015", Toast.LENGTH_LONG).show();
                        break;
                    case "Nougat":
                        Toast.makeText(getApplicationContext(), "Versão 7.0 Lançada em 2016", Toast.LENGTH_LONG).show();
                        break;
                    case "oreo":
                        Toast.makeText(getApplicationContext(), "Versão 8.0 Lançada em 2017", Toast.LENGTH_LONG).show();
                        break;
                    case "pie":
                        Toast.makeText(getApplicationContext(), "Versão 9.0 Lançada em 2018", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}