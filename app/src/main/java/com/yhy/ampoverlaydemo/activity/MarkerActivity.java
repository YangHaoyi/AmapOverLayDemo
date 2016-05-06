package com.yhy.ampoverlaydemo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.yhy.ampoverlaydemo.R;
import com.yhy.ampoverlaydemo.customview.MyLocationMarkerView;
import com.yhy.ampoverlaydemo.customview.OtherDogMarkerView;
import com.yhy.ampoverlaydemo.customview.PlaceDetailInfowindow;

/**
 * Created by yhy on 2016/5/6.
 */
public class MarkerActivity extends BaseActivity implements LocationSource, AMapLocationListener, AMap.OnMarkerClickListener, AMap.InfoWindowAdapter {


    Bundle mSavedInstanceState;
    private AMap aMap;
    private MapView mapView;
    private UiSettings mUiSettings;
    private LocationSource.OnLocationChangedListener mLocationLinstener;
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    private View infoWindow = null;


    private PlaceDetailInfowindow placeDetailInfowindow;

    private Marker mMarkMyLocation;
    private Marker mManMarker;
    private Marker mWomanMarker;
    private Marker currentMarker;
    private double mLocatinLat;
    private double mLocationLon;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker);
        mSavedInstanceState = savedInstanceState;
    }

    @Override
    protected void initView() {
        super.initView();
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(mSavedInstanceState);// 此方法必须重写
        if (aMap == null) {
            aMap = mapView.getMap();
            aMap.setOnMapLoadedListener(new AMap.OnMapLoadedListener() {
                @Override
                public void onMapLoaded() {
                    aMap.setMapType(AMap.MAP_TYPE_NAVI);
                    setMyLocationStyleIcon();
                }
            });

        }
        mUiSettings = aMap.getUiSettings();
        mUiSettings.setLogoPosition(2);//设置高德地图logo位置
        mUiSettings.setZoomControlsEnabled(false);
        mUiSettings.setTiltGesturesEnabled(false);
        aMap.setLocationSource(this);// 设置定位监听
        aMap.setMyLocationEnabled(true);
        aMap.setOnMarkerClickListener(this);
        aMap.setInfoWindowAdapter(this);// 设置自定义InfoWindow样式
        initLocation();
        onTouchHide();
    }


    private void setMyLocationStyleIcon() {
//		 自定义系统定位小蓝点

        MyLocationStyle myLocationStyle = new MyLocationStyle();
        ImageView iv = new ImageView(this);
        FrameLayout.LayoutParams fmIv = new FrameLayout.LayoutParams(1, 1);
        iv.setImageResource(R.mipmap.my_dog);
        iv.setLayoutParams(fmIv);
        BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromView(iv);
        myLocationStyle.myLocationIcon(markerIcon);// 设置小蓝点的图标
        myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));// 设置圆形的边框颜色
        myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色
        myLocationStyle.strokeWidth(0f);// 设置圆形的边框粗细
        myLocationStyle.anchor(0.5f, 0.9f);
        aMap.setMyLocationStyle(myLocationStyle);
    }


    private void initLocation() {

        locationClient = new AMapLocationClient(getApplicationContext());
        locationOption = new AMapLocationClientOption();

        // 设置定位模式为高精度模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        locationOption.setNeedAddress(true);
        // 设置定位监听
        locationClient.setLocationListener(this);
        //每两秒定位一次
        locationOption.setInterval(2000);
        locationOption.setOnceLocation(true);
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();

    }



    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mLocationLinstener = onLocationChangedListener;
    }

    @Override
    public void deactivate() {
        mLocationLinstener = null;
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation != null
                    && aMapLocation.getErrorCode() == 0) {

                if (mLocationLinstener != null) {
                    mLocationLinstener.onLocationChanged(aMapLocation);// 显示系统小蓝点
                }
                mLocatinLat = aMapLocation.getLatitude();
                mLocationLon = aMapLocation.getLongitude();

                setMyStopLoca(new LatLng(mLocatinLat, mLocationLon));
                setAroundMark(new LatLng(mLocatinLat, mLocationLon));
                setPlaceMark(new LatLng(mLocatinLat, mLocationLon));

            }
        } else {
            //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
//            LogUtil.d("location Error, ErrCode:"
//                    + aMapLocation.getErrorCode() + ", errInfo:"
//                    + aMapLocation.getErrorInfo());
        }
    }
    private void setMyStopLoca(final LatLng latlng) {
        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 17f));

        if(mMarkMyLocation!=null){
            mMarkMyLocation.destroy();
            mMarkMyLocation = null;
        }


        if (mMarkMyLocation == null) {
            final MarkerOptions markerOptions = new MarkerOptions();
            //markerOptions.snippet(dogId);
            // 设置Marker点击之后显示的标题
            markerOptions.setFlat(false);
            markerOptions.anchor(0.5f, 0.7f);
            markerOptions.zIndex(25);
            markerOptions.zIndex(90);
            MyLocationMarkerView myLocationMarkerView = new MyLocationMarkerView(MarkerActivity.this,getmAdaptationClass());
            myLocationMarkerView.setmCirHead(R.mipmap.my_dog_test);

            BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromView(myLocationMarkerView);

            markerOptions.icon(markerIcon);
            markerOptions.position(latlng);
            mMarkMyLocation = aMap.addMarker(markerOptions);

        }else {
            mMarkMyLocation.setPosition(latlng);
        }
    }


    private void setAroundMark( LatLng latlng){
        MarkerOptions markerOptions = new MarkerOptions();
        //markerOptions.snippet(dogId);
        // 设置Marker点击之后显示的标题
        markerOptions.setFlat(false);
        markerOptions.anchor(0.5f, 0.7f);
        markerOptions.zIndex(25);
        markerOptions.zIndex(90);
        markerOptions.title("other");
        markerOptions.snippet("man");
        OtherDogMarkerView manMarker = new OtherDogMarkerView(MarkerActivity.this,getmAdaptationClass());
        manMarker.setmCirHead(R.mipmap.test_man);
        manMarker.setGender("M");

        BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromView(manMarker);

        markerOptions.icon(markerIcon);
        markerOptions.position(new LatLng(latlng.latitude+0.002,latlng.longitude+0.002));
        aMap.addMarker(markerOptions);


        MarkerOptions markerOptionsWoman = new MarkerOptions();
        //markerOptions.snippet(dogId);
        // 设置Marker点击之后显示的标题
        markerOptionsWoman.setFlat(false);
        markerOptionsWoman.anchor(0.5f, 0.7f);
        markerOptionsWoman.zIndex(25);
        markerOptionsWoman.zIndex(90);
        markerOptionsWoman.title("other");
        markerOptionsWoman.snippet("woman");
        OtherDogMarkerView manMarkerWoman = new OtherDogMarkerView(MarkerActivity.this,getmAdaptationClass());
        manMarkerWoman.setmCirHead(R.mipmap.test_woman);
        manMarkerWoman.setGender("woman");

        BitmapDescriptor markerIconWoman = BitmapDescriptorFactory.fromView(manMarkerWoman);

        markerOptionsWoman.icon(markerIconWoman);
        markerOptionsWoman.position(new LatLng(latlng.latitude-0.002,latlng.longitude-0.002));
        aMap.addMarker(markerOptionsWoman);
    }


    private void setPlaceMark(LatLng latLng){
        MarkerOptions markerOptions = new MarkerOptions();
        // 设置Marker点击之后显示的标题
        markerOptions.setFlat(true);
        markerOptions.anchor(0.5f, 0.5f);
        markerOptions.zIndex(10);
        //必须有title才可以显示infowindow
        markerOptions.title("palce_detail");
//        markerOptions.snippet(placeList.get(j).getId());
        markerOptions.position(new LatLng(latLng.latitude-0.002,latLng.longitude+0.001));




        markerOptions.setInfoWindowOffset(getZoom((int) (200)),getZoom((int) (828 / 1.44)));


        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout llTiTrans = new LinearLayout(this);
        llTiTrans.setBackgroundResource(R.mipmap.dog_park_logo_title_bg);
        llTiTrans.setVisibility(View.INVISIBLE);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.dog_park_logo);
        LinearLayout llTitle = new LinearLayout(this);
        llTitle.setOrientation(LinearLayout.HORIZONTAL);
        llTitle.setBackgroundResource(R.mipmap.dog_park_logo_title_bg);
        TextView textView = new TextView(this);
        textView.setText("12");
        textView.setTextColor(getResources().getColor(R.color.main_font_green));
//        if(Integer.valueOf(placeList.get(j).getUser_count()).intValue()==0){
//            llTiTrans.setVisibility(View.GONE);
//            llTitle.setVisibility(View.GONE);
//        }
        //适配title
        LinearLayout.LayoutParams llParat = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        llParat.rightMargin = getZoom(10);
        llTiTrans.setLayoutParams(llParat);



        ImageView IvTitle = new ImageView(this);
        IvTitle.setImageResource(R.mipmap.dog_park_logo_title);
        //适配title
        LinearLayout.LayoutParams llPara = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        llPara.leftMargin = getZoom(10);
        llTitle.setLayoutParams(llPara);

        //适配title图片
        LinearLayout.LayoutParams ivPara = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        ivPara.gravity = Gravity.CENTER_VERTICAL;
        ivPara.leftMargin = getZoom(20);
        IvTitle.setLayoutParams(ivPara);

        //适配文字
        LinearLayout.LayoutParams tvPara = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tvPara.gravity = Gravity.CENTER_VERTICAL;
        tvPara.leftMargin = getZoom(10);
        textView.setLayoutParams(tvPara);


        llTitle.addView(IvTitle);
        llTitle.addView(textView);
        linearLayout.addView(llTiTrans);
        linearLayout.addView(imageView);
        linearLayout.addView(llTitle);

        BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromView(linearLayout);

        markerOptions.icon(markerIcon);

        Marker marker = null;

        aMap.addMarker(markerOptions);


        setCircle(new LatLng(latLng.latitude-0.002,latLng.longitude+0.001));

    }

    private double mTestMarkerLa;
    private double mTestMarkerLo;
    private int mTestX;
    private int mTestY;
    @Override
    public boolean onMarkerClick(final Marker marker) {


        if (currentMarker != null) {
            currentMarker.hideInfoWindow();
            currentMarker = null;
        }
        //新建currentMarker保存状态，当点击非mark区域的时候将marker的InfoWindow隐藏
        currentMarker = marker;





        if (marker.getTitle().equals("palce_detail")) {
//            mTvChange = false;
//
//            pdMarker = new MyProgressDialog(this);
//            pdMarker.show();


            marker.setRotateAngle(360-aMap.getCameraPosition().bearing);



            mTestMarkerLa = marker.getPosition().latitude;
            mTestMarkerLo = marker.getPosition().longitude;
//            mPlaceDetailId = myMarker.getPlaceId();
            LatLng latLng = new LatLng(mTestMarkerLa - ((double) getZoom((int) (2014 / 1.44)) / 1000000), mTestMarkerLo + ((double) getZoom((int) (1096)) / 1000000));
//                PlaceDetailDialogFragment dogParkMessageDialogFragment = PlaceDetailDialogFragment.newInstance();
//                dogParkMessageDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.place_dialog_fragment);
//                dogParkMessageDialogFragment.show(getSupportFragmentManager(), "finish_notice");
//                if (mTvChange) {
//                    Camera3D();
//                } else {
//                    Camera2D();
//                }


            Point point = aMap.getProjection().toScreenLocation(marker.getPosition());
            mTestX = point.x;
            mTestY = point.y;
//                mTestMarker = marker;
            CameraUpdate update1 = CameraUpdateFactory.scrollBy(mTestX -getZoom(170), mTestY- getZoom(300));
//                marker.showInfoWindow();
            aMap.animateCamera(update1, 1000, new AMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    //aMap.setOnCameraChangeListener(AmapActivity.this);
                    marker.showInfoWindow();
//                    requestPlaceDetail();
                    placeDetailInfowindow.showInfowindow();

                }

                @Override
                public void onCancel() {
                    marker.showInfoWindow();
//                    requestPlaceDetail();
                    placeDetailInfowindow.showInfowindow();
                }
            });
            return true;
        }

        if (marker.getTitle().equals("other")) {
            marker.showInfoWindow();
            mLlother.setBackgroundResource(R.drawable.infowinow_background);
            return true;
        }
        return false;

    }

    private TextView mTvDogBreed;
    private TextView mTvDogAge;
    private TextView mTvDogName;
    private LinearLayout mLlother;


    @Override
    public View getInfoWindow(Marker marker) {
        if (marker.getTitle().equals("palce_detail")) {
            infoWindow = getLayoutInflater().inflate(
                    R.layout.info_window_place, null);
            LinearLayout main = (LinearLayout) infoWindow.findViewById(R.id.info_window_place_main);


            if(placeDetailInfowindow!=null){
                main.removeView(placeDetailInfowindow);
                placeDetailInfowindow = null;
            }
            placeDetailInfowindow = new PlaceDetailInfowindow(this,getmAdaptationClass());
            main.addView(placeDetailInfowindow);

//            placeDetailInfowindow.showInfowindow();



            LinearLayout ivErr = (LinearLayout) placeDetailInfowindow.findViewById(R.id.ll_find_place_error);

            final Marker marker1 = marker;
            ImageView ivError = (ImageView) placeDetailInfowindow.findViewById(R.id.iv_error);




            return infoWindow;
        }

        if (marker.getTitle().equals("other")) {

            infoWindow = getLayoutInflater().inflate(
                    R.layout.infowindow_other, null
            );


            mLlother = (LinearLayout) infoWindow.findViewById(R.id.ll_info_other);

            mTvDogName = (TextView) infoWindow.findViewById(R.id.dog_name);

            mTvDogName.setTextColor(getResources().getColor(R.color.main_font_green));
            mTvDogBreed = (TextView) infoWindow.findViewById(R.id.dog_breed);
            mTvDogBreed.setTextColor(getResources().getColor(R.color.main_font_green));
            mTvDogAge = (TextView) infoWindow.findViewById(R.id.dog_age);
            mTvDogAge.setTextColor(getResources().getColor(R.color.main_font_green));

            if(marker.getSnippet().equals("man")){
                mTvDogName.setText("小基");
                mTvDogBreed.setText("公");
                mTvDogAge.setText("6个月");
            }else {
                mTvDogName.setText("小吉");
                mTvDogBreed.setText("母");
                mTvDogAge.setText("9个月");
            }


            return infoWindow;
        }


        return infoWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    private void onTouchHide(){
        aMap.setOnMapTouchListener(new AMap.OnMapTouchListener() {
            @Override
            public void onTouch(MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (currentMarker != null) {
                            currentMarker.hideInfoWindow();
                            currentMarker = null;

                        }
                        break;
                }
            }
        });
    }


    private void setCircle(LatLng latLng){
        Circle placeCircle = aMap.addCircle(new CircleOptions().center(latLng)
                .radius(100).strokeColor(getResources().getColor(R.color.trans_green))
                .fillColor(getResources().getColor(R.color.trans_green)).strokeWidth(0));
    }

}
