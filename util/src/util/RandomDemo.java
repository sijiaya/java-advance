package util;

import java.util.Random;

/**
 * Random类提供了生成各种数据类型随机数的方法
 * 2019.3.12
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        //nextInt里的范围是[0,bound)
        int num = random.nextInt(6);
        System.out.println(num);
    }
}
