package com.yhy.ampoverlaydemo.util;

import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by StevenRogers on 2016/3/15.
 */
public class MyLayoutParas {

    public static int GRAVITY_DEFAULT = 0;
    public static int GRAVITY_CENTER = 1;
    public static int GRAVITY_LEFT = 2;
    public static int GRAVITY_TOP = 3;
    public static int GRAVITY_RIGHT = 4;
    public static int GRAVITY_BOTTOM = 5;
    public static int GRAVITY_CENTER_VERTICAL = 6;
    public static int GRAVITY_CENTER_HORIZONTAL = 7;
    public static int GRAVITY_LEFT_TOP = 8;
    public static int GRAVITY_LEFT_BOTTOM = 9;
    public static int GRAVITY_LEFT_VERTICAL = 10;
    public static int GRAVITY_LEFT_HORIZONTAL = 11;
    public static int GRAVITY_RIGHT_TOP = 12;
    public static int GRAVITY_RIGHT_BOTTOM = 13;
    public static int GRAVITY_RIGHT_VERTICAL = 14;
    public static int GRAVITY_RIGHT_HORIZONTAL = 15;
    public static int GRAVITY_TOP_VERTICAL = 16;
    public static int GRAVITY_TOP_HORIZONTAL = 17;
    public static int GRAVITY_BOTTOM_VERTICAL = 18;
    public static int GRAVITY_BOTTOM_HORIZONTAL = 19;

    public static int MATCH_PARENT = -1;
    public static int WRAP_CONTENT = -2;




    public static void myFmConfig(View view, AdaptationClass adaptationClass, int width, int height, int gravity, int marginLeft, int marginTop, int marginRight, int marginBottom){

        FrameLayout.LayoutParams fmConfig;
        int adaptw;
        int adapth;
        if(width<0){
            adaptw = width;
        }else {
            adaptw = adaptationClass.getZoomX(width);
        }
        if(height<0){
            adapth = height;
        }else {
            adapth = adaptationClass.getZoomX(height);
        }

        fmConfig = new FrameLayout.LayoutParams(adaptw,
                    adapth);
        fmConfig.leftMargin = adaptationClass.getZoomX(marginLeft);
        fmConfig.topMargin = adaptationClass.getZoomX(marginTop);
        fmConfig.rightMargin = adaptationClass.getZoomX(marginRight);
        fmConfig.bottomMargin = adaptationClass.getZoomX(marginBottom);
        switch (gravity){
            case 1:
                fmConfig.gravity = Gravity.CENTER;
                break;
            case 2:
                fmConfig.gravity = Gravity.LEFT;
                break;
            case 3:
                fmConfig.gravity = Gravity.TOP;
                break;
            case 4:
                fmConfig.gravity = Gravity.RIGHT;
                break;
            case 5:
                fmConfig.gravity = Gravity.BOTTOM;
                break;
            case 6:
                fmConfig.gravity = Gravity.CENTER_VERTICAL;
                break;
            case 7:
                fmConfig.gravity = Gravity.CENTER_HORIZONTAL;
                break;
            case 8:
                fmConfig.gravity = Gravity.LEFT| Gravity.TOP;
                break;
            case 9:
                fmConfig.gravity = Gravity.LEFT| Gravity.BOTTOM;
                break;
            case 10:
                fmConfig.gravity = Gravity.LEFT| Gravity.CENTER_VERTICAL;
                break;
            case 11:
                fmConfig.gravity = Gravity.LEFT| Gravity.CENTER_HORIZONTAL;
                break;
            case 12:
                fmConfig.gravity = Gravity.RIGHT| Gravity.TOP;
                break;
            case 13:
                fmConfig.gravity = Gravity.RIGHT| Gravity.BOTTOM;
                break;
            case 14:
                fmConfig.gravity = Gravity.RIGHT| Gravity.CENTER_VERTICAL;
                break;
            case 15:
                fmConfig.gravity = Gravity.RIGHT| Gravity.CENTER_HORIZONTAL;
                break;
            case 16:
                fmConfig.gravity = Gravity.TOP| Gravity.CENTER_VERTICAL;
                break;
            case 17:
                fmConfig.gravity = Gravity.TOP| Gravity.CENTER_HORIZONTAL;
                break;
            case 18:
                fmConfig.gravity = Gravity.BOTTOM| Gravity.CENTER_VERTICAL;
                break;
            case 19:
                fmConfig.gravity = Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL;
                break;
        }
        view.setLayoutParams(fmConfig);
//        return  fmConfig;
    }

    public static void myLnConfig(View view, AdaptationClass adaptationClass, int width, int height, int gravity, int marginLeft, int marginTop, int marginRight, int marginBottom){

        LinearLayout.LayoutParams lnConfig;


        int adaptw;
        int adapth;
        if(width<0){
            adaptw = width;
        }else {
            adaptw = adaptationClass.getZoomX(width);
        }
        if(height<0){
            adapth = height;
        }else {
            adapth = adaptationClass.getZoomX(height);
        }

        lnConfig = new LinearLayout.LayoutParams(adaptw,
                adapth);


        lnConfig.leftMargin = adaptationClass.getZoomX(marginLeft);
        lnConfig.topMargin = adaptationClass.getZoomX(marginTop);
        lnConfig.rightMargin = adaptationClass.getZoomX(marginRight);
        lnConfig.bottomMargin = adaptationClass.getZoomX(marginBottom);
        switch (gravity){
            case 1:
                lnConfig.gravity = Gravity.CENTER;
                break;
            case 2:
                lnConfig.gravity = Gravity.LEFT;
                break;
            case 3:
                lnConfig.gravity = Gravity.TOP;
                break;
            case 4:
                lnConfig.gravity = Gravity.RIGHT;
                break;
            case 5:
                lnConfig.gravity = Gravity.BOTTOM;
                break;
            case 6:
                lnConfig.gravity = Gravity.CENTER_VERTICAL;
                break;
            case 7:
                lnConfig.gravity = Gravity.CENTER_HORIZONTAL;
                break;
            case 8:
                lnConfig.gravity = Gravity.LEFT| Gravity.TOP;
                break;
            case 9:
                lnConfig.gravity = Gravity.LEFT| Gravity.BOTTOM;
                break;
            case 10:
                lnConfig.gravity = Gravity.LEFT| Gravity.CENTER_VERTICAL;
                break;
            case 11:
                lnConfig.gravity = Gravity.LEFT| Gravity.CENTER_HORIZONTAL;
                break;
            case 12:
                lnConfig.gravity = Gravity.RIGHT| Gravity.TOP;
                break;
            case 13:
                lnConfig.gravity = Gravity.RIGHT| Gravity.BOTTOM;
                break;
            case 14:
                lnConfig.gravity = Gravity.RIGHT| Gravity.CENTER_VERTICAL;
                break;
            case 15:
                lnConfig.gravity = Gravity.RIGHT| Gravity.CENTER_HORIZONTAL;
                break;
            case 16:
                lnConfig.gravity = Gravity.TOP| Gravity.CENTER_VERTICAL;
                break;
            case 17:
                lnConfig.gravity = Gravity.TOP| Gravity.CENTER_HORIZONTAL;
                break;
            case 18:
                lnConfig.gravity = Gravity.BOTTOM| Gravity.CENTER_VERTICAL;
                break;
            case 19:
                lnConfig.gravity = Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL;
                break;
        }
        view.setLayoutParams(lnConfig);
    }

    public static void myRlConfig(View view, AdaptationClass adaptationClass, int width, int height, int gravity, int marginLeft, int marginTop, int marginRight, int marginBottom){

        RelativeLayout.LayoutParams rlConfig;
        int adaptw;
        int adapth;
        if(width<0){
            adaptw = width;
        }else {
            adaptw = adaptationClass.getZoomX(width);
        }
        if(height<0){
            adapth = height;
        }else {
            adapth = adaptationClass.getZoomX(height);
        }

        rlConfig = new RelativeLayout.LayoutParams(adaptw,
                adapth);


//        RelativeLayout.LayoutParams rlConfig = new RelativeLayout.LayoutParams(adaptationClass.getZoomX(width),
//                adaptationClass.getZoomX(height));
        rlConfig.leftMargin = adaptationClass.getZoomX(marginLeft);
        rlConfig.topMargin = adaptationClass.getZoomX(marginTop);
        rlConfig.rightMargin = adaptationClass.getZoomX(marginRight);
        rlConfig.bottomMargin = adaptationClass.getZoomX(marginBottom);
        switch (gravity){
            case 1:
                rlConfig.addRule(RelativeLayout.CENTER_IN_PARENT);
                break;
            case 2:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                break;
            case 3:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                break;
            case 4:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                break;
            case 5:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                break;
            case 6:
                rlConfig.addRule(RelativeLayout.CENTER_VERTICAL);
                break;
            case 7:
                rlConfig.addRule(RelativeLayout.CENTER_HORIZONTAL);
                break;
            case 8:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                break;
            case 9:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                break;
            case 10:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                rlConfig.addRule(RelativeLayout.CENTER_VERTICAL);
                break;
            case 11:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                rlConfig.addRule(RelativeLayout.CENTER_HORIZONTAL);
                break;
            case 12:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                break;
            case 13:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                break;
            case 14:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                rlConfig.addRule(RelativeLayout.CENTER_VERTICAL);
                break;
            case 15:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                rlConfig.addRule(RelativeLayout.CENTER_HORIZONTAL);
                break;
            case 16:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                rlConfig.addRule(RelativeLayout.CENTER_VERTICAL);
                break;
            case 17:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                rlConfig.addRule(RelativeLayout.CENTER_HORIZONTAL);
                break;
            case 18:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                rlConfig.addRule(RelativeLayout.CENTER_VERTICAL);
                break;
            case 19:
                rlConfig.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                rlConfig.addRule(RelativeLayout.CENTER_HORIZONTAL);
                break;
        }
        view.setLayoutParams(rlConfig);
    }

}
