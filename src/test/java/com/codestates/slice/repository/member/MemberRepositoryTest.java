package com.codestates.slice.repository.member;

import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
//MemberRepository의 기능을 정상적으로 사용하기 위한 Configuration을 Spring이 자동으로 해줌
//@Transactional 애너테이션을 포함하고 있기 때문에 하나의 테스트 케이스 실행이 종료되는 시점에 데이터베이스에 저장된 데이터는 rollback 처리
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository; // 테스트 대상 클래스인 MemberRepository를 DI





    @Test
    public void saveMemberTest() { //save 잘되는지 test
        //given 테스트 할 회원 정보 데이터(member)를 준비
        Member member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");

        //when 회원 정보를 저장
        Member savedMember = memberRepository.save(member);

        //then 회원 정보가 잘 저장되었는지 검증(Assertion)
        assertNotNull(savedMember); //회원 정보를 정상적으로 저장한 뒤에 리턴 값으로 반환 된 Member 객체(savedMember)가 null이 아닌지를 검증
        assertTrue(member.getEmail().equals(savedMember.getEmail())); //리턴 값으로 반환 된 Member 객체(savedMember)의 필드 들이 테스트 데이터와 일지하는지 검증
        assertTrue(member.getName().equals(savedMember.getName()));
        assertTrue(member.getPhone().equals(savedMember.getPhone()));
    }


    @Test
    public void findByEmailTest() { //find test
        // given 회원 정보 데이터(member)를 준비
        Member member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");

        // when
        memberRepository.save(member);  // 회원 정보를 저장
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail()); // (3)

        // then 회원 정보의 조회가 정상적으로 이루어지는지 검증(Assertion)
        assertTrue(findMember.isPresent()); // 조회된 회원 정보가 null이 아닌지를 검증
        assertTrue(findMember.get().getEmail().equals(member.getEmail())); // 조회한 회원의 이메일 주소와 테스트 데이터의 이메일과 일치하는지 검증
    }

}

//이처럼 Spring에서 데이터 액세스 계층의 기능을 테스트 하는 건 어렵지 않음.
//바로 @DataJpaTest라는 애너테이션이 있기 때문
//@DataJpaTest 애너테이션은 수많은 자동 구성 기능들을 임포트(Import) 해줌.