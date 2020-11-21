package com.lt.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author : litang
 * @date : Create in 2020/10/20
 * @Description
 */
public class ReadLocalCashBean {

    public static void main(String[] args) {
        String data = readCityFile();
        JSONObject localData = JSON.parseObject(data);
        JSONObject materialItemMap = localData.getJSONObject("materialItemMap");
//        System.out.println(materialItemMap);

        JSONObject pageTypeMap = localData.getJSONObject("pageTypeMap");
        JSONObject mixWorkCreditInfo = pageTypeMap.getJSONObject("MixWorkCreditInfo");
        System.out.println(mixWorkCreditInfo);

        JSONObject materialItemGetLayout = mixWorkCreditInfo.getJSONObject("materialItemGetLayout");
        System.out.println(materialItemGetLayout);

        JSONObject materialItemUpdateLayoutMap = mixWorkCreditInfo.getJSONObject("materialItemUpdateLayoutMap");
        System.out.println(materialItemUpdateLayoutMap);

        JSONObject work_online_mix_credit = localData.getJSONObject("creditProcessMap").getJSONObject("WORK_ONLINE_MIX_CREDIT");
        System.out.println(work_online_mix_credit);

        // 校验材料项编排
        JSONObject work_online_mix_credit1 = work_online_mix_credit.getJSONObject("materialItemCheckLayoutMap");
//        System.out.println(work_online_mix_credit1);


        // 异步提交审核材料项编排
        JSONObject materialItemConfirmLayout = work_online_mix_credit.getJSONObject("materialItemConfirmLayout");
//        System.out.println(materialItemConfirmLayout);

        // 执行审核的材料项编排
        JSONObject materialItemApprovalLayout = work_online_mix_credit.getJSONObject("materialItemApprovalLayout");
//        System.out.println(materialItemApprovalLayout);

        JSONObject switchBean = localData.getJSONObject("switchBean");
//        System.out.println(switchBean);


    }

    private static String readCityFile() {
        File file02 = new File("/Users/litang/pagoda/github/Demo/jdk8-demo/src/resoure/json.txt");
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
