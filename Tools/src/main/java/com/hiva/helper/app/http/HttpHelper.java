package com.hiva.helper.app.http;

import com.google.gson.Gson;
import com.hiva.helper.log.LogHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Create By HuangXiangXiang 2018/12/25
 */
public class HttpHelper {


    private static final String TAG = HttpHelper.class.getSimpleName() ;


    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final Gson GSON = new Gson() ;

    /**
     * post请求数据 参数为json数据格式
     * */
    public static String requestPostJson(String url, HashMap<String, String>paramsMap){


        String json  ;
        if(paramsMap != null) {

            JSONObject jsonObject = new JSONObject();
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {

                String key = entry.getKey();
                String value = entry.getValue();
                LogHelper.i(TAG, LogHelper.__TAG__() + ",key : " + key + ",value : " + value);
                try {
                    jsonObject.put(key, value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            json = jsonObject.toString();
        }else{

            json = null ;
        }

        return requestPostJson(url, json) ;
    }

    /**
     * post请求数据 参数为json数据格式
     * */
    public static String requestPostJson(String url, Object object ){

        String json ;
        if(object != null){

            json = GSON.toJson(object) ;

        } else{

            json = null ;
        }

        LogHelper.i(TAG, LogHelper.__TAG__() + ",json : " + json);
        return requestPostJson(url,json) ;
    }

    /**
     * post请求数据 参数为json数据格式
     * */
    public static String requestPostJson(String url, String json){

        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder() ;
        requestBuilder.url(url) ;

        if(json != null){

            RequestBody body = RequestBody.create(JSON, json);
            requestBuilder.post(body) ;
        }
        Request request = requestBuilder .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null ;
    }



    /**
     * get请求数据
     * */
    public static String requestGet(String url, HashMap<String, Object> paramsMap){

        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder() ;
        if(paramsMap != null && !paramsMap.isEmpty()){

            StringBuilder sb = new StringBuilder(url) ;
            sb.append("?") ;

            for (Map.Entry<String,Object> entry : paramsMap.entrySet()) {

                String key = entry.getKey() ;
                Object value = entry.getValue() ;

                LogHelper.i(TAG, LogHelper.__TAG__() + ",key : " + key  + ",value : " + value );

                sb
                        .append(key)
                        .append("=")
                        .append(value)
                        .append("&");
            }
            sb.deleteCharAt(sb.length()-1) ;

            url = sb.toString();
        }

        LogHelper.w(TAG,LogHelper.__TAG__() + "url : " + url );
        requestBuilder.url(url) ;
        Request request = requestBuilder.build();

        try {

            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null ;
    }
}
