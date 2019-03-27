package com.soft1841.util;


/**
 * integer类的练习:比较数值的大小与进制转换
 * @author sijia
 * 2019.3.12
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //将字符串转换为int类型
        int num = 31;
        Integer iNum = Integer.valueOf("31");
        System.out.println("int数据与Integer对象的比较：" + iNum.equals(num));
        String str2 = Integer.toBinaryString(num);
        String str3 = Integer.toHexString(num);
        String str4 = Integer.toOctalString(num);
        //获取数字的15进制表示
        String str5 = Integer.toString(num,15);
        System.out.println("31的二进制表示：" + str2);
        System.out.println("31的十六进制表示：" + str3);
        System.out.println("31的八进制表示：" + str4);
        System.out.println("31的十五进制表示：" + str5);
        System.out.println("—————分割线—————");
        System.out.println("转为五进制：" + convert(num,15));
    }
    public static String convert(int num, int radix){
        StringBuffer stringBuffer = new StringBuffer();
        //被除数不为0就循环
        while (num!=0){
            //求出余数
            int remainder = num  % radix;
            //将余数加入到StringBuffer
            stringBuffer.append(String.valueOf(remainder));
            //更新被除数为商
            num = num/radix;
        }
        //将结果取反后返回
        return stringBuffer.reverse().toString();
    }
}
