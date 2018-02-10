package com.yongyida.robot.hivahelper;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hiva.helper.log.LogHelper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName() ;

    /**
     * Hello World!
     */
    private TextView mMessageTvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

//        setContentView(R.layout.volume_dialog);

//        mMessageTvw.setText(StorageUtils.getData());

        LogHelper.i(LogHelper.TAG(), LogHelper.__TAG__());

//        String path = new File(Environment.getExternalStorageDirectory(),"test.xls").getAbsolutePath();
//        String name = "name3" ;
//
//        ReadExcel.getItems(path,name) ;


//        String path = new File(Environment.getExternalStorageDirectory(),"/navigation/content.xls").getAbsolutePath();
//        ReadExcel.initExcelData(path) ;

//        NavigatePresenter navigatePresenter = new NavigatePresenter() ;
//        navigatePresenter.parseErrorNavigate("带我到算法组");


//        Intent intent = new Intent(this, FloatButtonService.class) ;
//        startService(intent) ;

    }

    private void initView() {
        mMessageTvw = (TextView) findViewById(R.id.message_tvw);
    }

    public void read(View view) {

//        mMessageTvw.setText(StorageUtils.getData());

//        createLoadingDialog(this,"null").show();


//        Intent intent = new Intent( );
//        intent.setClassName("com.yongyida.robot.education" ,"com.yongyida.robot.education.MainActivity") ;
////        intent.setClassName("com.yongyida.robot.education" ,"com.yongyida.robot.education.second.SecondActivity") ;
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra("type",3) ;
//
//        startActivity(intent);

    }

    /**
     * 打开格林教育
     * */
    public static void openGeLinPrimary(Context context){

        LogHelper.i(TAG ,LogHelper.__TAG__() );

//        Intent intent = new Intent();
//        intent.addCategory(Intent.CATEGORY_LAUNCHER);
//        intent.setClassName("com.wyt.xq.yongyida", "com.wyt.xq.yongyida.MainActivity");
//        intent.putExtra("type", "大海宝宝");
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;
//
//        try{
//            context.startActivity(intent);
//        }catch (Exception e){
//
//            LogHelper.e(TAG ,"openGeLinPrimary e : " + e.getMessage() );
//        }


        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName("com.wyt.xq.yongyida", "com.wyt.xq.yongyida.MainActivity");
        intent.setComponent(cn);
        intent.putExtra("type", "大海宝宝");
        context.startActivity(intent);

    }





    /**
     * 打开格林教育
     * */
    public static void openGeLinJunior(Context context){

        LogHelper.i(TAG ,LogHelper.__TAG__() );

        Intent intent = new Intent();
        intent.setClassName("com.wyt.yongyida_cz","com.wyt.yongyida_cz.CallActivity") ;
        intent.putExtra("type", "wyt.app[@]"+ "动物世界");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;
        try{
            context.startActivity(intent);
        }catch (Exception e){

            LogHelper.e(TAG ,"openGeLinJunior e : " + e.getMessage() );
        }


    }






    public static Dialog createLoadingDialog(Context context, String msg) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.encoding_dialog, null);// 得到加载view
        Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        loadingDialog.setContentView(v);

        return loadingDialog;

    }


    public void openGeLinPrimary(View view) {

        showDialog() ;

//        openGeLinPrimary(this) ;
//        getInt();

//        updateSetting() ;


//        long startTime = AppUtils.getBootMillTime() ;
////        Calendar calendar = Calendar.getInstance() ;
////        calendar.setTimeInMillis(startTime);
//
//        Date date = new Date(startTime) ;
//        mMessageTvw.setText("开机时间：" + date.toLocaleString());

//        Intent intent = new Intent("hiva");
//        sendBroadcast(intent);
//
//
//        LogHelper.e(TAG, LogHelper.__TAG__() ) ;

    }

    public void openGeLinJunior(View view) {


//        openGeLinJunior(this) ;
//        setInt();

//        updateFuckSetting("smartfall_switch") ;

//        long pastTime = AppUtils.getPastMillTime() / 1000 ;
//        mMessageTvw.setText("已经开机" + pastTime + "秒");

//        testWriteFile() ;

//        test() ;
    }



    public void getInt(){

        ContentResolver cr = getContentResolver() ;
//        String name = "location_switch" ;
        String name = "smartfall_switch" ;
        int value = -1 ;
        try {
            value = Settings.Global.getInt(cr , name) ;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            LogHelper.e(TAG, LogHelper.__TAG__() + ",e : " + e.getMessage());
        }

        LogHelper.i(TAG, LogHelper.__TAG__() + ",value : " + value);
    }

    int i = 0 ;
    public void setInt(){

        ContentResolver cr = getContentResolver() ;
//        String name = "location_switch" ;
        String name = "smartfall_switch" ;
        boolean result = Settings.Global.putInt(cr , name, i++) ;
//        boolean result = Settings.Global.putInt(cr , name, i++) ;

        LogHelper.i(TAG, LogHelper.__TAG__() + ",result : " + result);
    }


    public static final String SETTING_URI = "content://com.yongyida.robot.settingsprovider/query";

    public void updateSetting(){
        Cursor cursor = null;
        try {
            Uri uri = Uri.parse(SETTING_URI);
            ContentResolver resolver = getContentResolver();
            cursor = resolver.query(uri, null, null, null, null);
            if(null != cursor && cursor.moveToFirst()){
                // 1 打开智能防跌，0 关闭智能防跌
                int smartFallSwitch = cursor.getInt(cursor.getColumnIndex("smartfall_switch"));
                LogHelper.i(TAG, LogHelper.__TAG__() + ",smartFallSwitch : " + smartFallSwitch);

                // 1 打开声源定位，0 关闭声源定位
                int locationSwitch = cursor.getInt(cursor.getColumnIndex("location_switch"));
                LogHelper.i(TAG, LogHelper.__TAG__() + ",locationSwitch : " + locationSwitch);

                // 1 打开唤醒模式，0 关闭唤醒模式
                int awakenSwitch = cursor.getInt(cursor.getColumnIndex("awaken_switch"));
                LogHelper.i(TAG, LogHelper.__TAG__() + ",awakenSwitch : " + awakenSwitch);

                // 1 远场，0 近场
                int awakenModel = cursor.getInt(cursor.getColumnIndex("awaken_model"));
                LogHelper.i(TAG, LogHelper.__TAG__() + ",awakenModel : " + awakenModel);

                // 1 夜间模式打开，0 夜间模式关闭
                int resttimeSwitch = cursor.getInt(cursor.getColumnIndex("resttime_switch"));
                LogHelper.i(TAG, LogHelper.__TAG__() + ",resttimeSwitch : " + resttimeSwitch);

            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if(null != cursor){
                cursor.close();
            }
        }
    }


    public void updateFuckSetting(String selection){
        if(TextUtils.isEmpty(selection))
            return;

        LogHelper.e(TAG, LogHelper.__TAG__() + ",selection : " + selection);
        Cursor cursor = null;
        try {
            Uri uri = Uri.parse(SETTING_URI);
            ContentResolver resolver = getContentResolver();
            cursor = resolver.query(uri, null, selection, null, null);
            if(null != cursor && cursor.moveToFirst()){

                int value = cursor.getInt(cursor.getColumnIndex("cursor_value"));
                LogHelper.i(TAG, LogHelper.__TAG__() + ",value : " + value);
            }
        } catch (Throwable e) {
            e.printStackTrace();

            LogHelper.e(TAG, LogHelper.__TAG__() + ",e : " + e.getMessage());
        } finally {
            if(null != cursor){
                cursor.close();
            }
        }
    }


    private void testWriteFile(){

        while(true){

            byte [] data = new byte[20 * 1024 * 1024] ;

            File file = new File(Environment.getExternalStorageDirectory() , "text.txt") ;

            LogHelper.i(TAG, LogHelper.__TAG__());

            try {
                long start = System.currentTimeMillis() ;

                FileOutputStream outputStream = new FileOutputStream(file) ;
                outputStream.write(data);
                outputStream.flush();
                outputStream.close();
                long end = System.currentTimeMillis() ;


                LogHelper.i(TAG, LogHelper.__TAG__() + ", 写入速度：" + (20*1000/((end-start))) +"Mb/s");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    private void test(){

        startControl() ;
    }



    /**
     * 不断的发广播给悬浮按钮，让悬浮按钮保存运行
     * */
    public void startControl() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent("floatbutton.ACTION_SHOW_HIDE");
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                while (true) {
                    sendBroadcast(intent);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Log.i(TAG, "sendBroadcastToFloatButton-[Error] >> " + e.getMessage());
                    }
                }
            }
        }).start();
    }


    /**
     * 防止AR注册失败
     */
    public static synchronized void copyARFile() {

        try {
            Thread.sleep(100 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 备份
                File fromFile = new File("/sdcard/Android/data/com.fancyar.xiaoyongar/files/baikeInfo");
                File toFile = new File("/data/baikeInfo");
                copyFile_(fromFile, toFile, false);
                // 恢复
                File fromFile2 = new File("/data/com.fancyar.xiaoyongar/files/baikeInfo");
                File file = new File("/sdcard/Android/data/com.fancyar.xiaoyongar/files");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File toFile2 = new File("/sdcard/Android/data/com.fancyar.xiaoyongar/files/baikeInfo");
                copyFile_(fromFile2, toFile2, false);
            }
        }).start();
    }


    /**
     * 拷贝文件
     * @param fromFile 源文件路径
     * @param toFile   目的文件路径
     * @param append   true追加 false覆盖
     */
    public  static void copyFile_(File fromFile, File toFile, boolean append){
        if(!(null != fromFile && fromFile.exists())){
            return;
        }
        if((null != toFile && toFile.exists())){
            return;
        }
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            inBuff = new BufferedInputStream(new FileInputStream(fromFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(toFile, append));
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len = inBuff.read(bytes))!= -1) {
                outBuff.write(bytes, 0, len);
            }
            outBuff.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inBuff != null){
                    inBuff.close();
                }
                if(outBuff != null){
                    outBuff.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void finish() {

        LogHelper.i(TAG, LogHelper.__TAG__()) ;
//        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
        super.finish();
    }

    @Override
    public void onBackPressed() {

        LogHelper.i(TAG, LogHelper.__TAG__()) ;
        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
        super.onBackPressed();
    }



    private void showDialog(){

        Dialog dialog = new Dialog(this, R.style.Dialog_Fullscreen) ;
//        Dialog dialog = new Dialog(this) ;
        dialog.setContentView(R.layout.volume_dialog_0);
        ViewGroup viewGroup = dialog.findViewById(R.id.volume_dialog_content) ;

        View child = LayoutInflater.from(this).inflate(R.layout.volume_dialog, null) ;

//        final LinearLayout.LayoutParams lp =
//                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        viewGroup.addView(child, viewGroup.getChildCount() - 1);
//        viewGroup.addView(child);

        dialog.show();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){

            showDialog();
        }

        return super.onTouchEvent(event);
    }
}
