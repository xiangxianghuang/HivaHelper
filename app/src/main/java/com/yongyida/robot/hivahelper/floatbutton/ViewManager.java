package com.yongyida.robot.hivahelper.floatbutton;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.hiva.helper.log.LogHelper;

/**
 * Created by HuangXiangXiang on 2018/2/3.
 */
public class ViewManager {

    private static final String TAG = ViewManager.class.getSimpleName() ;

    FloatingView floatBall;
    WindowManager windowManager;
    public static ViewManager manager;
    Context context;
    private WindowManager.LayoutParams floatBallParams;

    private ViewManager(Context context) {
        this.context = context;
    }

    public static ViewManager getInstance(Context context) {
        if (manager == null) {
            manager = new ViewManager(context);
        }
        return manager;
    }
    public void showFloatBall() {
        floatBall = new FloatingView(context);
        windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        if (floatBallParams == null) {
            floatBallParams = new WindowManager.LayoutParams();
            floatBallParams.width = floatBall.width;
            floatBallParams.height = floatBall.height;
//            floatBallParams.gravity = Gravity.TOP | Gravity.LEFT;
            floatBallParams.gravity = Gravity.NO_GRAVITY ;
            floatBallParams.type = WindowManager.LayoutParams.TYPE_TOAST;
            floatBallParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
            floatBallParams.format = PixelFormat.RGBA_8888;
        }

        windowManager.addView(floatBall, floatBallParams);

//        WindowManager.LayoutParams layoutParam1 = (WindowManager.LayoutParams) floatBall.getLayoutParams();
//        layoutParam1.x  = 200 ;
//        layoutParam1.y  = 100 ;
//        floatBall.setLayoutParams(layoutParam1);

        floatBall.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int) event.getX();
                int y = (int) event.getY();

                LogHelper.i(TAG , LogHelper.__TAG__() +" X : " + x + "，Y : " + y);

                ViewGroup.LayoutParams layoutParams = floatBall.getLayoutParams();
                LogHelper.i(TAG , LogHelper.__TAG__() + ", layoutParams : " + layoutParams);

                WindowManager.LayoutParams layoutParam1 = (WindowManager.LayoutParams) layoutParams;
                layoutParam1.x  = x ;
                layoutParam1.y  = y ;
                windowManager.updateViewLayout(floatBall, layoutParam1);

                return false;
            }
        });


        floatBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EventBus.getDefault().post(MyAccessibilityService.BACK);
                Toast.makeText(context, "点击了悬浮球 执行后退操作", Toast.LENGTH_SHORT).show();
            }
        });

        floatBall.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                EventBus.getDefault().post(MyAccessibilityService.HOME);
                Toast.makeText(context, "长按了悬浮球  执行返回桌面", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public int getScreenWidth() {
        return windowManager.getDefaultDisplay().getWidth();
    }


}
