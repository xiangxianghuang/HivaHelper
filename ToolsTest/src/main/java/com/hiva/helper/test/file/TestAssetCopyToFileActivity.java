package com.hiva.helper.test.file;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.hiva.helper.app.MainThread;
import com.hiva.helper.file.AssetCopyToFile;
import com.hiva.helper.log.LogHelper;
import com.hiva.helper.test.R;
import com.yongyida.robot.expression.ExpressionControl;

import java.io.File;

/**
 * Create By HuangXiangXiang 2018/12/14
 */
public class TestAssetCopyToFileActivity extends Activity implements MediaPlayer.OnCompletionListener {


    private static final String TAG = TestAssetCopyToFileActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermission(this) ;
        setContentView(R.layout.activity_test_asset_copy_to_file);


        DisplayMetrics displayMetrics = getResources().getDisplayMetrics() ;
        LogHelper.i(TAG, LogHelper.__TAG__() + ",displayMetrics : " + displayMetrics);

//        VideoView mVideoVvw = findViewById(R.id.video_vvw);
//
//        String uri = "android.resource://" + getPackageName() + "/" + R.raw.caro_idle;
//        mVideoVvw.setVideoURI(Uri.parse(uri));
//
//        mVideoVvw.setOnCompletionListener(this);

//        File file = new File(Environment.getExternalStorageDirectory(), "face_0.mp4") ;
//        mVideoVvw.setVideoPath(file.getAbsolutePath());
//        mVideoVvw.start();
    }

    /**
     * 判断是否有存储程序
     * */
    public static boolean checkSelfStoragePermission(Context context) {

        boolean result1 = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        boolean result2 = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        return result1 && result2;
    }

    private void checkPermission(Activity context) {

        if (!checkSelfStoragePermission(context)) {

            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {

            for (int grantResult : grantResults) {

                if (grantResult != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "缺少相关权限，请允许相关权限", Toast.LENGTH_LONG).show();

                    finish();
                    return;
                }
            }

        }
    }

        /**在asserts目录*/
    public static final String PLAY_PATH_ASSERTS = "image" ;
    /**Sdcard卡文件目录（如果是根目录是""）*/
    public static final String SDCARD_ROOT_PATH = "YYDRobotSensorMotion" ;

    public static final File SDCARD_ROOT = new File(Environment.getExternalStorageDirectory(), SDCARD_ROOT_PATH) ;

    public void copyAssetsToFileIfNone(View view) {

        AssetCopyToFile.copyAssetsToFileIfNone(this, PLAY_PATH_ASSERTS,SDCARD_ROOT ) ;

    }

    long bootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }
    public void copyAssetsToFile(final View view) {

      LogHelper.i(TAG, LogHelper.__TAG__() + ", bootTime : " + bootTime());

    }




    public void copyOnlyAssetsToFile(View view) {


        new Thread(){

            @Override
            public void run() {

                LogHelper.i(TAG, LogHelper.__TAG__()) ;
                Runnable mRunnable = new Runnable() {
                    @Override
                    public void run() {

//                        LogHelper.w(TAG, LogHelper.__TAG__()) ;

                        Looper myLooper = Looper.myLooper() ;
                        LogHelper.i(TAG, LogHelper.__TAG__() + ",myLooper : " + myLooper ) ;

                        Looper mainLooper = Looper.getMainLooper() ;
                        LogHelper.i(TAG, LogHelper.__TAG__() + ",myLooper : " + myLooper + ",mainLooper : " + mainLooper ) ;
                    }
                };

                Looper.prepare();
                Looper myLooper = Looper.myLooper() ;
                LogHelper.i(TAG, LogHelper.__TAG__() + ",myLooper : " + myLooper  ) ;
                myLooper = Looper.myLooper() ;
                LogHelper.i(TAG, LogHelper.__TAG__() + ",myLooper : " + myLooper  ) ;

                Looper mainLooper = Looper.getMainLooper() ;
                LogHelper.i(TAG, LogHelper.__TAG__() + ",myLooper : " + myLooper + ",mainLooper : " + mainLooper ) ;

                Handler mHandler = new Handler() ;
                MainThread.executeInMainThread(mRunnable);

                Looper.loop();

                LogHelper.i(TAG, LogHelper.__TAG__()) ;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LogHelper.i(TAG, LogHelper.__TAG__()) ;


            }
        }.start();


    }

    @Override
    public void onCompletion(MediaPlayer mp) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mp.start();
    }
}
