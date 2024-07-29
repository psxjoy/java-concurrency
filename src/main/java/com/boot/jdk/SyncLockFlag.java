package com.boot.jdk;

import org.openjdk.jol.info.ClassLayout;

/**
 * L10.md
 */
public class SyncLockFlag {
    // 当开启了偏向锁并且没有延迟开启的时候，新创建的对象的markword默认就是偏向锁状态的markword
    //只不过这个时候没有线程争抢，除了锁标志位和是否未偏向锁标志位，其他的都是O
    static MyObject myObject = new MyObject();

    public static void main(String[] args) {
        System.out.println("===================未偏向线程的【偏向锁】==================");
        System.out.println(ClassLayout.parseInstance(myObject).toPrintable());
        myObject.hashCode();
        synchronized (myObject) {
            System.out.println("===================偏向锁==================");
            System.out.println(ClassLayout.parseInstance(myObject).toPrintable());
        }
    }



    static class MyObject{

    }
}
