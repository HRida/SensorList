package com.example.hrida.sensorlist;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv1 = null;
    private SensorManager mSensorManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.textView2);
        tv1.setVisibility(View.GONE);

        mSensorManger = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mList = mSensorManger.getSensorList(Sensor.TYPE_ALL);

        for(int i = 1; i < mList.size(); i++) {
            tv1.setVisibility(View.VISIBLE);
            tv1.append("\n" + mList.get(i).getName() + "\n" + mList.get(i).getVendor() + "\n" + mList.get(i).getVersion());
        }
    }
}
