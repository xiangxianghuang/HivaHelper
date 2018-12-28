package com.yongyida.robot.hivahelper;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.android.systemui.volume.VolumeDialog2;
import com.hiva.helper.log.LogHelper;
import com.yongyida.robot.multimodal.Test;
import com.yongyida.robot.usb_uart.UART;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName() ;

    /**
     * Hello World!
     */
    private TextView mMessageTvw;


    private void checkPermission(Activity context){

        if ( ContextCompat.checkSelfPermission(context, Manifest.permission_group.LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(context,Manifest.permission_group.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(context,Manifest.permission_group.MICROPHONE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(context,Manifest.permission_group.STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.CAMERA,
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    }, 1);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        registerReceiver() ;
//        checkPermission(this) ;

//        setContentView(R.layout.volume_dialog2);

//        mMessageTvw.setText(StorageUtils.getData());

        LogHelper.i(TAG, LogHelper.__TAG__());

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

//        openAllLed() ;
//        closeAllLed() ;

//        setLedColor(0, 255, 255) ;

//        setLedColorBreath(2,0,255,0) ;
    }


    private void closeAllLed(){

        FileWriter out = null;
        try {
            out = new FileWriter("/dev/aw9523b");
            String s = "113" ;
            out.write(s);
            out.close();
            LogHelper.i(TAG, LogHelper.__TAG__());
        } catch (IOException e) {
            e.printStackTrace();
            LogHelper.i(TAG, LogHelper.__TAG__());
        }
    }


    private void openAllLed(){

        FileWriter out = null;
        try {
            out = new FileWriter("/dev/aw9523b");
            String s = "112" ;
            out.write(s);
            out.close();
            LogHelper.i(TAG, LogHelper.__TAG__());
        } catch (IOException e) {
            e.printStackTrace();
            LogHelper.i(TAG, LogHelper.__TAG__());
        }
    }


    private void setLedColor(int red, int green, int blue){

        FileOutputStream out = null;
        try {
            out = new FileOutputStream("/dev/aw9523b");
            String s = String.format("111%03d %03d %03d",red,green,blue);
            out.write(s.getBytes());
            out.close();
            LogHelper.i(TAG, LogHelper.__TAG__() + s);
        } catch (IOException e) {
            e.printStackTrace();
            LogHelper.i(TAG, LogHelper.__TAG__());
        }
    }




    private void setLedColorBreath(int time,int red, int green, int blue){

        FileOutputStream out = null;
        try {
            out = new FileOutputStream("/dev/aw9523b");
            String s = String.format("114%03d %03d %03d %03d",time,red,green,blue);
            out.write(s.getBytes());

            out.write(s.getBytes());
            out.close();
            LogHelper.i(TAG, LogHelper.__TAG__() + s);

        } catch (IOException e) {
            e.printStackTrace();
            LogHelper.i(TAG, LogHelper.__TAG__());
        }

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterReceiver();
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

        NavigatePresenter navigatePresenter = new NavigatePresenter() ;
        navigatePresenter.parseErrorNavigate("带我去阳台");




//        showDialog() ;

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
//
////        Dialog dialog = new Dialog(this) ;
//        Dialog dialog = new Dialog(getApplicationContext(), R.style.Dialog_Fullscreen) ;
//
//        dialog.setContentView(R.layout.volume_dialog);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
////
//        ViewGroup viewGroup = (ViewGroup) dialog.findViewById(R.id.volume_dialog_content);
//        View child = dialog.getLayoutInflater().inflate(R.layout.volume_dialog_row, null) ;
//
////        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1,-1 ) ;
////        viewGroup.addView(child, viewGroup.getChildCount() - 1,layoutParams);
//        viewGroup.addView(child, viewGroup.getChildCount() - 1);
//
//        dialog.show();

//        Dialog dialog = new Dialog(this, R.style.Dialog_Fullscreen) ;
////        Dialog dialog = new Dialog(this) ;
//
////        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT ,RelativeLayout.LayoutParams.MATCH_PARENT ) ;
//        dialog.setContentView(R.layout.volume_dialog2);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//        dialog.show();

//        volumeDialog2.show();



//        if(++volume > 16){
//
//            volume = 0 ;
//        }
//
//        volumeDialog2.showVolume(volume);


        showVolumeDialog2() ;
    }


    private VolumeDialog2 volumeDialog2;
    private void showVolumeDialog2(){

        if(volumeDialog2 == null){

            volumeDialog2 = new VolumeDialog2(this) ;

        }

        volumeDialog2.showVolume() ;
    }
    private void dismissVolumeDialog2(){

        if(volumeDialog2 != null){

            volumeDialog2.dismissVolume();
        }
    }

    int volume ;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){

            showDialog();
        }

        return super.onTouchEvent(event);
    }

    public void executeWord(View view) {

//        Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:112"));
//        startActivity(intent);

//        Intent intent = new Intent(Intent.ACTION_CALL);
//        Uri data = Uri.parse("tel:18658606472");
//        intent.setData(data);
//        startActivity(intent);

        if(mTest == null || !mTest.asBinder().isBinderAlive()){

            LogHelper.i(TAG, LogHelper.__TAG__());

            Intent intent = new Intent() ;
            intent.setPackage("com.yongyida.robot.multimodal") ;
            intent.setAction("test") ;

            bindService(intent, connection ,Context.BIND_AUTO_CREATE) ;

        }else{

            IBinder binder = mTest.asBinder() ;
            LogHelper.i(TAG, LogHelper.__TAG__() + " pingBinder : " + binder.pingBinder() + " isBinderAlive : " + binder.isBinderAlive());

            try {
                mTest.send("index->" + (index++));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private int index = 0 ;

    private Test mTest ;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogHelper.i(TAG, LogHelper.__TAG__());
            mTest = Test.Stub.asInterface(service) ;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            LogHelper.i(TAG, LogHelper.__TAG__());
        }
    };

    /**打开USB*/
    public void openUsb(View view) {

//        UART.getInstance(this).openDevice(new UART.OpenDeviceListener() {
//            @Override
//            public void onOpenDevice(boolean isOpen) {
//
//                LogHelper.i(TAG, LogHelper.__TAG__() + " isOpen : " + isOpen );
//            }
//        });

//        try{
//
//            callPhone("110") ;
//
//        }catch (Exception e){
//
//            LogHelper.e(TAG, LogHelper.__TAG__() + " Exception : " + e );
//        }


        try {
            closeRobot() ;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * 拨打电话（直接拨打电话）
     *
     * @param phoneNum 电话号码（如果电话号码是短号会回调到拨打界面，如：112）
     */
    private void callPhone(String phoneNum) {
        LogHelper.i(TAG, LogHelper.__TAG__()) ;

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;

        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }


    private void registerReceiver(){

        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED) ;
        registerReceiver(receiver,filter) ;

    }


    private void unRegisterReceiver(){

        unregisterReceiver(receiver);
    }


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())){

                // 当前电池的电压
                int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
                // 电池的健康状态
                int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);
                // 电池当前的电量, 它介于0和 EXTRA_SCALE之间
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                // 电池电量的最大值
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                // 当前手机使用的是哪里的电源
                int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                // 电池使用的技术。比如，对于锂电池是Li-ion
                String technology = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
                // 当前电池的温度
                int temperature = intent. getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);


//                mMessageTvw.setText("voltage : " + voltage + "\n" +
//                        "health : " + health + "\n" +
//                        "level : " + level + "\n" +
//                        "scale : " + scale + "\n" +
//                        "plugged : " + plugged + "\n" +
//                        "status : " + status + "\n" +
//                        "technology : " + technology + "\n" +
//                        "temperature : " + temperature + "\n" );



                mMessageTvw.setText("voltage : " + voltage + "\n" +
                        "level : " + level + "\n");


            }


        }
    } ;


    private void closeRobot() throws JSONException, ParseException {

        String value = "{\"datetime\":\"O+10m\",\"suggestDatetime\":\"2018-06-13T17:48:34\"}";
        JSONObject jsonObject = new JSONObject(value);
        //{"datetime":"O+10m","suggestDatetime":"2018-03-27T10:11:56"}
        String datetime = jsonObject.getString("suggestDatetime").replace("T", " ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(datetime);
        String current = format.format(new Date());
        Date currentDate = format.parse(current);
        //获得时间差
        int time = (int) ((date.getTime() - currentDate.getTime()) / 1000);
        LogHelper.i(TAG, "time : " + time);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}

