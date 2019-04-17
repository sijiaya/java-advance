package com.soft1841.thread.timer;

public class Rabbit implements Runnable {
    private Thread tortoiseThread;

    //在兔子中加入创建乌龟线程
    public void setTortoiseThread(Thread tortoiseThread){

        this.tortoiseThread = tortoiseThread;
    }
    @Override
    public void run() {
        //循环10次模拟赛跑的过程
        for(int i = 1;i<=10;i++){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("兔子跑了"+i*10+"米");

            if (i == 7){
                System.out.println("兔子开始睡觉");
                try {
                    //乌龟线程加入，兔子休息
                    tortoiseThread.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            if (i == 10){
                //显示兔子到达了终点
                System.out.println("兔子到达终点");
            }
        }
    }
}
