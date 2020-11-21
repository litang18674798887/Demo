package com.lt;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : litang
 * @date : Create in 2020-02-28
 * @Description
 */
public class RunTimeTest  {


    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        //设置日期为27号
        calendar.set(Calendar.DAY_OF_MONTH, 28);
        //设置日期为11月份   这里10表示11月份    11就表示12月份
        calendar.set(Calendar.MONTH, 1);
        //设置15点的时候触发
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        //设置43分钟的时候触发
        calendar.set(Calendar.MINUTE, 48);
        //设置第一秒的时候触发
        calendar.set(Calendar.SECOND, 1);

        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println(2222);
                System.out.println("已经出发了");
                System.out.println(new Date());
            }
        }, 1000,5000);
        System.out.println(1111);
    }
}
