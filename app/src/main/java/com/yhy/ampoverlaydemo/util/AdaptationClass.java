package com.yhy.ampoverlaydemo.util;


/**
 * Title:适配工具类
 * Description:用来适配手机分辨率的工具类,单例
 * Company:沈阳分分钟科技有限公司
 * @author 刘艺龙
 * @create date 20140711
 */
public class AdaptationClass {
	
	public final static float FINAL_WIDTH = 750;  //手机的基准宽度
	public final static float FINAL_HEIGHT = 1134;  //手机的基准高度
	
	float Coefficient_X;    //宽度比率
	
	float width;   //当前手机的宽度
	float height;  //当前手机的高度
	float density; //当前手机的密度
	
//	private static AdaptationClass mAdaptationClass;
//	
//	public static AdaptationClass  getInstance(Activity activity){
//		if(mAdaptationClass == null){
//			  final DisplayMetrics displayMetrics = new DisplayMetrics();
//		        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//		        final int height = displayMetrics.heightPixels;
//		        final int width = displayMetrics.widthPixels;
//		        final int density = displayMetrics.densityDpi;
//			    mAdaptationClass = new AdaptationClass(width, height, density);
//		}
//		return mAdaptationClass;
//	}

	public AdaptationClass(float width, float height, float density) {
		this.Coefficient_X = width / FINAL_WIDTH;
		this.width = width;
		this.height = height;
		this.density = density;
	}
	
 
	public float getCurWidth(){
		return width;
	}
	public float getCurHeight(){
		return height;
	}
	public float getCurDensity(){
		return density;
	}
	//按比例缩放长度
	public int getZoomX(int x) { 
		return Math.round(Coefficient_X * x);
	}
 
	//当给定宽带大于屏幕的宽度时才缩放，否则不做任何处理
	public int getSafeZoomX(int x){
		return (x>width)? Math.round(Coefficient_X * x):x;
	}

	//获取涂鸦的基准大小
	public int getBaseGraffitoSize(){
//		return  Math.min(300,(int)(0.46875* width));//贴图最大300
        return (int)(0.46875* width);
	}

	//获取涂鸦的基准大小
	public int getBaseGraffitoSize(int length){
//		return  Math.min(300,(int)(0.46875* width));//贴图最大300
		return (int)(0.46875* length);
	}

    public int getTargetSize(){
//		return  Math.min(300,(int)(0.46875* width));//贴图最大300
        return 300;
    }
}
