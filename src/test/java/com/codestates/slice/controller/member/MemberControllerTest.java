package com.codestates.slice.controller.member;

import com.codestates.member.dto.MemberDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest //애너테이션들 설명은 basic패키지의 클래스에 나와있다.
@AutoConfigureMockMvc
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;
    //Gson은 Java에서 Json을 파싱하고, 생성하기 위해 사용되는. 구글에서 개발한 오픈소스

    //아래에서 계속 사용해주기 위해 만들어줌 (변수, post매서드까지)
    private MemberDto.Post beforePost1;
    private MemberDto.Post beforePost2;
    private String beforePostContent1;
    private String beforePostContent2;
    
    @BeforeEach
    public void init() { //postMemberTest 매서드에는 이해하기 위한 주석과 설명이 있으므로 이거 사용 안할 예정.
        beforePost1 = new MemberDto.Post("hgd1@gmail.com", "홍길일", "010-1111-1111");
        beforePost2 = new MemberDto.Post("hgd2@gmail.com", "홍길이", "010-2222-2222");

        beforePostContent1 = gson.toJson(beforePost1);
        beforePostContent2 = gson.toJson(beforePost2);

    }





    @Test //MemberController의 postMember() 핸들러 메서드를 테스트 하는 테스트 케이스
    void postMemberTest() throws Exception {
        //given
        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com", "홍길동", "010-1234-5678"); //request body에 포함시키는 요청 데이터와 동일한 역할
        String content = gson.toJson(post);  //Gson이라는 JSON 변환 라이브러리를 이용해서 등록한 post 를 JSON포맷으로 변환

        //when
        ResultActions actions =
                mockMvc.perform( //MockMvc로 테스트 대상 Controller의 핸들러 메서드에 요청을 전송하기 위해서는
                        // 기본적으로 이와 같이 perform() 메서드를 호출해야 하며
                        // perform() 메서드 내부에 Controller 호출을 위한 세부적인 정보들이 포함
                        post("/v11/members") // post() 메서드를 통해 HTTP POST METHOD와 request URL을 설정
                                .accept(MediaType.APPLICATION_JSON) // accept() 메서드를 통해 클라이언트 쪽에서 리턴 받을 응답 데이터 타입으로 JSON 타입을 설정
                                .contentType(MediaType.APPLICATION_JSON) // contentType() 메서드를 통해 서버 쪽에서 처리 가능한 Content Type으로 JSON 타입을 설정
                                .content(content) // content() 메서드를 통해 request body 데이터를 설정
                );

        //then
        actions.andExpect(status().isCreated())
                //andExpect() 메서드를 통해 파라미터로 입력한 매처(Matcher)로 예상되는 기대 결과를 검증
                //status().isCreated()를 통해 response status가 201(Created)인지 매치.
                //즉, 위에서 perform post를 했을 때 백엔드 측에 리소스인 회원 정보가 잘 생성(저장)되었는지를 검증
                .andExpect(header().string("Location", is(startsWith("/v11/members/"))));
                //header().string("Location", is(startsWith("/v11/members/"))) 을 통해 HTTP header에 추가된 Location의 문자열 값이 “/v11/members/”로 시작하는지 검증
                //Location header가 예상하는 값과 일치한다라는 것은 백엔드 측에 리소스(회원 정보)가 잘 생성되었다는 것을 의미

    }

    @Test ////MemberController의 getMember() 핸들러 메서드를 테스트 하는 테스트 케이스
    void getMemberTest() throws  Exception {
        //given init() 에서 만든것 사용
        ResultActions beforePostAction = mockMvc.perform(
                post("/v11/members")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beforePostContent1)
        );

        //===================================  postMember()를 이용한 테스트 데이터 생성 끝

        // (2)postMember()의 response에 전달되는 Location header 값을 가져오는 로직
        String location = beforePostAction.andReturn().getResponse().getHeader("Location"); // "/v11/members/1"을 의미.

        // when, then
        mockMvc.perform(
                get(location) // (2)에서 얻은 Location header의 값을 get(location)으로 전달, (”/v11/members/1”)를 의미
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk()) // 기대하는 HTTP status가 200 OK인지를 검증
                //여기 아래 세줄 getMember() 핸들러 메서드에서 리턴하는 response body(JSON 형식)의 각 프로퍼티(email, name, phone)의 값을 검증하는 기능을 추가
                .andExpect(jsonPath("$.data.email").value(beforePost1.getEmail()))
                .andExpect(jsonPath("$.data.name").value(beforePost1.getName()))
                .andExpect(jsonPath("$.data.phone").value(beforePost1.getPhone()));
    }

    @Test
    void patchMemberTest() {
        //given
        //when
        //then
    }

}


//지금까지 @SpringBootTest, @AutoConfigureMockMvc 애너테이션을 사용해서 Controller 테스트를 진행하는 방법 작성.
//MockMvcResultMatchers 클래스에서 지원하는 jsonPath()를 사용하면 JSON 형식의 개별 프로퍼티에 손쉽게 접근할 수 있다는 사실을 기억
//@Transactional 안붙여서 에러났었음. (버전 충돌), postMemberTest 매서드에서 201에러여야하는데 409에러나서.

//이번 챕터에서 학습한 방법대로 테스트할 경우, Controller만 테스트하는 것이 아니라 애플리케이션의 전체 로직을 모두 실행하게 됩니다.
//즉, 우리가 테스트에 집중해야 되는 계층은 API 계층인데 서비스 계층이나 데이터 액세스 계층까지 불필요한 로직이 수행된다는 것입니다.
//따라서 이번 챕터에서 학습한 방법만으로는 완전한 슬라이스 테스트라고 보기에는 힘듭니다.
//이 문제는 Mock(가짜) 객체를 사용해 계층 간의 연결을 끊어줌으로써 해결이 가능