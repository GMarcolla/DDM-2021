package com.example.listasensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityExibirSensor extends AppCompatActivity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor mSensor;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_sensor);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(getIntent().getExtras().getInt("Type"));

        mSensorManager.registerListener(this, mSensor, mSensorManager.SENSOR_DELAY_FASTEST);

        mListView = findViewById(R.id.listDados);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        ArrayList<String> listValuesSensor = new ArrayList<>();
        
        for (float v : event.values) {
            listValuesSensor.add(Float.toString(v));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listValuesSensor
        );

        mListView.setAdapter(arrayAdapter);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}