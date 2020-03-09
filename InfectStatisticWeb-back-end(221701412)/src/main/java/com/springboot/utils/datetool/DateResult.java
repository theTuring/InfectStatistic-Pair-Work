package com.springboot.utils.datetool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * DateResult
 * TODO
 * @description 返回日期结果的工具类
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since
 */
public class DateResult {

    //获取当前时间
    public String getCurrentTime(){

        SimpleDateFormat ct = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(ct.format(new Date()));// new Date()为获取当前系统时间
        return ct.format(new Date());

    }

    public  Date moveTime(Date date, int day){
        Calendar calendar   =   new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();   //这个时间就是日期往后推一天的结果
    }

//    public static void main(String[] args) {
//
//        System.out.println(moveTime(new Date(),-1));// new Date()为获取当前系统时间
//    }
}
