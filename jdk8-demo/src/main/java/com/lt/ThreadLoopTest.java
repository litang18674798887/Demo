package com.lt;

import lombok.SneakyThrows;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : litang
 * @date : Create in 2020/8/26
 * @Description
 */
public class ThreadLoopTest {




    public static void main(String[] args) {

        //循环次数
         final int maxNum = 10;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition aCondition = reentrantLock.newCondition();
        Condition bCondition = reentrantLock.newCondition();
        Condition cCondition = reentrantLock.newCondition();

        final String[] currentThread = { "A" };
        Thread a = new Thread(() -> {
            for (int i = 0; i < maxNum; i++) {

                reentrantLock.lock();
                try {
                    while (currentThread[0] != "A") {
                        aCondition.await();
                    }
                    System.out.println("A");
                    currentThread[0] = "B";
                    bCondition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < maxNum; i++) {

                reentrantLock.lock();
                try {
                    while (currentThread[0] != "B") {
                        bCondition.await();
                    }
                    System.out.println("B");
                    currentThread[0] = "C";
                    cCondition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
        });


        Thread c = new Thread(() -> {
            for (int i = 0; i < maxNum; i++) {

                reentrantLock.lock();
                try {
                    while (currentThread[0] != "C") {
                        cCondition.await();
                    }
                    System.out.println("C");
                    System.out.println("-------");
                    currentThread[0] = "A";
                    aCondition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
        });

        a.start();;
        b.start();
        c.start();

    }
}
