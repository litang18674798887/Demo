package com.lt.queue.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author : litang
 * @date : Create in 2019-01-02
 * @Description
 */
public class Person {


    @JSONField(name = "channel_key")
    private String channelKey;

    @JSONField(name = "channel_order_sn")
    private String channelOrderSn;

    @JSONField(name = "order_status")
    private String orderStatus;

    public static void main(String[] args) {
        Person person = new Person();
        person.setChannelKey("111");
        person.setChannelOrderSn("222");
        person.setOrderStatus("3333");
        String data = JSONObject.toJSONString(person);
        System.out.println(data);

        Person person1 = JSON.parseObject(data, Person.class);
        System.out.println(person1);
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getChannelOrderSn() {
        return channelOrderSn;
    }

    public void setChannelOrderSn(String channelOrderSn) {
        this.channelOrderSn = channelOrderSn;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Person{" +
                "channelKey='" + channelKey + '\'' +
                ", channelOrderSn='" + channelOrderSn + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
