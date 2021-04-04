package com.smile;

import java.util.Arrays;

/**
 * @author smi1e
 * Date 2019/11/10 14:26
 * Description
 */
public enum CoinEnum {
    /**
     *
     */
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    CoinEnum(int value) {
        this.value = value;
    }

    private final int value;

    public int value() {
        return value;
    }

    public static CoinEnum getByValue(int value) {
        for (CoinEnum coinEnum : CoinEnum.values()) {
            if (coinEnum.value==value) {
                return coinEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(CoinEnum.valueOf("PENNY").value());
        System.out.println(Arrays.toString(CoinEnum.values()));
        CoinEnum penny = CoinEnum.getByValue(1);
        System.out.println(penny.name()+":"+penny.value);
    }
}
