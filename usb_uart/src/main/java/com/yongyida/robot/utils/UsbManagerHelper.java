package com.yongyida.robot.utils;


/* 
                              _ooOoo_ 
                             o8888888o 
                             88" . "88 
                             (| -_- |) 
                             O\  =  /O 
                          ____/`---'\____ 
                        .'  \\|     |//  `. 
                       /  \\|||  :  |||//  \ 
                      /  _||||| -:- |||||-  \ 
                      |   | \\\  -  /// |   | 
                      | \_|  ''\---/''  |   | 
                      \  .-\__  `-`  ___/-. / 
                    ___`. .'  /--.--\  `. . __ 
                 ."" '<  `.___\_<|>_/___.'  >'"". 
                | | :  `- \`.;`\ _ /`;.`/ - ` : | | 
                \  \ `-.   \_ __\ /__ _/   .-` /  / 
           ======`-.____`-.___\_____/___.-`____.-'====== 
                              `=---=' 
           .............................................  
                    佛祖镇楼                  BUG辟易  
            佛曰:  
                    写字楼里写字间，写字间里程序员；  
                    程序人员写程序，又拿程序换酒钱。  
                    酒醒只在网上坐，酒醉还来网下眠；  
                    酒醉酒醒日复日，网上网下年复年。  
                    但愿老死电脑间，不愿鞠躬老板前；  
                    奔驰宝马贵者趣，公交自行程序员。  
                    别人笑我忒疯癫，我笑自己命太贱；  
                    不见满街漂亮妹，哪个归得程序员？ 
*/

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.usb.IUsbManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;

import com.yongyida.robot.usb_uart.UART;


/**
 * Create By HuangXiangXiang 2018/5/14
 */
public class UsbManagerHelper {

    private static final String TAG = UsbManagerHelper.class.getSimpleName() ;

    public final static String ACTION_USB_PERMISSION = "ACTION_USB_PERMISSION";
    private UsbManager mManager ;


    public UsbManagerHelper(Context context){

        mManager  = (UsbManager) context.getSystemService(Context.USB_SERVICE);

    }


//    public boolean openDevice() {
//
//        if (isOpen){
//
//            // 已经打开
//            return true;
//        }
//
//        UsbDevice usbDevice = mDriver.EnumerateDevice() ;
//        if(usbDevice == null){
//
//            return false ;
//        }
//
//
//        boolean hasPermission = mUsbManager.hasPermission(usbDevice) ;
//        LogHelper.i(TAG, LogHelper.__TAG__() + ", hasPermission: " + hasPermission);
//
//        if(hasPermission){
//
//            return openDevice() ;
//
//        }else {
//
//            PendingIntent pi = PendingIntent.getBroadcast(this.mContext, 0, new Intent(ACTION_USB_PERMISSION), 0);
//            registerReceiver() ;
//            this.mUsbManager.requestPermission(usbDevice, pi);
//
//        }
//        return false ;
//    }





    public void requestUsbPermission(Context context){



    }




    public final BroadcastReceiver mReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (ACTION_USB_PERMISSION.equals(action)) {
                synchronized (this) {
                    UsbDevice device = (UsbDevice) intent
                            .getParcelableExtra(UsbManager.EXTRA_DEVICE);
                    LogHelper.i(TAG,LogHelper.__TAG__() + " UsbManager.EXTRA_DEVICE : " + intent.getParcelableExtra(UsbManager.EXTRA_DEVICE));
                    LogHelper.i(TAG,LogHelper.__TAG__() + " 是否有权限了？？？？？？   " + mManager.hasPermission(device));

                    if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                        if (device != null) {
                            // Open reader
                            LogHelper.i(TAG,LogHelper.__TAG__() + " Opening reader: " + device.getDeviceName()+ "...");
//                            new OpenTask().execute(device);
                        }
                    } else {
                        if (device != null) {

                            LogHelper.i(TAG,LogHelper.__TAG__() + " Permission no EXTRA_PERMISSION_GRANTED for device " + device.getDeviceName());
                        }

                    }
                }
            } else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                synchronized (this) {
                    // Close reader
                    /* logMsg("Closing reader..."); */
//                    new CloseTask().execute();
                }
            }
        }
    };
}
