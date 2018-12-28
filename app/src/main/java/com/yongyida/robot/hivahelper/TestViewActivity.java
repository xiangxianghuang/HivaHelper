package com.yongyida.robot.hivahelper;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.yongyida.robot.hivahelper.floatbutton.FloatButtonService;
import com.yongyida.robot.hivahelper.view.WaveView;
import com.yongyida.robot.utils.LogHelper;

import java.net.Inet4Address;
import java.util.Random;



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

/**
 * Create By HuangXiangXiang 2018/7/10
 */
public class TestViewActivity extends Activity implements View.OnClickListener {

    private static final String TAG = FloatButtonService.class.getSimpleName() ;

    public static final String ACTION_CHAT                          = "com.yydrobot.emotion.CHAT" ;
    public static final String KEY_ACTION                           = "action";


    private WaveView mWaveWvw;
    /**
     * 开始
     */
    private Button mStartBtn;
    /**
     * 停止
     */
    private Button mStopBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_view);
        initView();


//        Intent intent = new Intent() ;
//        intent.putExtra(KEY_ACTION, "init") ;
//
//        startService(this,intent) ;
    }

    public static void startService(Context context, Intent intent){

        LogHelper.i(TAG, LogHelper.__TAG__()) ;

//        intent.setPackage("com.yongyida.robot.lockscreen") ;
//        intent.setAction("com.yydrobot.emotion.CHAT") ;
//        intent.putExtra("action", "init") ;
//
//        context.startService(intent) ;
    }

    private void initView() {
        mWaveWvw = (WaveView) findViewById(R.id.wave_wvw);
        mStartBtn = (Button) findViewById(R.id.start_btn);
        mStartBtn.setOnClickListener(this);
        mStopBtn = (Button) findViewById(R.id.stop_btn);
        mStopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.start_btn:
//                mWaveWvw.startControl();

//                Intent intent = new Intent() ;
//                intent.setClassName("com.wyt.iexuetang.tv", "com.wyt.iexuetang.sharp.activities.AdvertisingActivity") ;
//                startActivity(intent);

                Intent intent = new Intent();
                intent.setAction(intent.ACTION_VIEW);
                intent.setData(Uri.parse("wyt_iexuetang_preinstall_invocation://second_classification_invocation?module=module_xx_mskt"));
                startActivity(intent);




                break;
            case R.id.stop_btn:
//                mWaveWvw.stopControl();

                Uri uri = Uri.parse("https://www.xfyun.cn/services/online_tts");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                break;

        }
    }
}
