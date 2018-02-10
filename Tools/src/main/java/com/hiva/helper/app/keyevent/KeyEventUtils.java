package com.hiva.helper.app.keyevent;

import android.app.Instrumentation;
import android.view.KeyEvent;

import com.hiva.helper.log.LogHelper;

/**
 * Created by HuangXiangXiang on 2018/1/11.
 * 主要用于模拟发送一个按键（如返回按钮）
 *
 */
public class KeyEventUtils {

    private static final String TAG = KeyEventUtils.class.getSimpleName() ;

    /**
     * 模拟按返回键
     * */
    public static void sendBackKeyCode(){
        LogHelper.i(TAG, LogHelper.__TAG__());

        sendKeyCode(KeyEvent.KEYCODE_BACK) ;
    }


    /**
     * 模拟按键
     *          可以在Activity发送使当前Activity生效;
     *          如果想在后台发送使其他界面生效就需要系统uid
     *
     * @param keyCode  keyCode 可以是{@link KeyEvent#KEYCODE_BACK}中的KeyCode
     * */
    public static void sendKeyCode(int keyCode){
        LogHelper.i(TAG, LogHelper.__TAG__());

        try {
            Instrumentation ins = new Instrumentation();
            ins.sendKeyDownUpSync(keyCode);
        } catch (Exception e) {

            LogHelper.e(TAG, LogHelper.__TAG__(), e);
        }
    }

}
