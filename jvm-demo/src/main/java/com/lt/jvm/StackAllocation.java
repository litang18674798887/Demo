package com.lt.jvm;

/**
 * @author : litang
 * @date : Create in 2019-02-11
 * @Description
 */
public class StackAllocation {

    public StackAllocation obj;

    /**
     * 方法返回StackAllocation对象，发生逃逸
     * @return
     */
    public StackAllocation getInstance () {
        return obj == null ? new StackAllocation() : obj;
    }

    /**
     * 为成员属性赋值，发生逃逸
     */
    public void setObj() {
        this.obj = new StackAllocation();
    }

    /**
     * 对象的作用域仅在当前的方法中有效，没有办法逃逸
     */
    public void setStackAllocation() {
        StackAllocation s = new StackAllocation();
    }

    /**
     * 引用成员变量的值，发生逃逸
     */
    public void useStackAllocation2(){
        StackAllocation s = getInstance();
    }
}
