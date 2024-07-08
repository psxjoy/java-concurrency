package com.boot.jdk;

import lombok.SneakyThrows;

/**
 * L3
 */
public class ReadStackLog {
    public static void main(String[] args) {
        new Thread(new TimeWating(), "TimeWaitingThread").start();

        new Thread(new Waiting(), "WaitingThread").start();
        // 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }
}

class TimeWating implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(1000000);
        }
    }
}

class Waiting implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Waiting.class) {
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Blocked implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        synchronized (Blocked.class) {
            while (true) {
                Thread.sleep(1000000);

            }
        }
    }
}
