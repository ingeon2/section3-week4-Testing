package com.codestates.slice.mock;


import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerMockTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private Gson gson;
    

    @MockBean // 해당 필드의 Bean에 대한 Mock 객체를 생성한 후, 필드에 주입(DI)
    private MemberService memberService;
    
    //MemberMapper를 DI 받는 이유는 MockMemberService(가칭)의 createMember()에서 리턴하는 Member 객체를 생성하기 위함 (49행)
    @Autowired
    private MemberMapper mapper;
    
    
    //여기서 테스트
    @Test
    void postMemberTestbyMock() throws Exception{

        //given
        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com", "홍길동", "010-1234-5678");

        Member member = mapper.memberPostToMember(post); // MemberMapper를 이용해 post(MemberDto.Post 타입) 변수를 Member 객체로 변환
        //MemberMapper를 굳이 사용하지 않고 new Member() 와 같이 Member 객체를 생성해도 되지만 여기서는 post 변수를 재사용하기 위해 MemberMapper로 변환
        member.setMemberId(1L);
        //실제 createMember()의 리턴 값(Member 객체)에는 memberId가 포함이 되는데
        //이 memberId는 response의 Location header에 포함이 되어야 하므로 위와 같이 MockMemberService(가칭) 의 createMember()에서도
        //memberId를 리턴해 줄 수 있도록 memberId를 추가

        //Mockito에서 지원하는 Stubbing 메서드 (Stubbing은 테스트를 위해서 Mock 객체가 항상 일정한 동작을 하도록 지정하는 것을 의미)
        given(memberService.createMember(Mockito.any(Member.class))).willReturn(member);
        //given()은 Mock 객체가 특정 값을 리턴하는 동작을 지정하는데 사용, willReturn() 은 MockMemberService(가칭)의 createMember() 메서드가 리턴 할 Stub 데이터
        //위에서 이제 모키토에서 create 해온것이 Member member과 같은지를 검증해서, db와 Service계층에 가지 않아도 되게 해줌.
        //위에서 이제 모키토에서 create 해온것이 Member member과 같은지를 검증해서, db와 Service계층에 가지 않아도 되게 해줌.
        //위에서 이제 모키토에서 create 해온것이 Member member과 같은지를 검증해서, db와 Service계층에 가지 않아도 되게 해줌.
        String content = gson.toJson(post);



        //when
        ResultActions actions = mockMvc.perform(
                post("/v11/members")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );



        //then
        actions.andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/v11/members/"))));
    }
}

//기존에 우리가 Mockito 없이 MemberController의 postMember() 핸들러 메서드를 테스트했던 테스트 케이스(MemberControllerTest)에 Mockito를 적용

// 실행하면 실제 MemberService의 createMember()가 호출되면 Member, Stamp 등록 등의 insert query 문이 출력되지만
// MockMemberService(가칭)의 createMember()가 호출되므로 Member 등록에 대한 쿼리가 출력되지 않음.

// MockMemberService(가칭) 클래스는 우리가 테스트하고자 하는 Controller의 테스트에 집중할 수 있도록 다른 계층과의 연동을 끊어주는 역할
// 이처럼 Mockito를 잘 이용하면 의존하는 다른 메서드 호출이나 외부 서비스의 호출을 단절 시킬 수 있기 때문에 우리가 원하는 테스트의 범위를 최대한 좁힐 수 있음.