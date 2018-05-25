package com.framework.common.commonview;

import android.graphics.Color;
import android.os.Bundle;

import com.framework.common.commonmvp.BaseModel;
import com.framework.common.commonmvp.BasePresenter;
import com.framework.common.commonmvp.BaseView;
import com.framework.common.commonutil.TUtil;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by dyping on 2018/3/30.
 */

public abstract class BaseFrameActivity<P extends BasePresenter, M extends BaseModel> extends BaseActivity implements BaseView {

    public P mPresenter;
    public M mModel;
    public SweetAlertDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);

        mDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        mDialog.setTitleText("Loading");
        mDialog.setCancelable(false);

        if (this instanceof BaseView && mPresenter != null) {
            mPresenter.attachVM(this, mModel);
            mPresenter.attchDialog(mDialog);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {

        if (mPresenter != null) {
            mPresenter.detachVM();
        }

        super.onDestroy();
    }
}
