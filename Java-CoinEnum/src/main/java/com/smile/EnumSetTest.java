package com.smile;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author smi1e
 * Date 2019/11/10 14:50
 * Description
 */
public class EnumSetTest {
    public static void main(String[] args) {

        EnumSet<CoinEnum> coinEnums = EnumSet.of(CoinEnum.PENNY, CoinEnum.NICKEL, CoinEnum.DIME, CoinEnum.QUARTER);
        coinEnums.forEach(x -> System.out.println(x.name() + ":" + x.value()));

        EnumMap<CoinEnum, String> coinEnumStringEnumMap = new EnumMap<>(CoinEnum.class);
        coinEnumStringEnumMap.put(CoinEnum.DIME, "DIME");
        coinEnumStringEnumMap.put(CoinEnum.PENNY, "PENNY");
        coinEnumStringEnumMap.put(CoinEnum.NICKEL, "NICKEL");
        coinEnumStringEnumMap.put(CoinEnum.QUARTER, "QUARTER");
        coinEnumStringEnumMap.forEach((x, y) -> System.out.println("key:" + x.name() + "--" + x.value() + " value:" + y));

    }
}
