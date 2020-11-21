package com.lt.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author : litang
 * @date : Create in 2020/10/27
 * @Description
 */
public class Json3Test {

    public static void main(String[] args) {

        String data = readCityFile();
        JSONObject localData = JSON.parseObject(data);

        JSONObject switchBean = localData.getJSONObject("switchBean");
        System.out.println(switchBean);

        JSONObject switchInfoCacheMap = switchBean.getJSONObject("switchInfoCacheMap");
        System.out.println(switchInfoCacheMap);

        JSONObject jsonObject = localData.getJSONObject("appFieldBean").getJSONObject("fieldMap");
        System.out.println(jsonObject);
    }

    private static String readCityFile() {
        File file02 = new File("/Users/litang/pagoda/github/Demo/jdk8-demo/src/resoure/json3.txt");
        FileInputStream is = null;
        StringBuilder stringBuilder = null;
        try {
            if (file02.length() != 0) {
                /**
                 * 文件有内容才去读文件
                 */
                is = new FileInputStream(file02);
                InputStreamReader streamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    // stringBuilder.append(line);
                    stringBuilder.append(line);
                }
                reader.close();
                is.close();
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);

    }
}
