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
 * @since 2020.3.10
 */
public class DateResult {

    //获取当前时间
    public String getCurrentTime(){

        SimpleDateFormat ct = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(ct.format(new Date()));// new Date()为获取当前系统时间
        return ct.format(new Date());

    }

    //获取两日期差的天数
    public int getBetweenDay(Date date1, Date date2) {
        Calendar d1 = new GregorianCalendar();
        d1.setTime(date1);
        Calendar d2 = new GregorianCalendar();
        d2.setTime(date2);
        int days = d2.get(Calendar.DAY_OF_YEAR)- d1.get(Calendar.DAY_OF_YEAR);
        System.out.println("days="+days);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
//			d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    public Date moveTime(Date date, int day){
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
