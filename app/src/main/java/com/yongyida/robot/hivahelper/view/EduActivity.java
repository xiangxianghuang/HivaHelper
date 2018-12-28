package com.yongyida.robot.hivahelper.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yongyida.robot.hivahelper.R;

/**
 * Create By HuangXiangXiang 2018/8/31
 */
public class EduActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu);

        int total = 217193650 ;
        int n1 = 500 ;
        int n2 = total/n1 ;


        long start = System.currentTimeMillis() ;
        int result2 = 0 ;
        for(int i = 0 ; i < n1; i++){

            for (int j = 0; j < n2; j++) {

                result2 ++ ;
            }

        }
        long end = System.currentTimeMillis() ;

        System.out.println("1、result2 : " +result2);
        System.out.println("1.耗时：" + (end - start));

        start = System.currentTimeMillis() ;
        result2 = 0 ;
        for(int i = 0 ; i < total; i++){

            result2 ++ ;

        }
        end = System.currentTimeMillis() ;

        System.out.println("2、 result2 : " +result2);
        System.out.println("2.耗时：" + (end - start));

    }
    private void startApp(){

//        Intent intent = new Intent() ;
//        intent.setClassName("com.yongyida.yydrobot.forbidden","com.yongyida.yydrobot.forbidden.activity.LauncherActivity");
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;
//        mContext.startActivity(intent);

        Intent intent = new Intent();
        intent.setAction("android.intent.action.playvideo");
        intent.setPackage("com.yongyida.yydrobot.forbidden");
        startService(intent);
    }

    private void stopApp(){

//        Intent intent = new Intent(mContext,WorkActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        mContext.startActivity(intent);

        Intent intent = new Intent();
        intent.setAction("android.intent.action.quickWJWPApp");
        intent.setPackage("com.yongyida.yydrobot.forbidden");
        startService(intent);
    }

    // 小
    public void openOne(View view) {

        startApp() ;

//        Uri uri = Uri.parse("wyt_iexuetang_preinstall_invocation://second_classification_invocation?module=module_xx_wkt");
//        Intent intent = new Intent(Intent.ACTION_VIEW) ;
//        intent.setData(uri) ;
//        startActivity(intent);


//        ComponentName localComponentName = new ComponentName(//机场版本的拍照（有美颜等功能）
//                "com.yongyida.robot.funcamera",
//                "com.yongyida.robot.funcamera.mainActivity");
//        Intent localIntent = new Intent();
//        localIntent.setComponent(localComponentName);
//        localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(localIntent);


//        Intent intent = new Intent();
//            intent.setClassName("com.yongyida.robot.funcamera", "com.yongyida.robot.funcamera.mainActivity" ) ;
////        intent.setPackage("com.yongyida.yydrobotcv");
////        intent.setAction("com.yongyida.yydrobotcv.TRACK_LAUNCHER") ;
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }

    // 初
    public void openTwo(View view) {

        stopApp() ;

//        Uri uri = Uri.parse("wyt_iexuetang_preinstall_invocation://second_classification_invocation?module=module_cz_wkt");
//        Intent intent = new Intent(Intent.ACTION_VIEW) ;
//        intent.setData(uri) ;
//        startActivity(intent);
    }

    // 高
    public void openThree(View view) {

        Uri uri = Uri.parse("wyt_iexuetang_preinstall_invocation://second_classification_invocation?module=module_gz_wkt");
        Intent intent = new Intent(Intent.ACTION_VIEW) ;
        intent.setData(uri) ;
        startActivity(intent);
    }
}
