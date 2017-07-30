package com.example.jcastako.actividad_4;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    TextView salida;
    TextView sensorDisp;
    SensorManager senM;
    Sensor temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salida = (TextView) findViewById(R.id.resultado);
        sensorDisp =(TextView) findViewById(R.id.sensor_A);
        senM = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        temp = senM.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (temp!=null){
            sensorDisp.setText("Sensor: Abient_temperature disponible");

        }else{
            sensorDisp.setText("Sensor no disponible");
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            salida.setText("Temperatura ambiente: " + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
