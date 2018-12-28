package com.hiva.helper.app.view;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Create By HuangXiangXiang 2018/12/18
 */
public class VideoView2 extends SurfaceView {

    private MediaPlayer player;

    public VideoView2(Context context, AttributeSet attrs) {
        super(context, attrs);

        //下面开始实例化MediaPlayer对象
        player = new MediaPlayer();
        player.setOnPreparedListener(mOnPreparedListener);
        player.setOnCompletionListener(mOnCompletionListener);

        SurfaceHolder holder = getHolder() ;
        holder.addCallback(mCallback);

    }


    private SurfaceHolder.Callback mCallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {

            player.setDisplay(holder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    } ;


    private MediaPlayer.OnPreparedListener mOnPreparedListener = new MediaPlayer.OnPreparedListener(){
        @Override
        public void onPrepared(MediaPlayer mp) {

            mp.start();
        }
    } ;

    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mp.start();
        }
    } ;



    public void setFilePath(String path) throws IOException {

        player.setDataSource(path);
        player.prepareAsync();
    }

    public void setFileAssetsPath(String path) throws IOException {

        AssetManager am = getContext().getAssets() ;
        AssetFileDescriptor afd = am.openFd(path) ;
        player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        player.prepareAsync();
    }



}
