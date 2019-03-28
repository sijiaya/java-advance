package com.soft1841.swing;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        //创建Calendar对象
        Calendar calendar = Calendar.getInstance();
        //获取年
        int year = calendar.get(Calendar.YEAR);
        //获取月，0表示1月
        int month = calendar.get(Calendar.MONTH) + 1;
        //获取日期、时间、分钟、秒
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println("当前时间：" +year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);

        //将Calendar对象转换为Date对象
        Date date = calendar.getTime();
        //获取当前毫秒数
        Long time = calendar.getTimeInMillis();
        System.out.println("当前时间："+date);
        System.out.println("当前毫秒数："+time);
    }
}
