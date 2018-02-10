package com.hiva.helper.app.storage;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by HuangXiangXiang on 2018/1/13.
 */
public class StorageUtils {

    private static String getRootPath(){

        try
        {
            Runtime runtime = Runtime.getRuntime();
            // 运行mount命令，获取命令的输出，得到系统中挂载的所有目录
            Process proc = runtime.exec("mount");
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            String line;
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null)
            {
                Log.d("", line);
                // 将常见的linux分区过滤掉

                if (line.contains("proc") || line.contains("tmpfs") || line.contains("media") ||
                        line.contains("asec") || line.contains("secure") || line.contains("system") ||
                        line.contains("cache") || line.contains("sys") || line.contains("data") ||
                        line.contains("shell") || line.contains("root") || line.contains("acct") ||
                        line.contains("misc") || line.contains("obb"))
                {
                    continue;
                }

                // 下面这些分区是我们需要的
                if (line.contains("fat") || line.contains("fuse") || (line.contains("ntfs")))
                {
                    // 将mount命令获取的列表分割，items[0]为设备名，items[1]为挂载路径
                    String items[] = line.split(" ");
                    if (items.length > 1)
                    {
                        String path = items[1];
                        // 添加一些判断，确保是sd卡，如果是otg等挂载方式，可以具体分析并添加判断条件
                        if (path.contains("/storage") && !path.equals("/storage/emulated")){

                            return new File(path,"YYDRobotEducation").getAbsolutePath();
                        }
                    }
                }
            }
        } catch (Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return  null ;
    }


    public static String getData(){

            StringBuilder stringBuilder = new StringBuilder() ;
        try
        {
            Runtime runtime = Runtime.getRuntime();
            // 运行mount命令，获取命令的输出，得到系统中挂载的所有目录
            Process proc = runtime.exec("mount");
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);


            String line;
            while ((line = br.readLine()) != null)
            {
                Log.d("", line);
                stringBuilder.append(line + "\n") ;
            }
        } catch (Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return  stringBuilder.toString() ;
    }


}
