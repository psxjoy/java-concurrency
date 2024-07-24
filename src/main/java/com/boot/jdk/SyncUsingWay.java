package com.boot.jdk;

/**
 * L8.md
 */
public class SyncUsingWay {
    //普通方法- 锁对象：我们的对象（new出来的。谁调用这个方法，锁就作用在谁身上）
    public synchronized void syncMethod() {
        System.out.println("syncMethod");
    }

    // 静态方法 -锁对象：对象所属的class，全局只有一个（类型，放到JVM的方法区中）
    //包括真正的.class 文件的二进制文件，最终都加载到了运行时数据区的方法区
    public static synchronized void syncStaticMethod() {
        System.out.println("syncStaticMethod");
    }
    //静态代码块 -
    public void method() {
        synchronized (this) {
            System.out.println("method");
        }
    }
}
