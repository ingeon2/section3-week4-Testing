package com.codestates.slice.controller.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest //spring boot를 위한 Application Context를 생성.
@AutoConfigureMockMvc //Controller 테스트를 위한 애플리케이션의 자동 구성 작업
public class ControllerTestDefaultStructure {

    //위의 오토컨피규어에서 설정해줘서 아래 객체 사용가능
    //MockMvc는 Tomcat 같은 서버를 실행하지 않고 Spring 기반 애플리케이션의 Controller를 테스트 할 수 있는
    //완벽한 환경을 지원해주는 일종의 Spring MVC 테스트 프레임워크

    //MockMvc 객체를 통해 우리가 작성한 Controller를 호출해서 손쉽게 Controller에 대한 테스트를 진행
    private MockMvc mockMvc;

    //테스트 하고자 하는 Controller 핸들러 메서드의 테스트 케이스를 작성
    @Autowired
    public void postMemberTest() {
        //given 테스트용 request body 생성

        //when MockMvc 객체로 테스트 대상 Controller 호출

        //then Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 response body 검증
    }
}

//얘는 API계층(컨트롤러)에서 이런식으로 테스트 한다 를 알려주는 용도의 클래스.