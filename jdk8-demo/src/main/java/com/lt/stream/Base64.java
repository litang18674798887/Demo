package com.lt.stream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.*;

/**
 * @author : litang
 * @date : Create in 2020/4/27
 * @Description
 */
public class Base64 {

    public static void main(String[] args) throws IOException {
        String str = "";
        str = GetImageStr();
        GenerateImage(str);

        BufferedImage sourceImg = ImageIO.read(new FileInputStream(new File("/Users/litang/Desktop/_111.png")));
        ColorModel color = sourceImg.getColorModel();
        System.out.println("位深度:" + color.getPixelSize());;

    }

    // 图片转化成base64字符串
    public static String GetImageStr() {
        String imgFile = "/Users/litang/Desktop/timg.jpeg";// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encode(data));
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    // 对字节数组字符串进行Base64解码并生成图片
    public static boolean GenerateImage(String imgStr) {
        if (imgStr == null) {
            // 图像数据为空
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            String imgFilePath = "/Users/litang/Desktop/timg2.bmp";// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
