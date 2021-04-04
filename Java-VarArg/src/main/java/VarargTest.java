import org.junit.Test;

/**
 * @author smi1e
 * Date 2019/11/21 9:50
 * Description
 */
public class VarargTest {
    @Test
    public void test1() {
        varArg1(1, 2, 3, 4, 5, 6, 7);
    }

    /**
     * 可变参数的本质就是数组
     */
    private static void varArg1(int... a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println("---------------");
        for (int i : a) {
            System.out.println(i);
        }
    }
}
