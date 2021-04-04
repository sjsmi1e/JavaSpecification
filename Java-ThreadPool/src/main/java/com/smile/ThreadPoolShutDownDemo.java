package com.smile;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.util.NamedThreadFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 <p>【强制】创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。</p>
 <p>【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程</p>
 <p>【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这 样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。</p>
 * @author smi1e
 * Date 2019/11/21 10:52
 * Description
 */
@Slf4j
public class ThreadPoolShutDownDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(50000), new NamedThreadFactory("shutdown-demo"));

        int total = 20000;
        for (int i = 0; i < total; i++) {
            executorService.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(5L);
                } catch (InterruptedException ignore) {
                }
                //System.out.println(Thread.currentThread().getName());
            });
        }

      // 第 1 处代码
        //executorService.shutdownNow();
        printExecutorInfo(total, executorService);

      // 第 2 处代码
        executorService.shutdown();

       // 第 3 处代码
        /* shutdown()之后再提交任务*/
//        executorService.submit(() -> {
//        });

       // 线程池没结束，隔一秒打印任务情况
        while (!executorService.isTerminated()) {
            TimeUnit.SECONDS.sleep(1);
            printExecutorInfo(total, executorService);
        }
    }

    /**
     * 打印线程池信息
     */
    private static void printExecutorInfo(int total, ThreadPoolExecutor executorService) {
        log.debug("时间:{},总任务数：{}, 工作队列中有:{}个任务，已完成:{}个任务，正在执行:{}个任务", LocalDateTime.now(ZoneId.systemDefault()), total, executorService.getQueue().size(), executorService.getCompletedTaskCount(), executorService.getActiveCount());
    }
}