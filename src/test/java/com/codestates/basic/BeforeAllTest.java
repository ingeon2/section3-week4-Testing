package com.codestates.basic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BeforeAllTest {
    private static Map<String, String> map;

    @BeforeAll //@BeforeAll()은 @BeforeEach() 와 달리
    //클래스 레벨에서 테스트 케이스를 한꺼번에 실행 시키면 테스트 케이스가 실행되기 전에 딱 한번만 초기화 작업을 할 수 있도록 해주는 애너테이션
    public static void initAll() {
        map = new HashMap<>();
        map.put("BTC", "Bitcoin");
        map.put("ETH", "Ethereum");
        map.put("ADA", "ADA");
        map.put("POT", "Polkadot");
        map.put("XRP", "Ripple");

        System.out.println("initialize Crypto Currency map"); //한번출력(생각)
    }

    @DisplayName("Test case 1") //fail
    @Test
    public void beforeEachTest() {
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }

    @DisplayName("Test case 2") //pass
    @Test
    public void beforeEachTest2() {
        assertDoesNotThrow(() -> getCryptoCurrency("ADA"));
    }

    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}

//@BeforeAll 애너테이션을 추가한 메서드는 정적 메서드(static method)여야 한다는 사실을 기억