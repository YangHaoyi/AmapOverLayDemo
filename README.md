# AmapOverLayDemo
高德地图覆盖物完全解析

由于项目要求，对地图覆盖物需求点击，所以选择marker作为覆盖物主题

起初也为marker要满足设计复杂的图形而苦恼，直到发现sdk中的这个接口
 
 BitmapDescriptor markerIconWoman = BitmapDescriptorFactory.fromView(manMarkerWoman);
 
 也就是说我们可以通过view来自定义任意的图形来给marker赋值而非用bitmap自己组合
 
 对于marker点击，infowindow的样式也是可以自行定制的
 
 通过
 
         aMap.setInfoWindowAdapter(this);// 设置自定义InfoWindow样式
         
  marker点击默认是将marker设置屏幕居中，这时候只需将onMarkerClick的返回值设置为true即可
  
  这样marker就会保持原位。
  
  点击marker，如果需要infowindow保持不在屏幕外，需要通过aMap move camera实现
  
  ![image](https://github.com/qweyhy/AmpOverLayDemo/blob/master/screenshot/screenshot_1.jpg)
   ![image](https://github.com/qweyhy/AmpOverLayDemo/blob/master/screenshot/screenshot_2.jpg)
    ![image](https://github.com/qweyhy/AmpOverLayDemo/blob/master/screenshot/screenshot_3.jpg)
  
  
  

 
