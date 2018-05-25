package com.framework.common.commonutil;

import android.text.TextUtils;

/**
 * Project:ChintPay
 * Author:dyping
 * Date:2017/5/16 10:04
 */

public class StringUtil {

    public static int indexOf(String[] source,String item){
        if(source == null || item == null){
            return -1;
        }
        for (int i = 0; i < source.length; i++) {
            if(item.equals(source[i])){
                return i;
            }
        }
        return -1;
    }

    public static String checkNull(String source){
        if(TextUtils.isEmpty(source)){
            return "";
        }else {
            return source;
        }
    }

}
