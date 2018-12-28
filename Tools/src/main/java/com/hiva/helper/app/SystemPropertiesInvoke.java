package com.hiva.helper.app;

import android.annotation.SuppressLint;

import java.lang.reflect.Method;

/**
 * Created by HuangXiangXiang on 2018/1/30.
 */
@SuppressLint("PrivateApi")
public class SystemPropertiesInvoke {

    /**
     * 反射获取android系统配置信息
     * */
    public static String get(String key) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class);
            return (String)(get.invoke(c, key));
        } catch (Exception e) {
            e.printStackTrace();
            return null ;
        }
    }

    public static String get(String key, String def) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            return (String)(get.invoke(c, key, def ));
        } catch (Exception e) {
            e.printStackTrace();
            return null ;
        }
    }

    public static int getInt(String key, int def) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("getInt", String.class, int.class);
            return (int)(get.invoke(c, key, def ));
        } catch (Exception e) {
            e.printStackTrace();
            return -1 ;
        }
    }


    public static long getLong(String key, long def) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("getInt", String.class, long.class);
            return (long) get.invoke(c, key, def );
        } catch (Exception e) {
            e.printStackTrace();
            return -1 ;
        }
    }

    public static boolean getBoolean(String key, boolean def) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("getBoolean", String.class, boolean.class);
            return (boolean) get.invoke(c, key, def );
        } catch (Exception e) {
            e.printStackTrace();
            return false ;
        }
    }


    public static void set(String key, String value) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.invoke(c, key, value );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {

           Class ownerClass = owner.getClass();
           Class[] argsClass = new Class[args.length];

           for (int i = 0, j = args.length; i < j; i++) {

               argsClass[i] = args[i].getClass();
           }

            Method method = ownerClass.getMethod(methodName, argsClass);
            return method.invoke(owner, args);
    }

}
