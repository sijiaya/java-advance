package util;


/**
 * 数学类
 * 2019.3.12
 */
public class MathDemo {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(Math.sqrt(num));
        //表示保留几位小数: %.nf
        System.out.printf("%.2f",Math.sqrt(num));
    }
}
