package com.yan.demo.threaddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        threadAsync();
    }

    private static void threadAsync() {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        ThreadTest threadTest = new ThreadTest();

        for (int i = 0; i < 10; i++) {
            final int parameter = i;
            // 提交异步任务给线程池执行
            executor.submit(() -> threadTest.asyncMethod(parameter));
        }

        // 关闭线程池
        executor.shutdown();
    }

    public void asyncMethod(int parameter) {
        // 在这里执行异步操作
        System.out.println("异步参数: " + parameter);
    }
}
