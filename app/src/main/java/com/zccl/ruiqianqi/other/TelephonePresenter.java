package com.zccl.ruiqianqi.other;


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

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import com.hiva.helper.log.LogHelper;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create By HuangXiangXiang 2018/4/27
 * 电话控制
 * 以下格式
 *          我想打电话给XXX 、我要打电话给XXX、我打电话给XXX、打电话给XXX
 *          我想给XXX打电话、我要给XXX打电话、给XXX打电话
 *
 */
public class TelephonePresenter {

    private static final String TAG = TelephonePresenter.class.getSimpleName() ;

    //打电话控制
    private final static String[] telephoneRegs = {"^我想打电话给(.*)$", "^我要打电话给(.*)$", "^我打电话给(.*)$", "^打电话给(.*)$",
            "^我想给(.*)打电话$", "^我要给(.*)打电话$", "^给(.*)打电话$"};


    private static TelephonePresenter mTelephonePresenter;

    public static TelephonePresenter getInstance(Context context) {

        if (mTelephonePresenter == null) {

            mTelephonePresenter = new TelephonePresenter(context.getApplicationContext());
        }
        return mTelephonePresenter;
    }

    private Context mContext;

    private TelephonePresenter(Context context) {

        this.mContext = context;

    }


    public boolean parseText(String word) {

        LogHelper.i(TAG, LogHelper.__TAG__() + ", word : " + word);

        String telephoneObject = isMatcher(word);
        if(!TextUtils.isEmpty(telephoneObject)){

            if(isPhoneNumber(telephoneObject)){
                // 电话号码

                callPhone(telephoneObject);

            }else {
                // 电话名称

                String number = queryNumberByName(telephoneObject) ;
                if(!TextUtils.isEmpty(number)){

                    callPhone(number) ;

                }else {

                    // 无此联系人
                }

            }

            return true ;
        }

        return false ;
    }


    /***/
    private String isMatcher(String word) {

        LogHelper.i(TAG, LogHelper.__TAG__()) ;

        int length = telephoneRegs.length;
        for (int i = 0; i < length; i++) {

            String result = isMatcher(word, telephoneRegs[i]);

            if (!TextUtils.isEmpty(result)) {

                return result;

            }
        }

        return null;
    }

    /***/
    private String isMatcher(String word, String telephoneReg) {

        LogHelper.i(TAG, LogHelper.__TAG__()) ;

        Pattern pattern = Pattern.compile(telephoneReg);
        Matcher matcher = pattern.matcher(word);

        if (matcher.find()) {

            return matcher.group(1);
        }

        return null;
    }


    private static final String REGEX_PHONE_NUMBER = "^([0-9]*)$" ;
    /**
     * 判断是纯数字号码
     * 纯数字直接拨打
     * 其他的先去查询一遍
     * */
    private boolean isPhoneNumber(String telephoneObject){

        return telephoneObject.matches(REGEX_PHONE_NUMBER) ;
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
        mContext.startActivity(intent);
    }

    private static final String PROVIDER_CONTACTS = "com.yongyida.robot.contactsprovider";
    private static final String URI = "content://" + PROVIDER_CONTACTS + "/contacts";
    /**查询电话号码根据名称*/
    private String queryNumberByName(String name){

        String number = null ;

        Uri uri = Uri.parse(URI);
        Cursor cursor = mContext.getContentResolver().query(uri,null,"name=?",new String[]{name},null);
        if(cursor != null){

            if(cursor.moveToFirst()){

                number = cursor.getString(cursor.getColumnIndex("number"));
            }
            cursor.close();
        }
        return number ;
    }


}
