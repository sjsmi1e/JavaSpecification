#####1.【强制】ArrayList 的 subList 结果不可强转成 ArrayList，否则会抛出 ClassCastException 异 常，即 java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
#####2.【强制】在 SubList 场景中，高度注意对原集合元素的增加或删除，均会导致子列表的遍历、增加、删除产生 ConcurrentModificationException 异常。
#####3.【强制】使用工具类 Arrays.asList () 把数组转换成集合时，不能使用其修改集合相关的方法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。