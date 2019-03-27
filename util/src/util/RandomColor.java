package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 随机颜色练习
 * 2019.03.12
 */
public class RandomColor {
    public static void main(String[] args) throws IOException {
        int width = 200;
        int height = 60;
        //开始用随即色值绘制图片
        //在图片缓冲区生成一个图片对象
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Random random = new Random();
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        g.fillRect(0,0,width,height);

        //画干扰线
        for (int i = 0; i < 20; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(color);
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        //生成字母与数字验证码
        String verifyCode = "";//定义字符串变量最后保存生成的验证码
        char c;//定义字符类型保存验证码
        //产生验证码
        for (int i = 1; i<= 4;i++){
            int number = random.nextInt(26);
            if (number % 2 ==0){
                //如果生成的随机数是偶数则生成数字
                c = (char) ('0' + (char) ((int)(Math.random() * 10)));
            }else{
                //否则生成字母
                c = (char) ((char) ((int) (Math.random() * 26)) + 'A');
            }
            //保存验证码
            verifyCode = verifyCode +c;
        }
        //生成redRandom
        //生成greenRandom
        //生成blueRandom
        int redRandom = random.nextInt(256);
        int greenRandom = random.nextInt(256);
        int blueRandom = random.nextInt(256);
        System.out.println("R:  " + redRandom + "   G:  " + greenRandom + "  B:  " + blueRandom);

        //设置图片外边框
        g.setColor(Color.GRAY);
        g.drawRect(0,0,width-1,height-1);
        //设置字体
        Font font = new Font("微软雅黑",Font.BOLD,16);
        g.setFont(font);
        //设置画笔颜色,使用随机生成的颜色
        Color color = new Color(redRandom,greenRandom,blueRandom);
        g.setColor(color);
        //绘制文字
        g.setColor(Color.BLACK);
        g.drawString(verifyCode,40,20);
        //输出图片,本地文件的路径
        File file = new File("D:/code.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流写出到文件
        ImageIO.write(bufferedImage,"jpg", outputStream);
        //关闭输出流
        outputStream.close();
    }
}