package com.example.listasensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySensorLuminosidade extends AppCompatActivity implements SensorEventListener {
    SensorManager mSensorManager;
    Sensor mSensor;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_luminosidade);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        mSensorManager.registerListener(this, mSensor, mSensorManager.SENSOR_DELAY_FASTEST);
        mTextView = findViewById(R.id.textView);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float values = event.values[0];

        if (values > 0) {
            mTextView.setText("Luz acesa (Valor: " + Float.toString(values) + ")");
        }else{
            mTextView.setText("Luz apagada (Valor: " + Float.toString(values) + ")");
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}