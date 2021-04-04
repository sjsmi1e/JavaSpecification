package com.smile.aslist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author smi1e
 * Date 2019/11/21 9:38
 * Description
 */
public class ListTest {
    private static int size = 10;
    int[] list = new int[size];

    public ListTest() {
        for (int i = 0; i < size; i++) {
            list[i] = i;
        }
    }

    /**
     *
     TODO 注释主要用在本该做还没做的事项。
     <li>待斟酌函数的命名。</li>
     <li>性能不佳，待后期优化。</li>
     <li>开发过程某个功能使用前需要进行权限校验，但是权限校验依赖的新接口对方还没开发好。</li>
     FIXME 注释，主要用在某些出错代码处，一般是一些不能工作需要及时纠正的错误。
     */
    @Test
    public void test1(){
        List list = Arrays.asList(this.list);
        try {
            list.add(10);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("修改失败！");
        }
    }
}
