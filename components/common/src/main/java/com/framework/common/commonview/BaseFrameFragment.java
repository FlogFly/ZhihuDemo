package com.framework.common.commonview;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.framework.common.commonmvp.BaseModel;
import com.framework.common.commonmvp.BasePresenter;
import com.framework.common.commonmvp.BaseView;
import com.framework.common.commonutil.TUtil;

/**
 * Created by dyping on 2018/3/30.
 */

public abstract class BaseFrameFragment<P extends BasePresenter,M extends BaseModel> extends BaseFragment implements BaseView{

    public P mPresenter;

    public M mModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.attachVM(this, mModel);
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachVM();
        }
        super.onDestroy();
    }

}
