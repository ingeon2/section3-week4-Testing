package com.codestates.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionTest {
    @DisplayName("Assumption Test")
    @Test
    public void assumptionTest() {
        // 어슘트루 : 파라미터로 입력된 값이 true이면 나머지 아래 로직들을 실행
        assumeTrue(System.getProperty("os.name").startsWith("Windows")); //나는 윈도우니까 여기 주석제거
//        assumeTrue(System.getProperty("os.name").startsWith("Linux"));
        System.out.println("execute?");
        assertTrue(processOnlyWindowsTask());
    }

    private boolean processOnlyWindowsTask() {
        return true;
    }
}
