package com.soft1841.util;

/**
 * 单例模式的测试程序
 */
public class SingletonTest {
    public static void main(String[] args) {
        //编译错误，因为构造方法是不可见的，只能在Singleton内部使用
//        Singleton object = new Singleton();


        //通过Singleton的勒方法Singleton.getInstance()获取唯一可用的对象
        Singleton object = Singleton.getInstance();
        //显示消息
        object.showMessage();
    }
}
