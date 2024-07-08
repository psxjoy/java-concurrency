package com.boot.jdk;

import lombok.SneakyThrows;

/**
 * L2-1
 */
public class ThreadPriority {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")");

        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");

        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();

    }


}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @SneakyThrows
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")"+",loop:"+i);

        }
    }
}
