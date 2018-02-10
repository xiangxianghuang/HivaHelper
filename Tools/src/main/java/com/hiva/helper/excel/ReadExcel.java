package com.hiva.helper.excel;

import android.text.TextUtils;
import android.util.Log;

import com.hiva.helper.log.LogHelper;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HuangXiangXiang on 2017/12/20.
 *
 * excel 样式模板
 *          name0 name1 name2 name3 name4...
 * item0
 * item1
 * item2
 * item3
 * item4
 * ...
 *
 */
public class ReadExcel {

    private static final String TAG = LogHelper.TAG() ;


    public static HashMap<String,String> getItems(String path)  {

        return getItems(path, null) ;

    }

    public static HashMap<String,String> getItems(String path, String name)  {

        HSSFWorkbook hssfWorkbook = null ;
        try {
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(path));
            hssfWorkbook =  new HSSFWorkbook(poifsFileSystem);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);   //第一张表
            HSSFRow firstRow = hssfSheet.getRow(0);         //第一行数据
            int columnIndex = getColumn(firstRow, name) ;

            if(columnIndex != -1){

                HashMap<String, String> items = new HashMap<>() ;
                int rowEnd = hssfSheet.getLastRowNum();

                for (int i = 1 ; i < rowEnd ; i++){

                    HSSFRow row = hssfSheet.getRow(i);
                    HSSFCell keyCell = row.getCell(0);
                    String key = keyCell.getStringCellValue().trim() ;
                    if(!TextUtils.isEmpty(key)){

                        HSSFCell valueCell = row.getCell(columnIndex);
                        String value = valueCell.getStringCellValue().trim() ;

                        LogHelper.i(TAG , LogHelper.__TAG__() + ", key : " + key + ", value : " + value) ;

                        items.put(key,value) ;
                    }

                }

                return items ;
            }
        } catch (IOException e) {
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

        return null ;
    }


    /**
     * 获取含有该数据对应的列数
     *
     * */
    private static int getColumn(HSSFRow firstRow, String name){

        if(TextUtils.isEmpty(name)){

            return 1 ;
        }

        int lastCellNum = firstRow.getLastCellNum();

        LogHelper.i(TAG , LogHelper.__TAG__() + ", lastCellNum : " + lastCellNum) ;

        for(int i = 1 ; i < lastCellNum ; i++ ){

            HSSFCell cell = firstRow.getCell(i);
            String value = cell.getStringCellValue().trim() ;

            LogHelper.i(TAG , LogHelper.__TAG__() + ", i : "+ i + ", value : " + value) ;
            if(name.equalsIgnoreCase(value)){

                return i;
            }

        }

        return -1 ;
    }


    /**
     *
     * */
    public static ArrayList<String> getFirstColumnItems(String path)  {

        return getColumnItems(path, 0) ;
    }

    public static ArrayList<String> getColumnItems(String path, int column)  {

        HSSFWorkbook hssfWorkbook = null ;
        try {
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(path));
            hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);   //第一张表

            ArrayList<String> items = new ArrayList<>() ;

            int first = hssfSheet.getFirstRowNum() ;
            int last = hssfSheet.getLastRowNum() ;
            for (int i = first ; i < last ; i ++){

                HSSFRow row = hssfSheet.getRow(i);
                Cell cell =  row.getCell(column) ;
                String value = cell.getStringCellValue().trim() ;

                if(!TextUtils.isEmpty(value)){

                    LogHelper.i(TAG, LogHelper.__TAG__() + " value : " + value);
                    items.add(value) ;
                }
            }

            return items ;
        } catch (IOException e) {
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

        return null ;
    }


    public static void initExcelData(String path)  {

        LogHelper.i(TAG, LogHelper.__TAG__() + " path : " + path);

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

//                    LogHelper.i(TAG, LogHelper.__TAG__() + "positionDestinations value : " + value);
                    LogHelper.i(TAG,  "positionDestinations value : " + value);
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

//                    LogHelper.i(TAG, LogHelper.__TAG__() + "positionIntroduces value : " + value);
                    LogHelper.i(TAG, "positionIntroduces value : " + value);
                }
            }

        } catch (IOException e) {
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
