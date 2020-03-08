package com.springboot.utils.datetool;

import java.text.SimpleDateFormat;
import java.util.Date;

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

   /* public static void main(String[] args) {

        System.out.println(getCurrentTime());// new Date()为获取当前系统时间
    }*/
}
