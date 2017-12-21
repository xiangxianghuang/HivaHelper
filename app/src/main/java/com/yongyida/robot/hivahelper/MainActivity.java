package com.yongyida.robot.hivahelper;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.hiva.helper.excel.ReadExcel;
import com.hiva.helper.log.LogHelper;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogHelper.i(LogHelper.TAG() ,LogHelper.__TAG__()) ;

        String path = new File(Environment.getExternalStorageDirectory(),"test.xls").getAbsolutePath();
        String name = "name3" ;

        ReadExcel.getItems(path,name) ;
    }
}
