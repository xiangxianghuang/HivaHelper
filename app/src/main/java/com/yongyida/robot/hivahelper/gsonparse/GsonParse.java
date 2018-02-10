package com.yongyida.robot.hivahelper.gsonparse;

import com.yongyida.robot.hivahelper.gsonparse.bean.KeyInfo;

/**
 * Created by HuangXiangXiang on 2018/1/23.
 * 按照指定解析方式解析数据
 *
 */
public class GsonParse {

    private void initJson(){

        KeyInfo keyInfo = new KeyInfo() ;

        KeyInfo.BaseType baseType = new KeyInfo.StringType() ;
        baseType.keyName = "text" ;
        keyInfo.addBaseType(baseType);

        baseType = new KeyInfo.StringType() ;
        baseType.keyName = "service" ;
        keyInfo.addBaseType(baseType);

        baseType = new KeyInfo.IntegerType() ;
        baseType.keyName = "ret" ;
        keyInfo.addBaseType(baseType);

        baseType = new KeyInfo.StringType() ;
        baseType.keyName = "msg" ;
        keyInfo.addBaseType(baseType);


        baseType = new KeyInfo.KeyInfoType() ;
        baseType.keyName = "data" ;

        KeyInfo keyInfo1 = new KeyInfo() ;
        baseType = new KeyInfo.StringType() ;
        baseType.keyName = "intent"  ;
        keyInfo1.addBaseType(baseType);









    }



    private KeyInfo.ArrayType getArrayType(){

        KeyInfo.ArrayType arrayType = new KeyInfo.ArrayType() ;
        arrayType.keyName = "slots"  ;

        KeyInfo keyInfo0 = new KeyInfo() ;

        KeyInfo.StringType stringType_0 = new KeyInfo.StringType() ;
        stringType_0.keyName = "key" ;
        keyInfo0.addBaseType(stringType_0);

        KeyInfo.StringType stringType_1 = new KeyInfo.StringType() ;
        stringType_1.keyName = "value" ;
        keyInfo0.addBaseType(stringType_1);

        return arrayType ;
    }


}

