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
import android.widget.Toast;

import com.hiva.helper.log.LogHelper;

/**
 * Create By HuangXiangXiang 2018/4/27
 * 遥控器
 * 执行这些语句“打开遥控器，开遥控器，我要打开遥控器，我想打开遥控器”
 *
 */
public class ControlPresenter {

    private static final String TAG = ControlPresenter.class.getSimpleName() ;

    private static final String[] tips = {"开遥控器", "打开遥控器", "我要打开遥控器", "我想打开遥控器"} ;

    private static ControlPresenter mControlPresenter ;
    public static ControlPresenter getInstance(Context context){

        if(mControlPresenter == null){

            mControlPresenter = new ControlPresenter(context.getApplicationContext()) ;
        }
        return mControlPresenter ;
    }


    private Context mContext ;
    private ControlPresenter(Context context){

        this.mContext = context ;
    }


    public boolean parseText(String word){

        LogHelper.i(TAG, LogHelper.__TAG__()) ;

        if(isMatcher(word)){

            openControl() ;

            return true ;
        }

        return false ;
    }


    /**
     * 判断是否合适对应的功能
     * */
    private boolean isMatcher(String word){

        LogHelper.i(TAG, LogHelper.__TAG__()) ;

        final int length = tips.length ;
        for (int i = 0 ; i < length ; i ++){

            String tip = tips[i] ;

            if(tip.equals(word)){

                return true ;
            }
        }
        return false ;
    }


    /**
     * 打开遥控器
     * */
    private void openControl(){

        LogHelper.i(TAG, LogHelper.__TAG__()) ;

        Intent intent = new Intent() ;
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;
        intent.setClassName("com.yongyida.robot.irremote","com.yongyida.robot.irremote.main.StartActivity") ;
        try {

            mContext.startActivity(intent);

        }catch (Exception e){

            LogHelper.e(TAG, LogHelper.__TAG__() + ", e : " + e.getMessage()) ;

            Toast.makeText(mContext,"遥控器APP未安装！",Toast.LENGTH_SHORT).show();
        }

    }
}
