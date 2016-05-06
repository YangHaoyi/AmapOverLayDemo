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
 * Created by StevenRogers on 2016/3/19 0019.
 */
public class OtherDogMarkerView extends FrameLayout {
    private FrameLayout mFmConent;
//    private FrameLayout mFmBorder;

    private ImageView mIvFoot;
    private ImageView mIvBorder;
    private CircleImageView mCirHead;

    private AdaptationClass mAdaptationClass;
    private Context mContext;

    public OtherDogMarkerView(Context context, AdaptationClass adaptationClass) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.fm_otherlocation_icon, this, true);

        this.mAdaptationClass = adaptationClass;
        this.mContext = context;

        initView();
        initData();
        initConfig();
        initEvent();
    }

    public OtherDogMarkerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OtherDogMarkerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(){

        mFmConent = (FrameLayout) findViewById(R.id.mylocation_content);
//        mFmBorder = (FrameLayout) findViewById(R.id.mylocation_head_fm_border);

        mIvBorder = (ImageView) findViewById(R.id.mylocation_iv_border);
        mCirHead = (CircleImageView) findViewById(R.id.mylocation_cir_head);
        mIvFoot = (ImageView) findViewById(R.id.mylocation_iv_foot);

    }
    private void initData(){

    }
    private void initConfig(){


        MyLayoutParas.myFmConfig(mFmConent, mAdaptationClass, 70, 88, MyLayoutParas.GRAVITY_BOTTOM_HORIZONTAL, 0, 0, 0, 0);
        MyLayoutParas.myFmConfig(mIvFoot, mAdaptationClass, 30, 10, MyLayoutParas.GRAVITY_BOTTOM_HORIZONTAL, 0, 0, 0, 0);
        MyLayoutParas.myFmConfig(mIvBorder, mAdaptationClass, 70, 83, MyLayoutParas.GRAVITY_TOP_HORIZONTAL, 0, 0, 0, 0);
//        MyLayoutParas.myFmConfig(mFmBorder, mAdaptationClass, 70, 70, 0, 0, 0, 0, 0);
        MyLayoutParas.myFmConfig(mCirHead, mAdaptationClass, 60, 60, MyLayoutParas.GRAVITY_TOP_HORIZONTAL, 0, 5, 0, 0);

//        mIvBorder.setPadding(0, 0, 0, mAdaptationClass.getZoomX(10));
//        mFmBorder.setPadding(0,0,0,mAdaptationClass.getZoomX(10));
//        mFmConent.setPadding(0,0,0,mAdaptationClass.getZoomX(35));

    }
    private void initEvent(){

    }
    public void setmCirHead(int dog){

        mCirHead.setImageResource(dog);
    }
    public void setGender(String gender){
        if (gender.equals("woman")) {
            mIvBorder.setImageResource(R.mipmap.woman);
        } else {
            mIvBorder.setImageResource(R.mipmap.other_bor_man);
        }
    }
}
