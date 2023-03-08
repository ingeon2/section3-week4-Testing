학습 목표  
테스트를 왜 해야하는지 이해할 수 있다.  
단위 테스트가 무엇인지 이해할 수 있다.  
JUnit의 기본적인 사용법을 이해할 수 있다.  
슬라이스 테스트가 무엇인지 이해할 수 있다.  
Spring에서의 슬라이스 테스트 방법을 알 수 있다.  
Hemcrest의 기본적인 사용법을 이해할 수 있다.  
Mockito의 기본적인 사용법을 이해할 수 있다.  
  
제 3자가 여러분들이 만든 애플리케이션을 사용할 때 발생할 수 있는 에러를 최소화 할 수 있는 방법이 테스팅.  

기능 테스트  
애플리케이션을 사용하는 사용자 입장에서 애플리케이션이 제공하는 기능이 올바르게 동작하는지를 테스트 (단위 큼)  

통합 테스트  
클라이언트 측 툴 없이 개발자가 짜 놓은 테스트 코드를 실행시켜서 이루어지는 경우 (기능 테스트 에서 클라이언트 제거)  

슬라이스 테스트  
애플리케이션을 특정 계층으로 쪼개어서 하는 테스트를 의미  
단위 테스트라고 부르기에는 단위가 큰 테스트이며, 또한 애플리케이션의 일부만 테스트하기 때문에 부분 통합 테스트라고 부르기도 함.  

단위 테스트 코드는 메서드 단위로 대부분 작성.  
데이터베이스의 상태가 테스트 이 전과 이 후가 동일하게 유지될 수 있다면 데이터베이스가 연동된다고 해도 단위 테스트에 포함될 수 는 있음.  
일반적으로 단위 테스트는 최대한 독립적인 것이 좋고, 최대한 작은 단위인 것이 더 좋음.  
더 작은 단위일수록 다른 연관된 기능들을 생각할 필요도 없고, 테스트 코드 짜기도 더 단순해지고 그만큼 빠르게 테스트를 수행할 수 있기 때문.
작은 단위의 테스트로 미리미리 버그를 찾을 수 있기 때문에  
애플리케이션의 덩치가 커진 상태에서 문제의 원인을 찾아내는 것보다 상대적으로 더 적은 시간 안에 문제를 찾아낼 가능성이 높아짐.  

단위 테스트를 위한 F.I.R.S.T 원칙  
Fast(빠르게), Independent(독립적으로), Repeatable(반복 가능하도록 in IDE, 로컬환경, 서버환경..), Self-validating(셀프 검증이 되도록), Timely(시기 적절하게).  

✅ Given-When-Then 표현 스타일  
단위 테스트에 익숙하지 않은 분들에게 또는 테스트 케이스의 가독성을 높이기 위해 given - when - then 표현 방법을 사용하는 것은 테스트 케이스를 작성하는데 유용한 방법.
  
Given  
테스트를 위한 준비 과정을 명시, 테스트에 필요한 전제 조건들이 포함, 테스트 대상에 전달되는 입력 값(테스트 데이터) 역시 Given에 포함.  
  
When  
테스트 할 동작(대상)을 지정, 단위 테스트에서는 일반적으로 메서드 호출을 통해 테스트를 진행하므로 한두줄 정도로 작성이 끝나는 부분.  
  
Then  
테스트의 결과를 검증하는 영역, 일반적으로 예상하는 값(expected)과 테스트 대상 메서드의 동작 수행 결과(actual) 값을 비교해서 기대한대로 동작을 수행하는지 검증(Assertion)하는 코드들이 포함.  
  
Asertion  
테스트 세계에서 Assertion(어써션)이라는 용어는 테스트 결과를 검증할 때 주로 사용.  
  
  
  
    
TEST의 basic 패키지엔 기본적인 애너테이션, junit없이 테스트한 내용 들어가있는 패키지. (@BeforeEach, @BeforeAll, assertThat, Assumption...)  
Assumption은 ‘~라고 가정하고’ 라는 표현을 쓸 때의 ‘가정’에 해당  
  
JUnit에서는 테스트 케이스 실행이 끝난 시점에 후처리 작업을 할 수 있는 @AfterEach, @AfterAll 같은 애너테이션도 지원합니다.  
이 애너테이션은 @BeforeEach , @BeforeAll 과 동작 방식은 같고, 호출되는 시점만 반대입니다.  
@AfterEach, @AfterAll 은 여러분이 직접 한 번 예제를 만들어서 동작 방식을 확인해 보길 바람.  

핵심 포인트  
JUnit은 Java 언어로 만들어진 애플리케이션을 테스트 하기 위한 오픈 소스 테스트 프레임워크이다.  
JUnit은 2022년 현재 Junit 5가 릴리즈 되어 있다.  
JUnit으로 테스트 케이스를 작성하기 위해서는 기본적으로 @Test 애너테이션을 추가해야한다.  
JUnit은 assertXXXX()로 시작하는 다양한 Assertion 메서드를 지원한다.  
JUnit은 테스트 케이스 실행 전, 후에 어떤 처리 로직을 작성할 수 있도록 @BeforeEach, @BeforeAll, @AfterEach, @AfterAll 등의 애너테이션을 지원한다.  



Hamcrest란?  
Hamcrest는 JUnit 기반의 단위 테스트에서 사용할 수 있는 Assertion Framework.  
Hamcrest는 다음과 같은 이유로 JUnit에서 지원하는 Assertion 메서드보다 더 많이 사용. (가독성 굳), (각각의 테스트클래스에서 Hamscrete, junit 적용해봄.)    

핵심 포인트  
Hamcrest는 JUnit 기반의 단위 테스트에서 사용할 수 있는 Assertion Framework이다.  
Hamcrest는 다음과 같은 이유로 JUnit에 지원하는 Assertion 메서드 보다 더 많이 사용된다.  
Assertion을 위한 매쳐(Matcher)가 자연스러운 문장으로 이어지므로 가독성이 향상 된다.  
테스트 실패 메시지를 이해하기 쉽다.  
다양한 Matcher를 제공한다.  
Hamcrest 만으로 던져진(thrown) 예외를 테스트 하기 위해서는 Custom Matcher를 직접 구현해서 사용할 수 있다.  

슬라이스 테스트란?  
개발자가 각 계층에 구현해 놓은 기능들이 잘 동작하는지 특정 계층만 잘라서(Slice) 테스트하는 것을 슬라이스 테스트(Slice Test)라고 함. (API, Database...)
vs 단위테스트는 매서드단위.  

핵심 포인트  
개발자가 각 계층에 구현해 놓은 기능들이 잘 동작하는지 특정 계층만 잘라서(Slice) 테스트하는 것을 슬라이스 테스트(Slice Test)라고 한다.  
@SpringBootTest 애너테이션은 Spring Boot 기반의 애플리케이션을 테스트 하기 위한 Application Context를 생성한다.  
@AutoConfigureMockMvc 애너테이션은 Controller 테스트를 위한 애플리케이션의 자동 구성 작업을 해준다.  
MockMvc는 Tomcat 같은 서버를 실행하지 않고 Spring 기반 애플리케이션의 Controller를 테스트할 수 있는 완벽한 환경을 지원해주는 일종의 Spring MVC 테스트 프레임워크이다.  
MockMvc로 테스트 대상 Controller의 핸들러 메서드에 요청을 전송하기 위해서는 기본적으로 perform() 메서드를 먼저 호출해야 한다.  
MockMvcRequestBuilders 클래스를 이용해서 빌더 패턴을 통해 request 정보를 채워 넣을 수 있다.  
MockMvc의 perform() 메서드가 리턴하는 ResultActions 타입의 객체를 이용해서 request에 대한 검증을 수행할 수 있다.  


핵심 포인트  
데이터 액세스 계층 테스트 시에는 테스트 종료 직 후, DB의 상태를 테스트 케이스 실행 이전으로 되돌려서 깨끗하게 만든다.  
@DataJpaTest 애너테이션을 사용하면 Spring Data JPA 환경에서 데이터 액세스 계층의 테스트를 손쉽게 진행할 수 있다.  
@DataJpaTest 애너테이션은 @Transactional 애너테이션을 포함하고 있기 때문에 하나의 테스트 케이스 실행이 종료되는 시점에 데이터베이스에 저장된 데이터는 rollback 처리된다.  
  
  
  
  
학습 목표  
Mock의 의미를 이해할 수 있다.  
Mockito의 기본 사용법을 이해할 수 있다.  
비즈니스 로직의 단위 테스트에 Mockito를 적용할 수 있다.  
Controller의 슬라이스 테스트에 Mockito를 적용할 수 있다.  
TDD(Test Driver Development)의 개념을 이해할 수 있다.  


Mock이란?  
테스트 세계에서의 Mock은 바로 가짜 객체를 의미합니다.  
그리고 단위 테스트나 슬라이스 테스트 등에 Mock 객체를 사용하는 것을 바로 Mocking  
  
우리가 작성한  slice/controller/member 패키지의 MemberControllerTest를 보면,  
그 안의 매서드(postMemberTest)를 실행하려면,  
(MemberControllerTest)postMemberTest, (MemberController)postMember, (MemberService)createMember, (MemberRepository)save 까지 가야함.  
불필요한 전 계층을 다 거쳐야 되기 때문에 성능 면에서나 테스트 관심 영역 면에서나 슬라이스 테스트의 주 목적에 맞지않음.  
  
위의 문제를 해결하기 위해 Mock 객체를 사용하면 우리가 작성한 MemberController에 진정한 슬라이스 테스트를 적용. (뭔소린가 싶으면 3.8캡쳐 보기)  
그렇게 적용되면 MemberService 대신 MockMemberService가 리파지토리와 db까지 갈일없이 해결.  
  
이러한 Mock객체를 사용하게 해주는 라이브러리가 Spring Framework에서 지원하는 Mockito 라이브러리.  
slice/mock 패키지의 MemberControllerMockTest 클래스에 적용해봄.  
MockMemberService(가칭) 클래스는 우리가 테스트하고자 하는 Controller의 테스트에 집중할 수 있도록 다른 계층과의 연동을 끊어주는 역할.  
이처럼 Mockito를 잘 이용하면 의존하는 다른 메서드 호출이나 외부 서비스의 호출을 단절 시킬 수 있기 때문에 우리가 원하는 테스트의 범위를 최대한 좁힐 수 있음.  
  
MemberService 클래스의 verifyExistsEmail() 매서드는  
파라미터로 전달 받은 email을 조건으로 한 회원 정보가 있는지 memberRepository.findByEmail(email)을 통해 DB에서 조회.  
하지만 우리는 verifyExistsEmail() 메서드가 DB에서 Member 객체를 잘 조회하는지 여부를 테스트 하려는게 아니라,  
어디서 조회해 왔든 상관없이 조회된 Member 객체가 null이면 BusinessLogicException 을 잘 던지는지 여부만 테스트하면 됨.  
따라서 MemberService 클래스의 verifyExistsEmail() 매서드도 Mocking의 대상. → mock 패키지의 MemberServiceMockTest 클래스.  

핵심 포인트  
테스트 세계에서의 Mock은 바로 가짜 객체를 의미한다.  
Mockito는 Mock 객체를 생성하고, 해당 Mock 객체가 진짜처럼 동작하게 하는 기능을 하는 Mocking framework(또는 라이브러리)이다.  
@MockBean 애너테이션은 Application Context에 등록되어 있는 Bean에 대한 Mockito Mock 객체를 생성하고 주입해주는 역할을 한다.  
Junit에서 Spring을 사용하지 않고 순수하게 Mockito의 기능만을 사용하기 위해서는 @ExtendWith(MockitoExtension.class)를 클래스 레벨에 추가해야 한다.  
@Mock 애너테이션을 추가하면 해당 필드의 객체를 Mock 객체로 생성한다.  
@Mcok 애너테이션을 통해 생성된 Mock 객체는 @InjectMocks 애너테이션을 추가한 필드에 주입된다.  
  
TDD 추가. (테스트 주도 개발)  
⭐ TDD의 개발 방식은   
‘실패하는 테스트 → 실패하는 테스트를 성공할 만큼의 기능 구현 → 성공하는 테스트 → 리팩토링 → 실패하는 테스트와 성공하는 테스트 확인’   
이라는 흐름을 반복  

TDD의 특징 정리  
앞에서 간단한 기능을 구현해 보면서 살펴보았던 TDD의 특징을 다시 한번 정리해 보겠습니다.  
TDD는 모든 조건에 만족하는 테스트를 먼저 진행한 뒤에 조건에 만족하지 않는 테스트를 단계적으로 진행하면서 실패하는 테스트를 점진적으로 성공시켜 갑니다.  
TDD는 테스트 실행 결과가 “failed”인 테스트 케이스를 지속적으로 그리고 단계적으로 수정하면서 테스트 케이스 실행 결과가 “passed”가 되도록 만들고 있습니다.  
TDD는 테스트가 “passed” 될 만큼의 코드만 우선 작성합니다.  
TDD는 ‘실패하는 테스트 → 실패하는 테스트를 성공할 만큼의 기능 구현 → 성공하는 테스트 → 리팩토링 → 실패하는 테스트와 성공하는 테스트 확인’ 이라는 흐름을 반복합니다.  
