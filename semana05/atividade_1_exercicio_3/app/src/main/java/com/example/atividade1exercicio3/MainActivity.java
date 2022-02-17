package com.example.atividade1exercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private EditText displayX;
    private EditText displayY;
    private EditText displayZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        displayX = (EditText) findViewById(R.id.editTextX);
        displayY = (EditText) findViewById(R.id.editTextY);
        displayZ = (EditText) findViewById(R.id.editTextZ);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float sensorX = sensorEvent.values[0];
            float sensorY = sensorEvent.values[1];
            float sensorZ = sensorEvent.values[2];

            displayX.setText(String.valueOf(sensorX));
            displayY.setText(String.valueOf(sensorY));
            displayZ.setText(String.valueOf(sensorZ));

            // Se aceleracao no eixo X for maior que 5, passa para outra atividade
            if (Math.abs(sensorX) > 5) {
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}