package com.codestates.basic;

import com.codestates.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertionExceptionTest {

    @DisplayName("throws NullPointerException when map.get()")
    @Test
    public void assertionThrowExceptionTest() {
        //assertThrows()의 첫 번째 파라미터에는 발생이 기대되는 예외 클래스를 입력하고, 두 번째 파라미터인 람다 표현식에서는 테스트 대상 메서드를 호출
        //XRP 에 해당하는 암호 화폐는 map에 존재하지 않기 때문에 map에서 반환된 값은 null
        //XRP(CryptoCurrency 클래스) 갔을때 null이 나오니까 널포인터익셉션이 맞다, 결과는 passed
        assertThrows(NullPointerException.class, () -> getCryptoCurrency("XRP"));


        Throwable actualException = assertThrows(NullPointerException.class, () -> getCryptoCurrency("XRP")); //xrp 없으니까 패스
        assertThat(actualException.getClass(), is(NullPointerException.class)); //액추얼 익셉션 = 널포인터익셉션 이니까 패스
        // Hamcrest를 사용해서 발생한 예외가 NullPointerException인지 여부를 체크
        // 예외에 대한 테스트는 Hamcrest 만으로 Assertion을 구성하기 힘들기 때문에
        // 첫줄과 같이 JUnit의 assertThrows() 메서드를 이용해서 assertThrows()의 리턴 값을 전달 받은 후에
        // 둘째줄과 같이 assertThat(actualException.getClass(), is(NullPointerException.class));
        // 을 통해 throw된 Exception 타입이 기대했던 Exception 타입과 일치하는지 추가로 검증을 진행
    }

    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit).toUpperCase();
    }

}

//만약 NullPointerException.class 대신에 RuntimeException.class 또는 Exception.class 으로 입력 값을 바꾸면 이번에는 테스트 실행 결과가 어떻게 될까요?
//이 경우, 테스트 실행 결과는 “passed”입니다.
//NullPointerException 은 RuntimeException 을 상속하는 하위 타입이고, RuntimeException 은 Exception 을 상속하는 하위 타입
