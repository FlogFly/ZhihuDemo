package com.demo.donation.homemodule.view;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.allen.library.RxHttpUtils;
import com.allen.library.interceptor.Transformer;
import com.demo.donation.homemodule.R;
import com.demo.donation.homemodule.adapter.ThemeListAdapter;
import com.demo.donation.homemodule.api.ThemeApi;
import com.demo.donation.homemodule.entity.ThemeListBean;
import com.framework.common.commonview.BaseActivity;
import com.framework.coremodel.http.CommonObserver;

/**
 * Created by dyping on 2018/4/4.
 */

@Route(path = "/homemodule/home")
public class HomeActivity extends BaseActivity {

    private RecyclerView drawerRv;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;


    @Override
    public void setRootView() {
        setContentView(R.layout.activity_home);
    }

    @Override
    public void initData() {
        super.initData();


    }

    @Override
    public void initWidget() {
        super.initWidget();

        drawerRv = findViewById(R.id.drawer_rv);
        drawerRv.setLayoutManager(new LinearLayoutManager(this));
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolBar);

        //获取主题列表
        initThemeList();

    }

    private void initThemeList() {

        RxHttpUtils.createApi(ThemeApi.class)
                .getThemeList()
                .compose(Transformer.<ThemeListBean>switchSchedulers())
                .subscribe(new CommonObserver<ThemeListBean>() {
                    @Override
                    protected void onError(String error) {

                    }

                    @Override
                    protected void onSuccess(ThemeListBean bean) {
                        ThemeListAdapter adapter = new ThemeListAdapter(R.layout.item_theme_content, bean.getOthers());
                        View view = LayoutInflater.from(aty).inflate(R.layout.item_theme_header, ((ViewGroup) drawerRv.getParent()), false);
                        adapter.addHeaderView(view);

                        View view1 = LayoutInflater.from(aty).inflate(R.layout.item_theme_home_content, ((ViewGroup) drawerRv.getParent()), false);
                        adapter.addHeaderView(view1);


                        drawerRv.setAdapter(adapter);

                        drawerLayout.openDrawer(Gravity.LEFT);

                    }
                });

    }
}
