package com.yhy.ampoverlaydemo.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yhy.ampoverlaydemo.R;
import com.yhy.ampoverlaydemo.util.AdaptationClass;
import com.yhy.ampoverlaydemo.util.MyLayoutParas;


/**
 * Created by yhy on 2016/3/17 0017.
 */
public class MyLocationMarkerView extends FrameLayout {

    private FrameLayout mFmConent;
    private FrameLayout mFmBorder;

    private ImageView mIvFoot;
    private ImageView mIvBorder;
    private CircleImageView mCirHead;

    private AdaptationClass mAdaptationClass;
    private Context mContext;

    public MyLocationMarkerView(Context context,AdaptationClass adaptationClass) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.fm_mylocation_icon, this, true);

        this.mAdaptationClass = adaptationClass;
        this.mContext = context;

        initView();
        initData();
        initConfig();
        initEvent();
    }

    public MyLocationMarkerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLocationMarkerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(){

        mFmConent = (FrameLayout) findViewById(R.id.mylocation_content);
        mFmBorder = (FrameLayout) findViewById(R.id.mylocation_head_fm_border);

        mIvBorder = (ImageView) findViewById(R.id.mylocation_iv_border);
        mCirHead = (CircleImageView) findViewById(R.id.mylocation_cir_head);
        mIvFoot = (ImageView) findViewById(R.id.mylocation_iv_foot);

    }
    private void initData(){

    }
    private void initConfig(){


        //适配不同机型
        MyLayoutParas.myFmConfig(mIvFoot, mAdaptationClass, 30, 10, MyLayoutParas.GRAVITY_BOTTOM_HORIZONTAL, 0, 0, 0, 0);
        MyLayoutParas.myFmConfig(mIvBorder, mAdaptationClass, 106, 125, MyLayoutParas.GRAVITY_CENTER, 0, 0, 0, 0);
        MyLayoutParas.myFmConfig(mFmBorder, mAdaptationClass, 106, 106, 0, 0, 0, 0, 0);
        MyLayoutParas.myFmConfig(mCirHead, mAdaptationClass, 85, 85, MyLayoutParas.GRAVITY_CENTER, 0, 0, 0, 0);

        mIvBorder.setPadding(0, 0, 0, mAdaptationClass.getZoomX(5));
        mFmBorder.setPadding(0,0,0,mAdaptationClass.getZoomX(5));
        mFmConent.setPadding(0,0,0,mAdaptationClass.getZoomX(35));

    }
    private void initEvent(){

    }
    public void setmCirHead(int dog){
        mCirHead.setImageResource(dog);
    }
    public void setmCirHeadGuide(){
//        mCirHead.setImageResource(R.drawable.);
    }

}
