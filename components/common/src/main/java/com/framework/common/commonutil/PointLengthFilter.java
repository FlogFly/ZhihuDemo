package com.framework.common.commonutil;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Project:ChintPay
 * Author:dyping
 * Date:2017/6/8 20:10
 */

public class PointLengthFilter implements InputFilter {


    private static final int DECIMAL_DIGITS = 2;//小数的位数

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        // 删除等特殊字符，直接返回
        if ("".equals(source.toString())) {
            return null;
        }

        String dValue = dest.toString();
        String[] splitArray = dValue.split("\\.");
        if (splitArray.length > 1) {
            String dotValue = splitArray[1];
            int diff = dotValue.length() + 1 - DECIMAL_DIGITS;
            if (diff > 0) {
                return "";
            }
        }
        return null;
    }
}
