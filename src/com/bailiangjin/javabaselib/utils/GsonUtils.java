package com.bailiangjin.javabaselib.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Gson 工具类
 *
 * @author blj
 */
public enum GsonUtils {
    INSTANCE;
    private Gson gson = null;

    private GsonUtils() {
        gson = new Gson();
    }


    public  <T extends Object> T toObj(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        Type type = new TypeToken<T>() {
        }.getType();
        return (T) gson.fromJson(json, type.getClass());
    }

    public  <T> T toObj(String json, Class<T> clazz) {

        if (StringUtils.isEmpty(json) || null == clazz) {
            return null;
        }
        try {
            return gson.fromJson(json, clazz);
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("json date format error:"+e.getMessage());
            return null;
        }

    }

    public String toJson(Object obj) {
        return gson.toJson(obj);
    }


    /**
     * 将json array 字符串转换为  List
     *
     * @param jsonArrayStr json array 字符串
     * @return List<T>
     */
    public  <T extends Object> List<T> parsJsonArrayStr2List(String jsonArrayStr) {

        if (StringUtils.isEmpty(jsonArrayStr)) {
            return null;
        }
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        List<T> list = gson.fromJson(jsonArrayStr, type);

        if (null != list) {
            return list;
        }
        return null;
    }

    public Gson getGson() {
        return gson;
    }


}
