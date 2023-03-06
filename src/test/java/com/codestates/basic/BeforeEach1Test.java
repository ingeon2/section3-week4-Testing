package com.codestates.basic;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// 테스트 케이스를 실행하기 전에 어떤 객체나 값에 대한 초기화 작업 등의 전처리 과정을 해야할 경우가 많습니다.
// 이 경우 JUnit에서 사용할 수 있는 애너테이션이 바로 @BeforeEach와 @BeforeAll()
public class BeforeEach1Test {

    @BeforeEach
    public void init() {
        System.out.println("Pre-processing before each test case");
    }

    // 각각 아래의 매서드 실행 전에 BeforeEach가 실행되니 위의 프린트라인 출력
    
    @DisplayName("@BeforeEach Test1")
    @Test
    public void beforeEachTest() {

    }

    @DisplayName("@BeforeEach Test2")
    @Test
    public void beforeEachTest2() {

    }
}

//@BeforeEach 애너테이션을 추가한 메서드는 테스트 케이스가 각각 실행될 때 마다 테스트 케이스 실행 직전에 먼저 실행되어 초기화 작업 등을 진행