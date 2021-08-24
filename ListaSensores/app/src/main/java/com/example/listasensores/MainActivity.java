package com.example.listasensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    SensorManager mSensorManager;
    List<Sensor> listSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        listSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        ArrayList<String> listNameSensors = new ArrayList<>();

        for (Sensor s : listSensors) {
            listNameSensors.add(s.getName());
        }

        mListView = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listNameSensors
        );

        mListView.setAdapter(arrayAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                determinarSensor(position);
            }
        });
    }

    private void determinarSensor(int p){
        Intent intent;
        switch (listSensors.get(p).getType()){
            case Sensor.TYPE_LIGHT:
                intent = new Intent(this, ActivitySensorLuminosidade.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(this, ActivityExibirSensor.class);
                intent.putExtra("Type", listSensors.get(p).getType());
                startActivity(intent);
                break;
        }
    }
}