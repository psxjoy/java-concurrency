package com.boot.jdk;

/**
 * L9.md
 */
public class ThreadReIn implements Runnable {
    static ThreadReIn instance = new ThreadReIn();
    static int i = 0;
    static int j = 0;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i：" + i);
        System.out.println("j：" + j);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            //当前实例对象
            synchronized (this) {
                i++;
                increase();
            }
        }
    }

    private synchronized void increase() {
        j++;
    }
}
