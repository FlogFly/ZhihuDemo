package com.framework.common.commonutil;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by willy on 17/1/18.
 */

public class TypeValueUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    //获取状态栏高度
    public static int getStatusBarHeight(Context context){
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    //获取标题栏高度
    public static int getTitleBarHeight(Activity aty){
        int contentViewTop = aty.getWindow()
                .findViewById(Window.ID_ANDROID_CONTENT).getTop();
        // statusBarHeight是上面所求的状态栏的高度
        int titleBarHeight = contentViewTop - getStatusBarHeight(aty);
        return titleBarHeight;
    }


    /**
     * 获取屏幕的宽高
     *
     * @return int[0] 代表屏幕的宽
     * <br/>
     * int[1] 代表屏幕的高
     */
    public static int[] getScreenSize(Context context) {
        int[] size = new int[2];

        DisplayMetrics dm = new DisplayMetrics();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        wm.getDefaultDisplay().getMetrics(dm);

        size[0] = dm.widthPixels;
        size[1] = dm.heightPixels;
        return size;
    }

}
