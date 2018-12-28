package com.yongyida.robot.hivahelper.floatbutton;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.yongyida.robot.utils.LogHelper;

/**
 * Created by HuangXiangXiang on 2018/2/3.
 */
public class FloatButtonService extends Service {

    private static final String TAG = FloatButtonService.class.getSimpleName() ;

    private ViewManager mViewManager ;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ListenerBinder();
    }

    public class ListenerBinder extends Binder {

        public FloatButtonService getExpressionService(){

            return FloatButtonService.this ;
        }
    }

    public void setData(String data){

        LogHelper.i(TAG, LogHelper.__TAG__() + ",data : " + data);

    }


    @Override
    public void onCreate() {
        super.onCreate();

//        mViewManager = ViewManager.getInstance(this.getApplicationContext()) ;
//        mViewManager.showFloatBall();
    }
}
