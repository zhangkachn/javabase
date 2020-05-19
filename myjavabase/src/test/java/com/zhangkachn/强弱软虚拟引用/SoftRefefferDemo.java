package com.zhangkachn.强弱软虚拟引用;

import java.lang.ref.SoftReference;

/**
 * @Auther: zk
 * @Date: 2020/5/19 11:25
 * @Description: 软引用
 */
public class SoftRefefferDemo {

    // 内存充足的情况下，内存是不需要进行回收的
    public static void Enghoth() {
        Object object = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference<>(object);
        object = null;
        System.gc();
        System.out.println(object);
        System.out.println(objectSoftReference.get());

    }
    /*
    null
    java.lang.Object@3b9a45b3
     */


    // 当内存不充足的情况下，回收的
    // -Xms5m -Xmx5m -XX:+PrintGCDetails设置内存
    static void NotEnghoth() {
        Object object = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference<>(object);
        object = null;
        try {
            Byte[] bytes = new Byte[30 * 1024 * 1024];
        } finally {
            System.out.println(object);
            System.out.println(objectSoftReference.get());
        }

    }

    /**
     * null
     * java.lang.Object@3b9a45b3
     * [GC (Allocation Failure) [PSYoungGen: 51K->96K(1536K)] 977K->1021K(5632K), 0.0007464 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 96K->32K(1536K)] 1021K->957K(5632K), 0.0006291 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (Allocation Failure) [PSYoungGen: 32K->0K(1536K)] [ParOldGen: 925K->928K(4096K)] 957K->928K(5632K), [Metaspace: 3396K->3396K(1056768K)], 0.0074321 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
     * [GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] 928K->928K(5632K), 0.0007477 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [Full GC (Allocation Failure) Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * 	at com.zhangkachn.强弱软虚拟引用.SoftRefefferDemo.NotEnghoth(SoftRefefferDemo.java:36)
     * 	at com.zhangkachn.强弱软虚拟引用.SoftRefefferDemo.main(SoftRefefferDemo.java:48)
     * [PSYoungGen: 0K->0K(1536K)] [ParOldGen: 928K->910K(4096K)] 928K->910K(5632K), [Metaspace: 3396K->3396K(1056768K)], 0.0079837 secs] [Times: user=0.13 sys=0.00, real=0.01 secs]
     * null
     * null
     * Heap
     *  PSYoungGen      total 1536K, used 132K [0x00000000ffe00000, 0x0000000100000000, 0x0000000100000000)
     * @param args
     */

    // -Xms5m -Xmx5m -XX:printGCDetails
    public static void main(String[] args) {
        Enghoth();
        NotEnghoth();
    }
}
