package com.smile.exception;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smi1e
 * Date 2019/12/25 20:19
 * Description 循环捕获异常
 */
public class LoopExp {
    private final Logger logger = LoggerFactory.getLogger(LoopExp.class);
    @Test
    public void test() {
        List<String> data = new ArrayList<>();
        data.add("a");
        data.add("ab");
        data.add("abc");
        data.add("abcd");
        /**
         * 这个不被允许，当出错直接结束，导致后续操作不能执行
         */
//        try {
//            for (String str : data) {
//                // 远程方法调用
//                String result = doSomeRemoteInvoke(str);
//                System.out.println(result);
//            }
//        }catch (Exception e){
//            com.smile.logger.error("程序出错，参数data:{},错误详情", JSON.toJSONString(data), e);
//        }


            for (String str : data) {
                try {
                    // 远程方法调用
                    String result = doSomeRemoteInvoke(str);
                    System.out.println(result);
                }catch (Exception e){
                    logger.error("程序出错，参数data:{},错误详情", JSON.toJSONString(data), e);
                }

            }


        // 后续代码
    }

    private String doSomeRemoteInvoke(String str) {
        //TODO 做点什么
        return "";
    }
}
