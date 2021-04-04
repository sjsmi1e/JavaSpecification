package com.smile;

import net.sf.ehcache.util.NamedThreadFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author smi1e
 * Date 2019/11/25 20:15
 * Description 在junit中开启线程
 */
public class ThreadTest {

    /**
     * IDEA 运行 JUnit 4 时，
     * <ol>
     * <li>先执行 <code>com.intellij.rt.execution.junit.JUnitStarter#main</code> ，此函数中调用 <code>prepareStreamsAndStart</code> 子函数；</li>
     * <li>子函数最终调用到 <code>ThreadDemoTest#test</code> 的代码。</li>
     * <li><code>ThreadDemoTest#test</code> 创建两个新线程并依次开启后结束，函数返回退出码，最终调用 <code>System.exit(exitCode);</code> 退出 JVM。</li>
     * </ol>
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10), new NamedThreadFactory("my thread pool"));
        int threadNum = 10;
        for (int i = 0; i < threadNum; i++) {
            final int index = i;
            poolExecutor.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(index);
                countDownLatch.countDown();
            });
        }
        //主线程必须等待线程池线程里线程运行完才能结束jvm
        countDownLatch.await();
    }

    /**
     * 输出不了。道理和上面一样
     */
    @Test
    public void test2(){
//        CompletableFuture.supplyAsync(()->1).thenApply(x->x+" 2").thenApply(y-> y+" 3").thenAccept(System.out::println);
//        List<CompletableFuture<String>>list = new ArrayList<>();
//        CompletableFuture<String> hello = CompletableFuture.completedFuture("hello");
//        CompletableFuture<String> world= CompletableFuture.completedFuture("world");
//        list.add(hello);
//        list.add(world);
//        CompletableFuture.supplyAsync(()->"java").thenCombine(hello,(x,y)-> x+y).thenCombine(world,(x,y)-> x+y)
//                .thenAccept(System.out::println);
//        CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()])).whenComplete((x,e)->{
//            System.out.println(x);
//        });
    }

    /**
     * CompletableFuture用法
     * @param args
     */
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->1).thenApply(x->x+" 2").thenApply(y-> y+" 3").thenAccept(System.out::println);
        List<CompletableFuture<String>>list = new ArrayList<>();
        CompletableFuture<String> hello = CompletableFuture.completedFuture("hello");
        CompletableFuture<String> world= CompletableFuture.completedFuture("world");
        list.add(hello);
        list.add(world);
        CompletableFuture.supplyAsync(()->"java").thenCombine(hello,(x,y)-> x+" "+y).thenCombine(world,(x,y)-> x+" "+y)
                .thenAccept(System.out::println);
    }

}
