package com.soft1841.thread.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

/**
 * 爬取http://www.youzhan.org/页面的图片到本地D盘download目录，图片名UUID，后缀jpg
 */
public class JSoupDemo2 {
    public static void main(String[] args) throws Exception {
        File file;
        InputStream in;
        OutputStream out;
        //指定目标页面链接
        String url = "http://www.youzhan.org/";
        //建立与目标页面的连接
        Connection connection = Jsoup.connect(url);
        //解析目标页面
        Document document = connection.get();
        Element elementDiv =  document.getElementById("post-list");
        //获取页面中所有的class为的元素，本例在页面中可以检查元素，是div
        Elements elements = elementDiv.getElementsByClass("col-xs-12");
        //在页面上，符合上述class样式的div的个数
        System.out.println(elements.size());
        //对取出内容进行for-each遍历
        for (Element e:elements) {
            //取出div的子元素 div->article->h2->div->a
            Element imgElement = e.child(0).child(1).child(0).child(0);
            UUID uuid = UUID.randomUUID();
            String imgName = uuid + ".jpg";
            file = new File("D:\\download\\"+imgName);
            URL url1 = new URL(imgElement.attr("src"));
            URLConnection uc = url1.openConnection();
            in = uc.getInputStream();
            out = new FileOutputStream(file);
            int temp;
            byte[] buf = new byte[1024];
            while ((temp = in.read(buf)) != -1){
                out.write(buf,0,temp);
            }
            out.close();
            in.close();
        }
    }
}
