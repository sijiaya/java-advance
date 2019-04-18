package com.soft1841.thread.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * JSoup爬虫练习1
 * 爬取https://www.jianshu.com/的标题名称
 * 2019.4.18
 */
public class JSoupDemo1 {
    public static void main(String[] args) throws Exception {
        //1、指定目标页面链接
        String url = "https://www.jianshu.com/";
        //2、建立与目标页面的连接
        Connection connection = Jsoup.connect(url);
        //3、解析目标页面
        Document document = connection.get();
        //4、获取页面中所有的class为content的元素，本例在页面中可以检查元素，是div
        Elements elements  = document.getElementsByClass("content");
        //在页面上，符合上述class样式的div的个数
        System.out.println(elements.size());
        //对取出内容进行for-each遍历
        for (Element element:elements) {
            //取出div的子元素 div->a
            Element link = element.child(0);
            //得到a标记的文字的内容
            String titleString = link.text();
            System.out.println(titleString);
        }
    }
}
