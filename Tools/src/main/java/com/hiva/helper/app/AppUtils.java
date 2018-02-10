package com.hiva.helper.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;

import com.hiva.helper.log.LogHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/31.
 */

public class AppUtils {

    public static final String TAG = AppUtils.class.getSimpleName() ;

    /**
     *
     * 通过Action 获取,service package
     * */
    public static HashSet<String> getPackageNameByServiceAction(Context context, String action){

        HashSet<String> packageNames = new HashSet<>() ;

        PackageManager pm = context.getPackageManager();
        Intent robotService = new Intent(action) ;
        List<ResolveInfo> ris =  pm.queryIntentServices(robotService, 0) ;
        final int size = ris.size() ;
        for (int i = 0 ; i < size ; i++){

            ResolveInfo ri = ris.get(i) ;
            packageNames.add(ri.serviceInfo.packageName) ;

            LogHelper.i(TAG, action + " -> " + ri.serviceInfo.packageName) ;
        }
        return packageNames ;
    }




//    /**
//     *
//     * 通过Action 获取,service package
//     * */
//    public static HashMap<String,Receiver> getOutputClientByServiceAction(Context context , String action){
//
//        HashMap<String,Receiver> outputClients = new HashMap<>() ;
//
//        PackageManager pm = context.getPackageManager();
//        Intent robotService = new Intent(action) ;
//        List<ResolveInfo> ris =  pm.queryIntentServices(robotService, 0) ;
//        final int size = ris.size() ;
//        for (int i = 0 ; i < size ; i++){
//
////            ResolveInfo ri = ris.get(i) ;
////            packageNames.add(ri.serviceInfo.packageName) ;
//
//
//            String packageName = ris.get(i).serviceInfo.packageName ;
//            Receiver receiver = new Receiver(context, packageName, action) ;
//            outputClients.put(packageName, receiver) ;
//
//        }
//        return outputClients ;
//    }


    /**
     * 获取最上层界面的Activity
     * 只能获取当前APP，获取其他APP需要系统权限
     *
     * */
    public static String getTopComponentName(Context context){

        try{

            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE) ;
            ComponentName componentName = manager.getRunningTasks(1).get(0).topActivity ;

            Log.i(TAG, "当前查询的top componentName: " + componentName) ;

            return componentName.getPackageName();

        }catch (Exception e){

            return null ;
        }
    }



    /***
     * 获取Application的堆栈列表
     *
     * */
    public static ArrayList<Activity> getActivitiesByApplication(Application application) {

        ArrayList<Activity> list = new ArrayList<>();
        try {
            Class<Application> applicationClass = Application.class;
            Field mLoadedApkField = applicationClass.getDeclaredField("mLoadedApk");
            mLoadedApkField.setAccessible(true);
            Object mLoadedApk = mLoadedApkField.get(application);
            Class<?> mLoadedApkClass = mLoadedApk.getClass();
            Field mActivityThreadField = mLoadedApkClass.getDeclaredField("mActivityThread");
            mActivityThreadField.setAccessible(true);
            Object mActivityThread = mActivityThreadField.get(mLoadedApk);
            Class<?> mActivityThreadClass = mActivityThread.getClass();
            Field mActivitiesField = mActivityThreadClass.getDeclaredField("mActivities");
            mActivitiesField.setAccessible(true);
            Object mActivities = mActivitiesField.get(mActivityThread);
            // 注意这里一定写成Map，低版本这里用的是HashMap，高版本用的是ArrayMap
            if (mActivities instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<Object, Object> arrayMap = (Map<Object, Object>) mActivities;
                for (Map.Entry<Object, Object> entry : arrayMap.entrySet()) {
                    Object value = entry.getValue();
                    Class<?> activityClientRecordClass = value.getClass();
                    Field activityField = activityClientRecordClass.getDeclaredField("activity");
                    activityField.setAccessible(true);
                    Object o = activityField.get(value);
                    list.add((Activity) o);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        return list;
    }



    /**是否是主线程*/
    public static boolean isMainThread() {

        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }


    /**
     * 打开APP
     * @param context Android上下文
     * @param packageName 包名（全称）
     * @param className     类名（全称）
     * @param parameters  参数
     *
     * @return 成功tianzh* */
    public static boolean startApp(Context context, String packageName, String className, HashMap<String,String> parameters){

        Intent intent = new Intent() ;
        intent.setClassName(packageName, className);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;
        if(parameters != null){

            for (Map.Entry<String, String> entry : parameters.entrySet() ) {

                intent.putExtra(entry.getKey(), entry.getValue()) ;
            }
        }

        try{
            context.startActivity(intent);
            return true ;
        }catch (Exception e){
        }

        return false ;
    }


    /**
     * 获取开机时间(毫秒)
     * */
    public static long getBootMillTime(){
        // 当前时间减去开机时间
        return System.currentTimeMillis() - getPastMillTime();
    }

    /**
     * 获取已开机时间（毫秒）
     * */
    public static long getPastMillTime(){

        return SystemClock.elapsedRealtime() ;
    }


    /**
     * 获取版本号
     * */
    public static int getVersionCode(Context context) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = context
                    .getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);

            localVersion = packageInfo.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    /**
     * 获取版本名称
     * */
    public static String getVersionName(Context context) {

        String localVersion = "";
        try {
            PackageInfo packageInfo = context
                    .getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            localVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

}
