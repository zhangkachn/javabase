package com.zhangkachn.强弱软虚拟引用;

import java.lang.ref.WeakReference;

/**
 * @Auther: zk
 * @Date: 2020/5/19 15:47
 * @Description:弱引用
 */
public class WeakRefferDemo {

    public  static void weakReffer(){
        Object object= new Object();
        WeakReference<Object> objectWeakReference = new WeakReference<>(object);
        // 没有回收之前
        System.out.println(object);
        System.out.println(objectWeakReference.get());

        // 进行垃圾回收，回收后弱引用都会被清除
        object=null;
        System.gc();
        System.out.println("==============================");
        System.out.println(object);
        System.out.println(objectWeakReference.get());

        //可以看出只要是弱引用，都会被回收，不管是否被引用
/**
 * java.lang.Object@3b9a45b3
 * java.lang.Object@3b9a45b3
 * ==============================
 * null
 * null
 */

    }
    public static void main(String[] args) {

        weakReffer();
    }
}
