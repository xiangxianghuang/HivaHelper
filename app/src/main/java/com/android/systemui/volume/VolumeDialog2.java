package com.android.systemui.volume;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.yongyida.robot.hivahelper.R;

/**
 * Created by HuangXiangXiang on 2018/2/25.
 */
public class VolumeDialog2 extends Dialog {

    private TextView mVolumeTvw ;
    private SeekBar mVolumeSbr ;

    public VolumeDialog2(Context context) {
        super(context, R.style.Dialog_Fullscreen);

        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
        mAudioManager.setRingerMode(2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.volume_dialog2);
        mVolumeTvw = (TextView) findViewById(R.id.volume_tvw) ;
        mVolumeSbr = (SeekBar) findViewById(R.id.volume_sbr) ;

        getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        int max = mAudioManager.getStreamMaxVolume(3);
        mVolumeSbr.setMax(max);
    }


    private static final long DELAY_TIME = 2*1000 ;
    private Handler mHandler = new Handler() ;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            dismiss();
        }
    };


    private int volume ;    // 音量大小
    public void showVolume(int volume){

        mHandler.removeCallbacks(mRunnable);

        this.volume = volume ;
        show();

        mHandler.postDelayed(mRunnable, DELAY_TIME) ;
    }


    @Override
    public void show() {

        super.show();
        mVolumeTvw.setText(String.valueOf(volume));
        mVolumeSbr.setProgress(volume);
    }

    private  AudioManager mAudioManager ;

    public void showVolume(){

        volume = mAudioManager.getStreamVolume(3) ;
        showVolume(volume) ;
    }

    public void dismissVolume(){

        dismiss();
    }


}
