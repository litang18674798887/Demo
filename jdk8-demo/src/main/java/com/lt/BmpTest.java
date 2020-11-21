package com.lt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author : litang
 * @date : Create in 2020/5/14
 * @Description
 */
public class BmpTest {

    public static void main(String[] args) {

        String a = "18674798887";
        String substring = a.substring(10, 11);
        System.out.println(substring);


       /* try {
            BufferedImage src = ImageIO.read(new File("/Users/litang/Desktop/1225.bmp")); // 读入源图像
            int width = src.getWidth(); // 源图宽
            int height = src.getHeight(); // 源图高

            Image image = src.getScaledInstance((int) (width), (int) (height),
                    Image.SCALE_DEFAULT);

            BufferedImage tag = new BufferedImage((int) (width),
                    (int) (height), BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g = tag.createGraphics();

            g.drawImage(image, 0, 0, null);

            g.dispose();

            OutputStream out = new FileOutputStream("/tmp/1225.bmp");
            ImageIO.write(tag, "BMP", out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
