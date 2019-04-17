package com.soft1841.thread.timer;


import javax.swing.*;
import java.io.*;

public class TextThread implements Runnable {
    private JLabel textLabel;

    public void setTextLabel(JLabel textLabel){
        this.textLabel = textLabel;
    }
    @Override
    public void run() {
        File file = new File("D:/人生.txt");
        InputStream inputStream = null;
        byte[] bytes = new byte[(int) file.length()];
        try {
            inputStream = new FileInputStream(file);
            inputStream.read(bytes);
        }catch (IOException e){
            System.out.println("IO异常");
        }
        textLabel.setText(new String(bytes));
    }
}
