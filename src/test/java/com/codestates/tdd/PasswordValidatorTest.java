package com.codestates.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PasswordValidatorTest {
    @DisplayName("패스워드 유효성 검증 테스트: 모든 조건에 만족")
    @Test
    public void validatePassword() {

        //given
        String password = "Abcd1234!";

        //when
        PasswordValidator validator = new PasswordValidator();
        Executable excutable = () -> validator.validate(password);

        //then
        assertDoesNotThrow(excutable);
    }
    //tdd 클래스의 validate 매서드만 만들면 통과였는데, 위의 패스워드는 원래 통과하도록 만든것이다.
    //그럼 아래를 보면, 통과 못할친구인데 통과해버리는 상황이 일어난다.
    //이러한 상황에서 validate 매서드를 그에 맞게 수정하는것. 이게 tdd의 방식이다
    //지금 validate 메서드를 보려가면 진작 고쳐놓았으니 고쳐져있을것
    
    //validate를 고친 후 특수문자를 포함 안되도록 수정했고, 아래 매서드는 특수문자 없으니 fail 이 먼저 뜬다.
    //그런데 test의 기본. pass를 뜨게 해야하므로 다시 validatePasswordWithoutSpecialCharacter 매서드를 수정해준다.
    //지금 validatePasswordWithoutSpecialCharacter 매서드를 보면 이미 수정해놓은것

    @DisplayName("특수 문자 포함 안됨 테스트")
    @Test
    public void validatePasswordWithoutSpecialCharacter() {
        // given
        String password1 = "Abcd1234&!";
        //String password2 = "Abcd1234";

        // when
        PasswordValidator validator = new PasswordValidator();
        Executable executable1 = () -> validator.validate(password1);
        //Executable executable2 = () -> validator.validate(password2);

        // then
        assertDoesNotThrow(executable1);
        //assertDoesNotThrow(executable2);
    }

    //이제 클래스 레벨에서 테스트 케이스를 실행 시키면 모든 테스트의 실행 결과는 “passed”
}



//우리가 애플리케이션 보안에 대한 학습은 아직 하지 않았기 때문에 커피 주문 샘플 애플리케이션에서 회원 등록 시, 로그인 인증을 위한 패스워드 정보는 빠져 있긴하지만 어쨌든 회원 등록 시 입력하는 로그인 인증용 패스워드의 유효성을 검증하는 기능을 TDD 방식으로 개발해 보겠습니다.
//
//먼저 간단히 우리가 구현 할 패스워드 유효성 검증에 통과하는 조건은 다음과 같습니다.
//패스워드 길이는 8 ~ 20 사이의 길이(length)여야 한다.
//패스워드는 알파벳 소문자 + 알파벳 대문자 + 숫자 + 특수 문자 형태로 구성되어야 한다.
//알파벳 대/소문자와 숫자를 제외한 모든 문자는 특수문자라고 가정합니다.
//
//위 조건을 모두 만족해야지만 패스워드 유효성 검증에서 통과할 수 있습니다.


//TDD의 개발 방식
//“failed”인 테스트 케이스를 지속적으로 그리고 단계적으로 수정하면서 테스트 케이스 실행 결과가 “passed”가 되도록 만듦.
//TDD에서는 테스트가 “passed” 될 만큼의 코드만 우선 작성