package com.codestates.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BeforeEach2Test {
    private Map<String, String> map;

    @BeforeEach
    public void init() {
        map = new HashMap<>();
        map.put("BTC", "Bitcoin");
        map.put("ETH", "Ethereum");
        map.put("ADA", "ADA");
        map.put("POT", "Polkadot");
    }

    @DisplayName("Test case 1") //passed
    @Test
    public void beforeEachTest() {
        map.put("XRP", "Ripple");
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }

    @DisplayName("Test case 2") //failed (beforeEach init로 map에 XRP 사라짐)
    @Test
    public void boforeEachTest2() {
        System.out.println(map);
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }
    //콘솔에 출력된 “{BTC=Bitcoin, POT=Polkadot, ETH=Ethereum, ADA=ADA}”는
    //Test case 2 실행 시, map의 상태를 출력한 것입니다. map 안에 “XRP”는 없는 것을 확인




    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}
