package com.framework.appinit.imgload.glide;

import android.content.Context;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.framework.appinit.imgload.ImageLoadUtil;

/**
 * Created by wenda on 2017/4/26.
 */

public class GlideImageLoader implements ImageLoadUtil.ImageLoader {
    @Override
    public void loadImage(Context context, ImageView imageView, String url,int placeholderImg,int errorImg) {
        Glide.with(context).load(url)//
                .asBitmap()
                .placeholder(placeholderImg)//
                .error(errorImg)//
                .centerCrop()
                .into(imageView);
    }

    @Override
    public void loadImage(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url)//
                .asBitmap()
                .centerCrop()
                .into(imageView);

    }


    @Override
    public void loadOriginalImage(Context context, final ImageView imageView, String url) {
        Glide.with(context).load(url).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                imageView.setImageDrawable(resource);
            }
        });
    }

    @Override
    public void loadRoundImage(Context context, ImageView imageView, String url,int placeholderImg,int errorImg) {
        RequestManager glideRequest;
        glideRequest = Glide.with(context);
        glideRequest.load(url)
                .asBitmap()
                .placeholder(placeholderImg)
                .error(errorImg)
                .centerCrop()
                .transform(new GlideRoundTransform(context)).into(imageView);
    }

    @Override
    public void loadCircleImage(Context context, ImageView imageView, String url,int placeholderImg,int errorImg) {
        RequestManager glideRequest;
        glideRequest = Glide.with(context);
        glideRequest.load(url)
                .placeholder(placeholderImg)
                .error(errorImg)
                .crossFade()
                .transform(new GlideCircleTransform(context)).into(imageView);
    }

    @Override
    public void clearMemoryCache(Context context) {
        clearImageDiskCache(context);
        clearImageMemoryCache(context);
    }

    /**
     * 清除图片磁盘缓存
     */
    public static void clearImageDiskCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context).clearDiskCache();
                    }
                }).start();
            } else {
                Glide.get(context).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除图片内存缓存
     */
    public static void clearImageMemoryCache(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
