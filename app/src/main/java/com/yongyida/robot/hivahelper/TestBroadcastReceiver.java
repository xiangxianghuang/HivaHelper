package com.yongyida.robot.hivahelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.hiva.helper.log.LogHelper;

/**
 * Created by HuangXiangXiang on 2018/2/1.
 */
public class TestBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = TestBroadcastReceiver.class.getSimpleName() ;

    @Override
    public void onReceive(Context context, Intent intent) {

        LogHelper.i(TAG, LogHelper.__TAG__() + " action : " + intent.getAction() );

        try {
            Thread.sleep(100 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LogHelper.i(TAG, LogHelper.__TAG__() + " action : " + intent.getAction() );
    }
}
