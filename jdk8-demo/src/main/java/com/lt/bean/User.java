package com.lt.bean;

import lombok.Data;

/**
 * @author : litang
 * @date : Create in 2020-01-19
 * @Description
 */
@Data
public class User {

    private Integer age;

    private String name;


    public static void main(String[] args){
        User.aa();

    }
    public static void aa(){
        System.out.println("Printing stack trace:");
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (int i = 1; i < elements.length; i++) {
            StackTraceElement s = elements[i];
            System.out.println("\tat " + s.getClassName() + "." + s.getMethodName()
                    + "(" + s.getFileName() + ":" + s.getLineNumber() + ")");
        }
    }

}
