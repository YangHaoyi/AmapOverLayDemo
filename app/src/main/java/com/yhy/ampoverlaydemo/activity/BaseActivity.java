package com.yhy.ampoverlaydemo.activity;

import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;

import com.yhy.ampoverlaydemo.util.AdaptationClass;

/**
 * Created by Administrator on 2016/5/4.
 */
public class BaseActivity extends FragmentActivity {


    protected AdaptationClass mAdaptationClass;

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initView();
        initConfig();
        initData();
        initEvent();
    }
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initConfig();
        initData();
        initEvent();
    }


    public int getZoom(int length) {
        if (mAdaptationClass == null) {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            mAdaptationClass = new AdaptationClass(dm.widthPixels,
                    dm.heightPixels, dm.density);
        }
        return mAdaptationClass.getZoomX(length);
    }

    public AdaptationClass getmAdaptationClass(){
        if (mAdaptationClass == null) {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            mAdaptationClass = new AdaptationClass(dm.widthPixels,
                    dm.heightPixels, dm.density);
        }
        return mAdaptationClass;
    }


    public int getScreenHeight(){
        return (int)mAdaptationClass.getCurHeight();
    }







    protected void initView(){

    }

    //初始化适配相关
    protected void initConfig(){

    }
    protected void initData(){

    }

    protected void initEvent(){

    }
}
