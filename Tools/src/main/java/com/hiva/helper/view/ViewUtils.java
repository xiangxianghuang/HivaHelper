package com.hiva.helper.view;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by HuangXiangXiang on 2018/2/10.
 */
public class ViewUtils {

    /**
     * 设置使得TextView可以滑动
     * */
    public void setTextViewScroll(TextView textView){

        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

}
