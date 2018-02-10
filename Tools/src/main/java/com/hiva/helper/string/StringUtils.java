package com.hiva.helper.string;

import java.util.Formatter;

/**
 * Created by HuangXiangXiang on 2017/12/4.
 */
public class StringUtils {


     /**
     * 比较是否相等
     * ""和null 不相等
     * */
    public static boolean isEquals(String str1, String str2){

        if(str1 == null){

            return str2 == null ;
        }

        return str1.equals(str2) ;
    }

    /**
     * 比较是否相等
     * ""和null 相等
     * */
    public static boolean isEqualsIgnoreNull(String str1, String str2){

        str1 = (str1 == null) ? "" : str1 ;
        str2 = (str2 == null) ? "" : str2 ;

        return str1.equals(str2) ;
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
