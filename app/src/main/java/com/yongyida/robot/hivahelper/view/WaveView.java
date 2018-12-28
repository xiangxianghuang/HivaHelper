package com.yongyida.robot.hivahelper.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
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
public class WaveView extends View {

    private static final String TAG = WaveView.class.getSimpleName();

    private Paint mPaint;
    private Path mPath;
    private int width, height;


    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int size = waves.size();
        for (int i = 0 ; i < size; i++){
            Wave wave = waves.get(i) ;

            mPaint.setColor(wave.color);

            mPath.reset();
            mPath.moveTo(wave.startX, height);
            mPath.rQuadTo(waveWidth, 0, waveWidth*2, -wave.waveHeight);
            mPath.rQuadTo(waveWidth,-wave.waveHeight,waveWidth*2,0);
            mPath.rQuadTo(waveWidth, wave.waveHeight, waveWidth*2, wave.waveHeight);
            mPath.lineTo(wave.startX, height);
            mPath.close();
            canvas.drawPath(mPath, mPaint);
        }

    }


    private final int waveWidth = 100;    // 曲线1/4的长度

    private ArrayList<Wave> waves = new ArrayList<>();
    {
        Wave wave = new Wave(0x6654748e, 0, 100) ;
        waves.add(wave) ;

        wave = new Wave(0x8874548e, 100,150) ;
        waves.add(wave) ;

        wave = new Wave(0x5574548e, 200,200) ;
        waves.add(wave) ;

    }

    private class Wave{

        private final int color ;
        private final int startX  ; // 偏移X轴位置

        private int waveHeight ;   // 曲线绘制1/2的最高点


        Wave(int color, int startX, int waveHeight){

            this.color = color ;
            this.startX = startX ;
            this.waveHeight = waveHeight ;
        }
    }


    public void startControl() {

        stopControl() ;

        mControlThread = new ControlThread() ;
        mControlThread.start();
    }

    public void stopControl() {

        if(mControlThread != null && mControlThread.isRun){

            mControlThread.startRun() ;
        }
    }

    private ControlThread mControlThread ;
    private class ControlThread extends Thread{

        private boolean isRun = true ;
        @Override
        public void run() {

            while (isRun){

                int size = waves.size();
                for (int i = 0 ; i < size; i++) {
                    Wave wave = waves.get(i);
                    wave.waveHeight = new Random().nextInt(100) ;
                }

                postInvalidate();

                try {
                    sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        void startRun() {

            isRun = false ;
        }
    }

}
