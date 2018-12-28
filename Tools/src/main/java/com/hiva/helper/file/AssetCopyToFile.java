package com.hiva.helper.file;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Create By HuangXiangXiang 2018/12/14
 *
 * 拷贝数据（将assert 拷贝直接指定文件）
 */
public class AssetCopyToFile {

    private static final String TAG = AssetCopyToFile.class.getSimpleName() ;

//    /**在asserts目录*/
//    public static final String PLAY_PATH_ASSERTS = "image" ;
//    /**Sdcard卡文件目录（如果是根目录是""）*/
//    public static final String SDCARD_ROOT_PATH = "YYDRobotSensorMotion" ;
//
//    public static final File SDCARD_ROOT = new File(Environment.getExternalStorageDirectory(), SDCARD_ROOT_PATH) ;

    /**
     * 将assert目录拷贝至指定文件路径中去(如果存在更目录；不拷贝)
     *
     * @param context 上下文
     * @param assetFromPath 需要拷贝的assets中的目录名（ “XXX”、“XXX/XX”、等）
     * @param toFile 需要拷贝到目录文件（指定目录）
     * */
    public static void copyAssetsToFileIfNone(Context context,String assetFromPath, File toFile){

        File file = new File(toFile, assetFromPath) ;
        if(isNeedCopy(file)){

            copyAssetsToFile(context, assetFromPath, toFile);
        }
    }

    /**
     * 将assert目录拷贝至指定文件路径中去(直接拷贝)
     *
     * @param context 上下文
     * @param assetFromPath 需要拷贝的assets中的目录名（ “XXX”、“XXX/XX”、等）
     * @param toFile 需要拷贝到目录文件（指定目录）
     * */
    public static void copyAssetsToFile(Context context, String assetFromPath, File toFile){

        copyDirectoryAsserts2Sdcard(context.getAssets(), assetFromPath , toFile) ;
    }

    /**
     * 将assert目录拷贝至指定文件路径中去(目录不存在 或者 存在目录可以删除；然后在拷贝)
     *
     * @param context 上下文
     * @param assetFromPath 需要拷贝的assets中的目录名（ “XXX”、“XXX/XX”、等）
     * @param toFile 需要拷贝到目录文件（指定目录）
     * */
    public static void copyOnlyAssetsToFile(Context context,String assetFromPath, File toFile){

        File file = new File(toFile, assetFromPath) ;
        if(!file.exists() || file.delete()){ // 文件不存在 或者 文件可以删除

            copyDirectoryAsserts2Sdcard(context.getAssets(), assetFromPath , toFile) ;
        }
    }


    /**
     * 是否需要拷贝文件夹到该目录去
     *
     * 如果存在该文件并且是文件夹不需要拷贝，
     *
     * */
    private static boolean isNeedCopy(File file){

        if(file.exists()) {
            return !file.isDirectory() && file.delete();
        }
        return true;
    }


    /**
     * 拷贝文件夹
     *
     * */
    private static void copyDirectoryAsserts2Sdcard(AssetManager assetManager, String assetFromPath, File toFile){

        try {
            String[] fileNames = assetManager.list(assetFromPath) ;
            for (String fileName : fileNames) {

                String filePath = assetFromPath + "/" + fileName;

                if (fileName.contains(".")) {// 包含.表示文件

                    copyFileAsserts2Sdcard(assetManager, filePath, toFile);

                } else {//其他为文件夹

                    copyDirectoryAsserts2Sdcard(assetManager, filePath, toFile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    /**
     * 拷贝文件
     * */
    private static void copyFileAsserts2Sdcard(AssetManager assetManager, String path, File toFile){

        File file = new File(toFile, path);
        File parent = file.getParentFile();
        if(!parent.exists() && !parent.mkdirs() ){  // 不存在并且不能创建

            return;
        }

        InputStream in = null;
        FileOutputStream out = null;

        try {

            in = assetManager.open(path);
            out = new FileOutputStream(file) ;

            byte[] bs = new byte[1024*1024] ;   // 拷贝1MB
            int length ;

            while ((length = in.read(bs)) > 0){

                out.write(bs,0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
