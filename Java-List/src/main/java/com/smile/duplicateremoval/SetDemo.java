package com.smile.duplicateremoval;

import io.github.benas.randombeans.randomizers.collection.ListRandomizer;
import io.github.benas.randombeans.randomizers.text.StringRandomizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 【参考】利用 Set 元素唯一的特性，可以快速对一个集合进行去重操作，避免使用 List 的 contains 方法进行遍历、对比、去重操作。
 *
 */
@Slf4j
public class SetDemo {

    public static void main(String[] args) {

        List<Integer> lengthList = new LinkedList<>();
        int base = 1;
        for (int i = 1; i <= 6; i++) {
            base *= 10;
            lengthList.add(base);
        }

        StringRandomizer stringRandomizer = new StringRandomizer(10, 100, 1000);

        for (Integer length : lengthList) {
            log.debug("------------长度为 {} 时-------", length);
            ListRandomizer<String> listRandomizer = new ListRandomizer<>(stringRandomizer, length);
            List<String> data = listRandomizer.getRandomValue();

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            Set<String> resultBySet = CollectionUtil.removeDuplicateBySet(data);
            log.debug("set去重耗时：{} ms", stopWatch.getTotalTimeMillis());

            stopWatch = new StopWatch();
            stopWatch.start();
            List<String> resultByList = CollectionUtil.removeDuplicateByList(data);
            log.debug("list去重耗时：{} ms", stopWatch.getTotalTimeMillis());
        }

    }
}