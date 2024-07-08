package com.boot.jdk;

/**
 * L2-2
 */
public class ThreadDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThread(),"Deamon Thread!");
        thread.setDaemon(true);
        thread.start();

    }

     static class DaemonThread implements Runnable {
         @Override
         public void run() {
             try {
                 Thread.sleep(1000);
             }catch (Exception e) {
                 e.printStackTrace();
             }finally {
                 System.out.println("FINISH!");
             }
         }
     }
}
