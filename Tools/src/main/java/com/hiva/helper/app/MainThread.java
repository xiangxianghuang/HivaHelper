package com.hiva.helper.app;


import android.os.Handler;
import android.os.Looper;

/**
 * Create By HuangXiangXiang 2018/12/28
 * 不管当期是什么线程都切换至主线程去
 */
public class MainThread {


    /**
     * 判断当前线程是否是主线程
     * */
    public static boolean isMainThread() {

        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /**
     * 转换到主线程中去
     * @param handler 需要在主线程中创建
     * @param runnable 相当回调函数
     * */
    public static void executeInMainThread(Handler handler, Runnable runnable){

        if(isMainThread()){
            runnable.run();

        }else {
            handler.post(runnable) ;
        }
    }


    /**
     * 转换到主线程中去
     * @param runnable 相当回调函数
     * */
    public static void executeInMainThread(Runnable runnable){

        if(isMainThread()){

            runnable.run();
        }else {

            Handler handler = new Handler(Looper.getMainLooper()) ;
            handler.post(runnable) ;
        }
    }



}
