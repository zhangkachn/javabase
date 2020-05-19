package com.zhangkachn.强弱软虚拟引用;

/**
 * @Auther: zk
 * @Date: 2020/5/19 11:13
 * @Description:
 */
public class StrongRefferDemo {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 =object1;
        object1=null;
        System.gc();
        // 虽然object1置为null,但是object2引用还是指向Object中在堆中创建的对象，不会被回收
        System.out.print(object2);


    }
}

/**
 *java.lang.Object@3b9a45b3
 * Process finished with exit code 0
 */
