package com.hiva.helper.list;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Create By HuangXiangXiang 2018/12/13
 */
public class ListUtils {


    /**
     * 数组转换成列表
     */
    public static <T> ArrayList<T> toArraysList(T[] t) {

        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, t);

        return list;
    }


}
