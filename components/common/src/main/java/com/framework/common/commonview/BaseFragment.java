package com.framework.common.commonview;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by willy on 17/1/20.
 */

public abstract class BaseFragment extends Fragment{

    View view;
    public Activity aty;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflaterView(inflater, container, savedInstanceState);
        aty = getActivity();
        initData();
        onLoadData();
        initWidget();
        return view;
    }

    protected abstract View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);


    protected void initData() {
        
    }

    protected void onLoadData(){

    }

    protected void initWidget() {


    }

    //当通过changeFragment()显示时会被调用
    public void onChange() {

    }

}
