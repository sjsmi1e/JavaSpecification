package com.smile.sublist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smi1e
 * Date 2019/11/21 9:11
 * Description
 */
public class ListTest {
    private static List<Integer> list = new ArrayList<>();

    public ListTest() {
        int size = 10;
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    /**
     * 强转异常
     */
    @Test
    public void test1() {

        List<Integer> subList = list.subList(1, 5);
        try {
            ArrayList arrayList = (ArrayList) subList;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("强转出现异常！");
        }
    }

    /**
     * sublist操作
     * 该方法返回本列表中 fromIndex （包含）和 toIndex （不包含）之间的<strong>元素视图</strong>。如果两个索引相等会返回一个空列表。
     * 如果需要对 list 的某个范围的元素进行操作，可以用 subList，如：list.subList(from, to).clear();任何对子列表的操作最终都会反映到原列表中。
     *
     * 另外在SubList的构造函数中，会将ArrayList的modCount 赋值给 SubList的modCount
     */
    @Test
    public void test2() {
        List<Integer> subList = list.subList(5, 9);
        System.out.println("-----原来父列表内容---------");
        System.out.println(list.toString());
        System.out.println("-----原来子列表内容---------");
        System.out.println(subList.toString());
        subList.set(2, 20);
        System.out.println("-----后来父列表内容---------");
        System.out.println(list.toString());
        System.out.println("-----后来子列表内容---------");
        System.out.println(subList.toString());

    }
    /**
     * 从 SubList 的构造函数我们可以看到，<code>SubList</code> 复制了 ArrayList 的 modCount，
     * 因此对原函数的新增或删除都会导致 <code>ArrayList</code> 的 <code>modCount</code> 的变化。
     * 而子列表的遍历、增加、删除时又会检查创建 <code>SubList</code> 时的 modCount 是否一致，
     * 显然此时两者会不一致，导致抛出 <code>ConcurrentModificationException</code> (并发修改异常)。
     */
    @Test
    public void test3(){
        List<Integer> subList = list.subList(5, 9);
        list.add(10);
        try {
            subList.add(11);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("sublist 修改发生异常！");
        }
    }

}
