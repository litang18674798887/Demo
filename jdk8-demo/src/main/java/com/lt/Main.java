package com.lt;


import cn.hutool.crypto.SecureUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import sun.security.provider.MD5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : litang
 * @date : Create in 2019-02-01
 * @Description
 */
public class Main {

    private static final String[] LOGISTICS_ORG_NOT_SUPPORT_OMS_CANCEL_DISPATCHING = new String[]{"饿了么","点我达"};

    private Main installs;

    public Main() {
        byte[] bytes = new byte[20 * 1024 * 1024];
    }

    public static void main(String[] args) {


        String data = SecureUtil.md5(
                "5d0e1384b1d129c10c74ba590731ac8dc763864eafc38667ecc5acb259c30085202011061545254382069922AD470D8F87F04C40513DF2");
        System.out.println(data);

      /*  double v = (1 << 30) * Math.pow(2, 30);
        System.out.println(v);


        System.out.println(String.format("%.0f", Float.valueOf("11.64111111")));

        Integer a = 1151;
        int result = a.intValue() / 100;
        System.out.println(result);


        String aaa = "饿了么及时送";
        if(StringUtils.isNotBlank(aaa) &&
                !ArrayUtils.contains(LOGISTICS_ORG_NOT_SUPPORT_OMS_CANCEL_DISPATCHING, aaa)){
            System.out.println(1111);
        }else {
            System.out.println(2222);
        }
*/

     /*   Main m1 = new Main();
        Main m2 = new Main();

        m1.installs = m2;
        m2.installs = m1;

        m1 = null;
        m2 = null;
        System.gc();*/

        List<String> strings = Arrays.asList("1", "2");

        strings.add("3");

        System.out.println(strings);

        ArrayList<Object> objects = new ArrayList<>();

    }
}
