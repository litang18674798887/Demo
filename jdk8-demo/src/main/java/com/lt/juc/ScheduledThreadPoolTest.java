package com.lt.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : litang
 * @date : Create in 2020/11/4
 * @Description
 */
public class ScheduledThreadPoolTest {


    public static void main(String[] args) {
        Executors.newFixedThreadPool(10);

        Lock lock = new ReentrantLock();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(50);

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        },1,TimeUnit.SECONDS);

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2222");
            }
        },1,TimeUnit.SECONDS);

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3333");
            }
        },1,TimeUnit.SECONDS);

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("444");
            }
        },1,TimeUnit.SECONDS);

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("555");
            }
        },3,TimeUnit.SECONDS);
    }
}
