package com.yhy.ampoverlaydemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.yhy.ampoverlaydemo.R;


/**
 * Created by Administrator on 2016/1/14 0014.
 */
public class InforWindowTriangleView extends View {

    public InforWindowTriangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //重写OnDraw（）函数，在每次重绘时自主实现绘图
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);




        Paint paint=new Paint();
        paint.setColor(getResources().getColor(R.color.black_s));  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(5);//设置画笔宽度
//
//		canvas.drawLine(startX, stopX, startY, stopY, paint);
        //canvas.drawText("画三角形：", 10, 200, paint);
        // 绘制这个三角形,你可以绘制任意多边形
        Path path = new Path();

        path.moveTo(144, 0);// 此点为多边形的起点
        path.lineTo(100, 61);
        path.lineTo(70, 61);

//        path.moveTo(178, 409);// 此点为多边形的起点
//        path.lineTo(110, 472);
//        path.lineTo(141, 472);
//		path.moveTo(202, 200);// 此点为多边形的起点
//		path.lineTo(165, 261);
//		path.lineTo(130, 261);
//		path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, paint);

//		//设置画笔基本属性
//		Paint paint=new Paint();
//		paint.setAntiAlias(true);//抗锯齿功能
//		paint.setColor(Color.RED);  //设置画笔颜色
//		paint.setStyle(Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
//		paint.setStrokeWidth(5);//设置画笔宽度
//		paint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影
//
//		//设置画布背景颜色
//        canvas.drawRGB(255, 255,255);
//
//        //画圆
//        canvas.drawCircle(190, 200, 150, paint);




		//画圆角矩形
//		paint.setStyle(Paint.Style.FILL);//充满
//		paint.setColor(getResources().getColor(R.color.bg_color_black));
//		paint.setAntiAlias(true);// 设置画笔的锯齿效果
//		//canvas.drawText("画圆角矩形:", 10, 260, paint);
//		RectF oval3 = new RectF(15, 475, 705, 922);// 设置个新的长方形
//		canvas.drawRoundRect(oval3, 20, 15, paint);//第二个参数是x半径，第三个参数是y半径

    }
}
