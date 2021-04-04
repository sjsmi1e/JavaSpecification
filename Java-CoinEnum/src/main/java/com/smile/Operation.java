package com.smile;

/**
 * 枚举实现计算
 */
enum Operation {
    /**
     *
     */
    PLUS {
        @Override
        double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDED_BY {
        @Override
        double eval(double x, double y) {
            return x / y;
        }
    };

    // Each constant supports an arithmetic operation
    abstract double eval(double x, double y);

    public static void main(String[] args) {
        double x = Double.parseDouble("1");
        double y = Double.parseDouble("2");
        for (Operation op : Operation.values())
            System.out.println(x + " " + op + " " + y +
                    " = " + op.eval(x, y));
    }
}