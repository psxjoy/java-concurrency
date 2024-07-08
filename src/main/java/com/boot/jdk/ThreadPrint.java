package com.boot.jdk;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * L1
 */
public class ThreadPrint {
    public static void main(String[] args)throws Exception {
        // 获取JAVA 线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
        Thread.sleep(1000000);
    }
    /**
     [6]Monitor Ctrl-Break
     [5]Attach Listener
     [4]Signal Dispatcher
     [3]Finalizer
     [2]Reference Handler
     [1]main

     */
}
