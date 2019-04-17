package com.soft1841.thread.timer;

/**
 * 龟兔赛跑
 */
public class RaceTest {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        Thread rabbitThread = new Thread(rabbit);
        Thread tortoiseThread = new Thread(tortoise);
        //兔子加入到乌龟线程中
        rabbit.setTortoiseThread(tortoiseThread);
        rabbitThread.start();
        tortoiseThread.start();
    }
}
