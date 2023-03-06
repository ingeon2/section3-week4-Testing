package com.codestates.slice.repository.member;

import org.junit.jupiter.api.Test;

public class DataAccessLayerTest { //기본적 database slicetest 구조 알려주는 클래스
    @Test
    public void testA() {
        // (1-1) 데이터가 DB에 잘 저장되는지를 테스트하기 위해 한 건의 데이터를 DB에 저장
        // (1-2) DB에 잘 저장되었는지 DB에서 조회해서 결과를 확인
    }

    @Test
    public void testB() {
        // (2-1) 데이터가 DB에서 잘 조회 되는지를 테스트하기 위해 DB에서 조회
    }
}

//DB의 상태를 테스트 케이스 실행 이전으로 되돌려서 깨끗하게 만든다.
//이유는 testA, testB 의 순서가 테스트할때마다 달라지기 때문에, 
//순서에 따라 database의 data가 달라질 수 있어 테스트 결과에 영향을 미치기 때문.
//이 점을 염두에 두고, 이 후의 학습을 진행 (@DataJpaTest가 해결, 바로 아래의 멤버리파지토리 테스트)
//데이터 액세스 계층 테스트 시에는 위와 같은 한가지 규칙을 알려주기 위한 클래스. 그렇구나! 하고 넘기기