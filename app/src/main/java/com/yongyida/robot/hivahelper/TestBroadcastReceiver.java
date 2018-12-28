package com.yongyida.robot.hivahelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.hiva.helper.log.LogHelper;

/**
 * Created by HuangXiangXiang on 2018/2/1.
 */
public class TestBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = TestBroadcastReceiver.class.getSimpleName() ;

    public static final String MOTOR_CALL_BACK_DATA = "com.yongyida.robot.motor.callBackData";
    public static final String ACTION_TEST = "test";
    public static final String KEY_WORD = "word";

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        LogHelper.i(TAG, LogHelper.__TAG__() + " action : " + action);

        if (MOTOR_CALL_BACK_DATA.equals(action)) {

            int cmdType = intent.getIntExtra("cmdType", -1);
            byte[] data = intent.getByteArrayExtra("data");

            String log = " cmdType : " + cmdType + " data : " + toHexString(data, data.length) ;
//            Toast.makeText(context,log ,Toast.LENGTH_SHORT ).show();
            showToast(context, log);
            LogHelper.i(TAG, LogHelper.__TAG__() + log);

        } else if (ACTION_TEST.equals(action)) {

            String word = intent.getStringExtra(KEY_WORD);
            LogHelper.i(TAG, LogHelper.__TAG__() + ", word : " + word);

            // 然后再按讯飞语点的逻辑走流程
            Intent service = new Intent("com.iflytek.xiri2.START");
            // 讯飞语点包名
            service.setPackage("com.iflytek.xiri");
            service.putExtra("text", word);
            service.putExtra("startmode", "text");
//            service.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(service);

//            boolean isResult = TelephonePresenter.getInstance(context).parseText(word) ;
//            if(isResult){
//
//                return ;
//            }
//
//            isResult = ControlPresenter.getInstance(context).parseText(word) ;
//            if(isResult){
//
//                return ;
//            }



        }else if("TouchSensor".equals(action)){

            String key = intent.getStringExtra("android.intent.extra.Touch") ;
            LogHelper.i(TAG, LogHelper.__TAG__() + ", key : " + key);

            Toast.makeText(context, "key : " + key, Toast.LENGTH_SHORT).show();

        }

    }


    private static Toast mToast ;
    private void showToast(Context context ,String text){

        if(mToast == null){

            mToast = Toast.makeText(context, text, Toast.LENGTH_LONG) ;
        }else {

            mToast.setText(text);
        }

        mToast.show();
    }




    /**
     * 将byte数字转变成String格式
     * */
    public static String toHexString(byte[] data , int length){

        if(data == null){

            return null ;
        }

        int len = data.length ;
        if(len == 0 || length <= 0){

            return "" ;
        }

        if(length > len){

            length = len ;
        }

        String format = "0x%02X" ;
        StringBuilder sb = new StringBuilder() ;
        for (int i= 0 ; i < length-1 ; i++){

            sb.append(String.format(format, data[i]) + " ") ;
        }

        sb.append(String.format(format, data[length - 1])) ;

        return sb.toString() ;
    }
}
