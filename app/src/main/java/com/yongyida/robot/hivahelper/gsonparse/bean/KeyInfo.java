package com.yongyida.robot.hivahelper.gsonparse.bean;


import java.util.ArrayList;

/**
 * Created by HuangXiangXiang on 2018/1/23.
 * 解析json格式数据
 */
public class KeyInfo {

    public ArrayList<BaseType> baseTypeArrays ;

    public void addBaseType(BaseType baseType){

        if(baseTypeArrays == null){

            baseTypeArrays = new ArrayList<>() ;
        }
        baseTypeArrays.add(baseType) ;
    }


    public static abstract class BaseType{

        public String keyName ;
    }

    public static class IntegerType extends BaseType{

        public int vaule ;
    }

    public static class StringType extends BaseType{

        public String vaule ;
    }

    public static class ArrayType extends BaseType{

        public KeyInfo keyInfo;
    }


    public static class KeyInfoType extends BaseType{

        public KeyInfo vaule ;
    }


}
