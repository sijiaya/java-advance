package com.soft1841.thread.timer;

/**
 * 乌龟
 */
public class Tortoise implements Runnable{
    @Override
    public void run() {
        for (int i = 1;i<=10;i++){
            try {
                //线程休眠一秒
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //显示乌龟的跑步距离
            System.out.println("乌龟跑了"+i*10+"米");
            if (i==10){
                System.out.println("乌龟到达终点");
            }
        }
    }
}
