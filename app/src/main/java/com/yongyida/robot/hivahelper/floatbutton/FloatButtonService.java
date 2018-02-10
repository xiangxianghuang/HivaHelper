package com.yongyida.robot.hivahelper.floatbutton;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by HuangXiangXiang on 2018/2/3.
 */
public class FloatButtonService extends Service {

    private ViewManager mViewManager ;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mViewManager = ViewManager.getInstance(this.getApplicationContext()) ;
        mViewManager.showFloatBall();
    }
}
