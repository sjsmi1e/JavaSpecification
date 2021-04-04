/**
 *
 <p>为了兼容Java SE 5.0 之前的版本，方法签名的选择分为 3 个阶段。</p>
 <p>第一阶段：<strong>不让自动装箱和拆箱，也不能使用可变参数的情况下选择重载</strong>。如果无法选择合适地方法，则进入第二阶段。</p>
 <p>由于不允许自动拆箱、拆箱和可变参数，这一条保证了Java SE 5.0 之前的函数调用的合法性。</p>
 <p>如果在第一阶段可变参数生效，如果在一个已经声明了 <code>m(Object)</code>  函数的类中声明 <code>m(Obejct...)</code> 函数，会导致即使有更适合的表达式（如 <code>m(null)</code> ） 也不会选择 <code>m(Object)</code>  。</p>
 <p>第二阶段：<strong>允许自动装箱和拆箱，但是仍然排除变长参数的重载</strong>。如果仍然无法选择合适的方法，则进入第三阶段。</p>
 <p>这是为了保证，如果定义了定长参数的函数情况下，不会选择变长参数。</p>
 <p>第三阶段：<strong>允许自动装箱、拆箱和变长参数的重载</strong>。</p>

 */
public class BooleanDemo {



    public static void main(String[] args) {
//        boolean result = and(true, true, true);
        boolean result = and(new Boolean[]{true, true, true});
        System.out.println(result);
        justPrint(true);
    }

  // 函数1
    private static void justPrint(boolean b) {
        System.out.println(b);
    }

  // 函数2
    private static void justPrint(Boolean b) {
        System.out.println(b);
    }

  // 函数3
    private static boolean and(boolean... booleans) {
        System.out.println("boolean");
        for (boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

 // 函数4
    private static boolean and(Boolean... booleans) {
        System.out.println("Boolean");
        for (Boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
