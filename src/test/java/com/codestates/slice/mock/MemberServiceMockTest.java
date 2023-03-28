package com.codestates.slice.mock;

import com.codestates.exception.BusinessLogicException;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import com.codestates.member.service.MemberService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class) //Spring을 사용하지 않고, Junit에서 Mockito의 기능을 사용하기 위해서 추가.
public class MemberServiceMockTest {
    @Mock // (2)해당 필드의 객체를 Mock 객체로 생성
    private MemberRepository memberRepository;

    @InjectMocks //@InjectMocks 애너테이션을 추가한 필드에 (2)에서 생성한 Mock 객체를 주입해 줍니다.
    //즉, (3)의 memberService 객체는 주입 받은 memberRepository Mock 객체를 포함
    private MemberService memberService; //(3)

    @Test
    public void createMemberTest() {
        // given
        Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");
        // (2)에서 생성한 memberRepository Mock 객체로 Stubbing(모키토 매서드)
        given(memberRepository.findByEmail(Mockito.anyString())).willReturn(Optional.of(member)); 
        // 주어진것이 윌리턴과 같은지 검증, verifyExistsEmail() 매서드 대신 사용.(검증만 하면 되니 db까지 안가)
        //Optional.of(member) 의 member 객체에 포함된 이메일 주소가
        //memberService.createMember(member) 에서 파라미터로 전달한 member 객체에 포함된 이메일 주소와 동일하기 때문에 검증 결과가 “passed”


        // when / then 같은 이메일 사용하면 예외
        assertThrows(BusinessLogicException.class, () -> memberService.createMember(member));
    }
}
