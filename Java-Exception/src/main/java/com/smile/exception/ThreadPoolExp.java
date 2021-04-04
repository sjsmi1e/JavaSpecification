package com.smile.exception;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author smi1e
 * Date 2019/12/25 20:26
 * Description
 */
@Slf4j
public class ThreadPoolExp {
//    private static final Logger com.smile.logger = LoggerFactory.getLogger(ThreadPoolExp.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("ab");
        data.add("abc");
        data.add("abcd");

        printList1(data, executorService);
//         printList2(data, executorService);
         executorService.shutdown();
    }

    private static void printList1(List<String> data, ExecutorService executorService) {
        for (String str : data) {
            executorService.execute(() -> {
                // 模拟中间报错
                if (str.length() == 2) {
                    throw new IllegalArgumentException();
                }
                log.info("数据:{}",str);
            });
        }
    }

    private static void printList2(List<String> data, ExecutorService executorService) {
        executorService.execute(() -> {
            for (String str : data) {
                // 模拟中间报错
                if (str.length() == 2) {
                    throw new IllegalArgumentException();
                }
                log.info("数据:{}",str);
            }
        });
    }
}
