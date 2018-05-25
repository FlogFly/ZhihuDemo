package com.framework.appinit.imgload.picasso;

import android.content.Context;
import android.widget.ImageView;

import com.framework.appinit.imgload.ImageLoadUtil;

/**
 * Created by wenda on 2017/4/26.
 */

public class PicassoImageLoader implements ImageLoadUtil.ImageLoader {
    @Override
    public void loadImage(Context context, ImageView imageView, String url,int placeholderImg,int errorImg) {
       /* Picasso.with(context).load(url)
                .placeholder(placeholderImg)
                .error(errorImg)
                .into(imageView);*/
    }

    @Override
    public void loadImage(Context context, ImageView imageView, String url) {
        /*Picasso.with(context).load(url)
                .into(imageView);*/
    }

    @Override
    public void loadOriginalImage(Context context, ImageView imageView, String url) {

    }

    @Override
    public void loadRoundImage(Context context, ImageView imageView, String url,int placeholderImg,int errorImg) {

    }

    @Override
    public void loadCircleImage(Context context, ImageView imageView, String url,int placeholderImg,int errorImg) {

    }

    @Override
    public void clearMemoryCache(Context context) {
    }
}
