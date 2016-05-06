package com.yhy.ampoverlaydemo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.yhy.ampoverlaydemo.R;
import com.yhy.ampoverlaydemo.util.AdaptationClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by StevenRogers on 2016/3/19 0019.
 */
public class PlaceDetailInfowindow extends LinearLayout {


    private Context mContext;
    private AdaptationClass mAdaptationClass;


    private LinearLayout mLlMain;
    private LinearLayout mPlaceBg;
    private LinearLayout mLlMsgOne;
    private LinearLayout mLlMsgTwo;
    private LinearLayout mLlMsgThree;
    private LinearLayout mPlaceText;
    private RelativeLayout mRlError;

    private ImageView mIvLine;
    private InforWindowTriangleView mPlaceTriang;

    private CircleImageView cirOne;
    private CircleImageView cirTwo;
    private CircleImageView cirThree;
    private CircleImageView cirFour;
    private CircleImageView cirFive;
    private CircleImageView cirSix;
    private CircleImageView cirSeven;
    private CircleImageView cirEight;
    private CircleImageView cirNine ;
    private CircleImageView cirTen;
    private CircleImageView cirEleven;
    private CircleImageView cirTwelve;
    private CircleImageView cirThirteen;
    private CircleImageView cirFourteen;
    private TextView mTvInfoWeek;
    private TextView mTvInfoSurround;

    private String mPlaceDetailId;
    private List<CircleImageView> cirHeads = new ArrayList<CircleImageView>();

    public PlaceDetailInfowindow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlaceDetailInfowindow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PlaceDetailInfowindow(Context context, AdaptationClass adaptationClass) {
        super(context);

        this.mContext = context;
        this.mAdaptationClass = adaptationClass;

        LayoutInflater.from(context).inflate(R.layout.ll_place_detail,this,true);
        initView();
        initData();
        initConfing();
        initEvent();
    }

    private void initView(){

        mLlMain = (LinearLayout)findViewById(R.id.info_window_place_main);
        mPlaceBg = (LinearLayout)findViewById(R.id.infowindow_place_bg);
        mPlaceTriang = (InforWindowTriangleView)findViewById(R.id.infowindow_trainle);
        mPlaceText = (LinearLayout)findViewById(R.id.ll_palce_text);

        mLlMsgOne = (LinearLayout)findViewById(R.id.info_line_one);
        mLlMsgTwo = (LinearLayout)findViewById(R.id.info_line_two);
        mLlMsgThree = (LinearLayout)findViewById(R.id.info_line_three);
        mIvLine = (ImageView)findViewById(R.id.info_iv);


        cirOne = (CircleImageView) findViewById(R.id.info_window_cir_one);
        cirTwo = (CircleImageView) findViewById(R.id.info_window_cir_two);
        cirThree = (CircleImageView) findViewById(R.id.info_window_cir_three);
        cirFour = (CircleImageView) findViewById(R.id.info_window_cir_four);
        cirFive = (CircleImageView) findViewById(R.id.info_window_cir_five);
        cirSix = (CircleImageView) findViewById(R.id.info_window_cir_six);
        cirSeven = (CircleImageView) findViewById(R.id.info_window_cir_seven);

        cirEight = (CircleImageView) findViewById(R.id.info_window_cir_eight);
        cirNine = (CircleImageView) findViewById(R.id.info_window_cir_nine);
        cirTen = (CircleImageView) findViewById(R.id.info_window_cir_ten);
        cirEleven = (CircleImageView) findViewById(R.id.info_window_cir_eleven);
        cirTwelve = (CircleImageView) findViewById(R.id.info_window_cir_twleve);
        cirThirteen = (CircleImageView) findViewById(R.id.info_window_cir_thirteen);
        cirFourteen = (CircleImageView) findViewById(R.id.info_window_cir_fourteenth);
        mRlError = (RelativeLayout)findViewById(R.id.dog_park_detil_find_error1);
        mTvInfoWeek = (TextView)findViewById(R.id.info_week);
        mTvInfoSurround = (TextView)findViewById(R.id.info_surround);


    }
    private void initData(){
        cirHeads.clear();
        cirHeads.add(cirOne);
        cirHeads.add(cirTwo);
        cirHeads.add(cirThree);
        cirHeads.add(cirFour);
        cirHeads.add(cirFive);
        cirHeads.add(cirSix);
        cirHeads.add(cirSeven);

        cirHeads.add(cirEight);
        cirHeads.add(cirNine);
        cirHeads.add(cirTen);
        cirHeads.add(cirEleven);
        cirHeads.add(cirTwelve);
        cirHeads.add(cirThirteen);
        cirHeads.add(cirFourteen);
    }
    private void initConfing(){

    }
    private void initEvent(){

    }
    public void onlyMsgIndowindow(){
        mLlMsgOne.setVisibility(View.GONE);
        mLlMsgTwo.setVisibility(View.GONE);
        mLlMsgThree.setVisibility(View.GONE);
        mIvLine.setVisibility(View.GONE);
        mPlaceText.setPadding(0,0,0,mAdaptationClass.getZoomX(20));
    }

    public void showInfowindow(){
        mPlaceBg.setVisibility(View.VISIBLE);
        mPlaceText.setVisibility(View.VISIBLE);
        mPlaceBg.setBackgroundResource(R.drawable.info_window_mine);
        mPlaceTriang.setVisibility(View.VISIBLE);
    }
    public void setTitleMsg(String weekStar, String weekEnd, String timeStart, String timeEnd, String surround){
        mTvInfoWeek.setText(weekStar + "" + "到" + weekEnd + "" + "  " + timeStart + "-" + timeEnd);
        mTvInfoWeek.setTextColor(getResources().getColor(R.color.line_color_grey));
        mTvInfoSurround.setText(surround);
        mTvInfoSurround.setTextColor(getResources().getColor(R.color.line_color_grey));
    }
    public void setCirHeads(String url, int index){
//            Glide.with(mContext)
//                    .load(url)
//                    .crossFade()
//                    .into(cirHeads.get(index));
    }

}
