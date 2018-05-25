package com.demo.donation.homemodule.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.demo.donation.homemodule.R;
import com.demo.donation.homemodule.entity.ThemeListBean;

import java.util.List;

/**
 * Created by dyping on 2018/4/4.
 */

public class ThemeListAdapter extends BaseQuickAdapter<ThemeListBean.OthersBean,BaseViewHolder> {


    public ThemeListAdapter(int layoutResId, @Nullable List<ThemeListBean.OthersBean> data) {
        super(layoutResId, data);
    }

    @Override
        protected void convert(BaseViewHolder helper, ThemeListBean.OthersBean item) {
                helper.setText(R.id.theme_name_tv,item.getName());
        }


}
