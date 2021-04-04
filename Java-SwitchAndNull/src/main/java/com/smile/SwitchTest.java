package com.smile;

/**
 * @author smi1e
 * Date 2019/11/10 14:17
 * Description
 * switch 的表达式必须是 char, byte, short, int, Character, Byte, Short, Integer, String, 或者 enum 类型，否则会发生编译错误
 * <p>
 * switch 语句必须满足以下条件，否则会出现编译错误：
 * 与 switch 语句关联的每个 case 都必须和 switch 的表达式的类型一致；
 * 如果 switch 表达式是枚举类型，case 常量也必须是枚举类型；
 * 不允许同一个 switch 的两个 case 常量的值相同；
 * 和 switch 语句关联的常量不能为 null ；
 * 一个 switch 语句最多有一个 default 标签。
 * </p>
 * <p>
 * 原理过程：
 * ①虚拟机为了实现 switch 的语法，将参数表达式转换成 int（也就是.hashCode()）。
 * ②整个流程是先计算字符串参数的哈希值，判断哈希值的范围，然后哈希值相等再判断对象是否相等，然后执行对应的代码块。
 * </p>
 */
public class SwitchTest {
    public static void main(String[] args) {
        String param = null;
        switch (param = "null") {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
