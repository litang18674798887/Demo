package com.lt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : litang
 * @date : Create in 2020/7/28
 * @Description
 */
public class ImageTest {


    public static void main(String[] args) throws Exception {


        System.out.println(System.currentTimeMillis());

        /*File picture = new File("/Users/litang/Desktop/商品副标题-图片修改/果标轮播/果标轮播-B级.png");
        BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
        System.out.println(picture.length());// 源图大小
        System.out.println(sourceImg.getWidth()); // 源图宽度
        System.out.println(sourceImg.getHeight()); // 源高度*/

       /* DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        LocalDateTime localDateTime = LocalDateTime.now().plusHours(1000);
        String localTime = df.format(localDateTime);
        System.out.println(localTime);

        LocalDateTime ldt = LocalDateTime.parse("2020-12-25 00:00:00",df);

        long l = Duration.between(LocalDateTime.now(),ldt).toHours();
        System.out.println(l);*/

        System.out.println("hello");
//        Thread.sleep(Integer.MAX_VALUE);
    }
}