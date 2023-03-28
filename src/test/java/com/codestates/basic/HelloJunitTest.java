package com.codestates.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
public class HelloJunitTest {
    @DisplayName("Hello Junit Test")
    @Test
    public void assertionTest1() {
        String expexted = "Hello, Junit";
        String actual = "Hello, Junit";

        assertEquals(expexted, actual);
    }

    @DisplayName("Hello Junit Test using hamcrest")

    @Test
    public void assertionTest2() {
        String expexted = "Hello, Junit";
        String actual = "Hello, Junit";

        assertThat(actual, is(equalTo(expexted))); //Hamcrest의 is(), equalTo() Matcher를 사용
        // 첫 번째 파라미터는 테스트 대상의 실제 결과 값, 두 번째 파라미터는 기대하는 값입니다. 즉, 이런 값일거라고 기대(예상)하는 값
        // Assertion 코드 한 줄은 ‘assert that actual is equal to expected’라는 하나의 영어 문장으로 자연스럽게 읽혀짐.
    }

    @DisplayName("Hello Junit Test using hamcrest2")
    @Test
    public void assertionTest3() {
        String actual = "Hello, JUnit";
        String expected = "Hello, JUnit"; //여길 헬로 월드 라고 해서 페일 뜨게 하면,
        //에러 메세지가 아래와 같이 떠서 자연스레 읽혀짐. 이게  Hamcrest의 장점.
        //Expected: is "Hello, World"
        //but: was "Hello, JUnit"

        assertEquals(expected, actual);
    }


}
