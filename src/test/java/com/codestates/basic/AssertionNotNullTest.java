package com.codestates.basic;

//import com.codestates.CryptoCurrency;
import com.codestates.CryptoCurrency;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertionNotNullTest {

    @DisplayName("AssertionNull() Test")
    @Test
    public void assertNotNullTest() {
        String currencyName = getCryptoCurrency("ETH"); //이더리움 있다!

        assertNotNull(currencyName, "should be not null");
        //첫 번째 파라미터는 테스트 대상 객체이고, 두 번째 파라미터는 테스트에 실패했을 때, 표시할 메시지
        //여기는 junit 사용

        assertThat(currencyName, is(notNullValue())); //이더리움 있으니 패스.
        //assertThat(currencyName, is(nullValue())); //이더리움 있으니 페일.
        //여기는 Hamcrest 사용
        //currencyName is not Null Value.’와 같이 가독성 좋은 하나의 문장처럼 구성이 됨.
    }

    private String getCryptoCurrency(String unit) {
        return CryptoCurrency.map.get(unit);
    }


}
