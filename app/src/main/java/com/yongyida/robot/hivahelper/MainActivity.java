package com.yongyida.robot.hivahelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hiva.helper.log.LogHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogHelper.i(LogHelper.TAG() ,LogHelper.__TAG__()) ;
    }
}
