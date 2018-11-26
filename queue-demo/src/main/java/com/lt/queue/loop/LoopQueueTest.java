package com.lt.queue.loop;

/**
 * @author : litang
 * @date : Create in 2018/11/26
 */
public class LoopQueueTest {

    /**
     * 环形队列
     * @param args
     */
    public static void main(String[] args) {
        CircularBlockingQueue<String> queue = new CircularBlockingQueue<String>();

        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        queue.add("6");

        String next1 = queue.next();
        String next2 = queue.next();
        String next3 = queue.next();
        String next4 = queue.next();
        String next5 = queue.next();
        String next6 = queue.next();
        String next7 = queue.next();
        String next8 = queue.next();
        String next9 = queue.next();
        String next10 = queue.next();
        String next11 = queue.next();
        System.out.println(next1);
        System.out.println(next2);
        System.out.println(next3);
        System.out.println(next4);
        System.out.println(next5);
        System.out.println(next6);
        System.out.println(next7);
        System.out.println(next8);
        System.out.println(next9);
        System.out.println(next10);
        System.out.println(next11);

        queue.add("7");
        String next12 = queue.next();
        System.out.println(next12);

        String next13 = queue.next();
        System.out.println(next13 );


    }


}
