package com.soft1841.thread;

/**
 * 售票线程程序3
 * 实现Runnable接口并同步线程，只有一个窗口在卖票（加锁）
 * 加锁可以加在代码块上，也可以加在方法上
 */
public class TicketThreadTest3 {
    public static void main(String[] args) {
        TicketThread3 tt = new TicketThread3();
        Thread thread1 = new Thread(tt,"南工院");
        thread1.start();
        Thread thread2 = new Thread(tt,"南信院");
        thread2.start();
        Thread thread3 = new Thread(tt,"南大");
        thread3.start();
    }
}

class TicketThread3 implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        //永真循环
        while (true) {
            //同步售票代码块,也就是线程加锁
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，当前票数为：" + --tickets);
                } else {
                    break;
                }
            }
        }
    }
}