package com.yongyida.robot.hivahelper;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by ruiqianqi on 2017/8/22 0022.
 */

public class NavigatePresenter {

    private final String TAG = NavigatePresenter.class.getName();

    private String regexDestination = ".*(带我)?(到|去)%s.*";
    // 定点的位置
    private ArrayList<String> positionDestinations = new ArrayList<>();

    private String regexIntroduce = ".*(参观|介绍)(下|一下)?%s.*";
    // 巡航的位置
    private ArrayList<String>  positionIntroduces = new ArrayList<>() ;

    public NavigatePresenter(){
        init();
    }


    /**
     * 初始化
     */
    private void init(){

        String path = new File(Environment.getExternalStorageDirectory(),"/navigation/content.xls").getAbsolutePath();
        initExcelData(path) ;

    }

    /**
     * 语义解析失败，进行巡航、导航
     * @param text
     */
    public void parseErrorNavigate(String text){

        Log.i(TAG, "parseErrorNavigate text : " + text ) ;

        String destination = regexText(text,positionDestinations, regexDestination) ;
        if(destination != null){


            Log.i(TAG, "destination : " + destination ) ;

            return;
        }

        String introduce = regexText(text,positionIntroduces, regexIntroduce) ;
        if(introduce != null){

            Log.i(TAG, "introduce : " + introduce ) ;

            return;
        }

    }


    private String regexText(String text , ArrayList<String> positions, String regex){

        final int size = positions.size() ;

        for (int i = 0 ; i < size ; i++){

            String position = positions.get(i) ;
            String rgx = String.format(regex,position);

            Log.i(TAG, "regexText rgx : " + rgx ) ;

            if(text.matches(rgx)){

                return position ;
            }
        }
        return null ;
    }




    public void initExcelData(String path)  {

        HSSFWorkbook hssfWorkbook = null ;
        try {
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(path));
            hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);   //第一张表


            int first = hssfSheet.getFirstRowNum() ;
            int last = hssfSheet.getLastRowNum() ;
            for (int i = first ; i <= last ; i ++){

                HSSFRow row = hssfSheet.getRow(i);
                Cell cell =  row.getCell(0) ;
                String value = cell.getStringCellValue().trim() ;

                if(!TextUtils.isEmpty(value)){

                    Log.i(TAG, "positionDestinations value : " + value);
                    positionDestinations.add(value) ;
                }
            }


            hssfSheet = hssfWorkbook.getSheetAt(1);   //第二张表
            first = hssfSheet.getFirstRowNum() ;
            last = hssfSheet.getLastRowNum() ;
            for (int i = first ; i <= last ; i ++){

                HSSFRow row = hssfSheet.getRow(i);
                Cell cell =  row.getCell(0) ;
                String value = cell.getStringCellValue().trim() ;

                if(!TextUtils.isEmpty(value)){

                    Log.i(TAG, "positionIntroduces value : " + value);
                    positionIntroduces.add(value) ;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(hssfWorkbook != null){

                try {
                    hssfWorkbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
