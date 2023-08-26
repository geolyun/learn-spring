강한 결합과 느슨한 결합(Tightly Coupling and Loose Coupling)<br/>
결합이란 무언가를 변경하는 데 얼마나 많은 작업이 관련되어 있는지에 대한 측정<br/>


ex) 노트북은 특정 공간에 강하게 결합되어 있지 않는 느슨한 결합<br/>
컴퓨터는 움직이기 힘드므로 강한 결합<br/>


+ 인터페이스는 특정 클래스 세트에서 수행할 수 있는 공통된 작업을 나타냄<br/>
현재 프로젝트의 GameRunner 클래스는 특정 게임에 강하게 결합되어 있다. 변경하고자 할 때는 반드시 GameRunner 클래스 코드를 변경해야만 코드가 작동함.<br/>
근데 GamingConsole 인터페이스를 도입함으로써 GameRunner 클래스가 특정 게임에서 분리됨<br/>


Spring 컨테이너 = Spring Context = IOC Context : Spring Bean과 수명 주기를 관리


IOC Container에는 두 가지가 있다.<br/>
1. Bean Factory - 이는 기본적인 Spring Container<br/>
2. Application Context - 엔터프라이즈 전용 기능이 있는 고급 Spring Container<br/>


8/6


- POJO vs Java Bean vs Spring Bean<br/>

Java Bean은 3가지 제약을 준수하는 클래스(public 기본 생성자, no-arg 생성자, 게터와 세터 메서드, Java Serializable을 구현)<br/>

POJO 클래스는 아무 제약이 없으며, 모든 Java 객체는 POJO<br/>

Spring Bean은 Spring이 관리하는 모든 Java 객체<br/>


8/7


@Primary vs @Qualifier<br/>
Primary는 여러 후보가 자격이 있는 경우, Bean에게 우선권을 주는 것을 말한다.<br/>
Qualifier는 특정하게 지정된 Bean을 자동 와이어링하는 것을 말한다.<br/>

@Autowired만 사용한다면 가장 적합한 SortingAlgorithm을 달라고 요청한다.<br/>
하지만 @Autowired + @Qualifier은 특정 SortingAlgorithm만을 사용하고자 한다고 말한다.<br/>
@Qualifier가 @Primary보다 더 높은 우선순위를 가지고 있음<br/>


의존성 주입에는 3개의 유형이 존재한다. Constructor-based, Setter-based, Field
주입을 하는데 생성자를 사용하는 방법은 Constructor-based 주입이다.<br/>
Setter 메소드를 사용해서 주입을 하는 경우 Setter-based 주입이다.<br/>
Setter나 생성자가 없다면 reflection을 이용하여 주입하는 데 이것이 필드 주입이다.<br/>


중요한 용어<br/>
@Component : @Component를 클래스에 추가하는 경우, 클래스의 인스턴스는 Spring 프레임워크가 관리하게 된다.<br/>
Component Scan : @ComponentScan은 해당 애너테이션이 작성된 패키지 이하의 클래스들을 순회하며 빈으로 등록될 객체들을 탐색한다.<br/>
의존성 주입 : Bean과 의존성을 식별하고 모두 와이어링하는 작업<br/>
Spring Beans : Spring 프레임워크가 관리하는 모든 객체<br/>
IOC container : Bean의 생명 주기와 의존성을 관리하는 Spring 프레임워크의 컴포넌트<br/>


8/9


Lazy 어노테이션은 Bean을 지연하여 초기화할지 여부를 나타내준다.<br/>
Spring Bean의 기본 초기화는 즉시 초기화<br/>
항상 즉시 초기화를 권장 - Spring 구성에 오류가 있을 경우 즉시 초기화를 사용하면 애플리케이션이 시작할 때 오류를 바로 확인할 수 있다.<br/>


지연 초기화 vs 즉시 초기화<br/>
지연 초기화의 경우 Bean은 애플리케이션에서 처음 사용될 때 초기화된다.<br/>
즉시 초기화일 때는 Bean은 애플리케이션이 시작되거나 Spring Context가 시작될 때 초기화된다.<br/>


Spring Bean 스코프에는 싱글톤, 프로토타입 두 가지가 있다.<br/>
싱글톤은 Spring IoC 컨테이너당 객체 인스턴스가 딱 하나이다.<br/>
프로토타입은 Spring IoC 컨테이너당 객체 인스턴스가 여러 개일 수 있다.<br/>


- 이외에도 웹 애플리케이션에서만 특정하게 적용되는 스코프가 있는 데 web-aware ApplicationContext이다.
리퀘스트 스코프는 HTTP 요청당 객체 인스턴스 하나가 생성<br/>
세션 스코프는 사용자 HTTP 세션당 객체 인스턴스 하나가 생성<br/>
애플리케이션 스코프는 웹 애플리케이션 전체에 객체 인스턴스가 하나이다.<br/>
웹소켓 스코프에도 만들 수 있는데, 웹소켓 인스턴스당 객체 인스턴스가 하나이다.<br/> 


위의 4개는 web-aware ApplicationContext를 사용하는 경우에만 사용할 수 있다.<br/>


- Prototype vs Singleton Bean Scope<br/>
프로토타입에 생성되는 인스턴스는 Spring IoC 컨테이너 하나당 여러 개가 될 수 있다. 프로토타입에서는 Bean을 참조할 때마다 새로운 Bean 인스턴스가 생긴다.<br/>
싱글톤의 경우 Spring IoC 컨테이너 하나당 인스턴스는 하나이다. 싱글톤에서는 같은 Bean 인스턴스를 다시 사용한다. 거의 싱글톤이 사용됨<br/>


@PostConstruct란?


@PostConstruct는 의존성 주입이 이루어진 후 초기화를 수행하는 메서드이다. @PostConstruct가 붙은 메서드는 클래스가 service(로직을 탈 때? 로 생각 됨)를 수행하기 전에 발생한다. 이 메서드는 다른 리소스에서 호출되지 않는다해도 수행된다. <br/>


@PreDestroy란?


컨테이너에서 객체를 제거하기 전에 수행해야 하는 callback 메소드에 사용하는 어노테이션


8/10


- Jakarta CDI<br/>
CDI는 규격이고 인터페이스이다.<br/>
CDI의 중요한 어노테이션에는 Inject(Autowired in Spring), Named(Component in Spring), Qualifier, Scope, Singleton이 있다.<br/>


8/12


- Spring 스테레오타입 어노테이션<br/>

@Component : 모든 Spring 스테레오타입 어노테이션의 기초이다.<br/>
[ @Component의 세분화<br/>
* @Service는 보통 어노테이션한 클래스에 비즈니스 논리가 있음을 나타낸다. 클래스에 비즈니스 논리가 있다면 @Component 대신 @Service를 사용할 수 있다.<br/>
* @Controller는 웹 애플리케이션과 REST API에서 컨트롤러를 정의하는 데 사용된다.<br/>
* @Repository는 Bean이 데이터베이스와 통신하는 경우, 데이터를 저장하거나 검색하거나 조작하는 경우에 @Component 대신 사용]<br/>

- Spring Annotation 복습<br/>
-@Configuration은 클래스가 @Bean 메서드를 하나 이상 선언함을 나타낸다. Spring 컨테이너에서 처리하여 Bean 정의를 생성한다.<br/>
-@ComponentScan은 컴포넌트를 스캔할 특정 패키지를 정의한다.<br/>
-@Component는 어노테이션한 클래스가 컴포넌트임을 나타내준다.<br/>
-@Service 어노테이션한 클래스에 비즈니스 논리가 있음을 나타내는 @Component의 한 종류이다.<br/>
-@Controller는 어노테이션한 클래스가 컨트롤러임을 나타내는 @Component의 한 종류인데 일반적으로 웹 애플리케이션과 REST API에서 컨트롤러를 정의하는 데 사용된다.<br/>
-@Repository는 어노테이션한 클래스가 데이터베이스에서 데이터를 검색하거나 조작하는 데 사용된다는 의미이다.<br/>
-@Primary는 여러 Bean이 단일 값 의존성에 자동 연결될 후보일 때 Bean에 우선 순위를 부여해야 함을 나타낸다.<br/>
-@Qualifier는 자동 연결 시 후보 Bean의 한정자로 필드나 매개변수에서 사용된다.<br/>
-@Lazy는 Bean을 지연 초기화하려고 할 때 사용한다.<br/>
-@PostConstruct는 의존성 주입이 수행된 이후 초기화를 위해 실행될 메서드를 나타낸다.<br/>
@PreDestory는 컨테이너에서 인스턴스를 삭제하는 과정을 거치고 있음을 알려주는 콜백 알림을 수신하는 메서드를 나타낸다. 보통 특정한 Bean에서 보유하고 있는 리소스를 해제하는 데 사용된다.<br/>


+ 스프링 생태계는 왜 인기가 많을까?<br/>
1. Spring에서는 느슨한 결합이 가능하다. Spring은 Bean 생성과 Bean의 의존성 연결을 관리한다. 느슨하게 결합하여 유지보수가 가능한 애플리케이션을 아주 쉽게 만들 수 있다는 말이다.<br/>
2. Boilerplate 코드를 줄여준다. Spring을 이용하면 비즈니스 논리에 집중할 수 있다.<br/>
3. 아키텍쳐 유연성. 사용할 모듈과 프로젝트를 고르고 선택할 수 있다.<br/> 
4. 시간에 따라 점차 발전한다.<br/>


8/14


빠른 빌드<br/>
Spring Initalizer<br/>
Spring Boot Starter Projects<br/>
Spring Boor Auto Configuration<br/>
Spring Boot DevTools<br/>

프로덕션 준비<br/>
Logging<br/>
Different Configuration for Different Environments<br/>
Monitering<br/>


Exploring Spring Boot Starter Projects<br/>

애플리케이션을 만드려면 수많은 프레임워크가 필요하다<br/>
- REST API 만들기 : Spring, Spring MVC, Tomcat, JSON conversion<br/>
- Unit Tests 쓰기 : Spring Test, JUnit, Mockito<br/>
가장 큰 문제는 이러한 프레임워크를 그룹화해서 애플리케이션을 쉽게 빌드할 수 있는가?이다.<br/>
이러한 문제를 해결해주는 Starter Project는 다양한 기능을 위한 편리한 의존성 디스크립터를 제공한다.<br/>

* Spring Boot Starter Project는 편리한 의존성 디스크립터이다. 특정 종류의 애플리케이션을 빌드하려면 일련의 의존성이 필요할 수 있다.<br/>


Exploring Spring Boot Auto Configuration<br/>
일반적으로 Spring Boot를 사용하여 웹 애플리케이션을 빌드할 때면 많은 설정이 필요하다.<br/> 
이러한 작업을 간소화하기 위해서 애플리케이션용 자동화 설정인 Auto Configuration을 쓰면 된다.<br/>


8/15


Spring Framework : 의존성 주입이 전부이다. 의존성을 정의하고 의존성을 식별하고 자동으로 연결하는 것이다. 하지만 의존성 주입만으로는 강력한 애플리케이션을 빌드할 수 없다. 이에 Spring Modules와 Spring Projects는 Spring 생태계를 확장하여 다른 프레임워크와 쉽게 통합할 수 있도록 지원한다.<br/>

Spring MVC는 Spring Module이다. 핵심은 웹 애플리케이션과 REST API의 빌드 과정을 간소화하는 것입니다. Spring MVC는 웹 애플리케이션을 쉽게 빌드하도록 지원한다.<br/>

Spring Boot는 Spring Project이다. 목표는 프로덕션 환경에 사용 가능한 애플리케이션을 빠르게 빌드하도록 지원하는 것.<br/>


8/16


JDBC와 Spring JDBC의 차이는 Spring JDBC로는 Java 코드를 훨씬 더 적게 써야한다.


8/18<br/>

- Spring Data JPA<br/>

JPA를 더 쉽게 만들어준다.<br/>
EntityManager도 신경 쓸 필요가 없게 만들어준다.<br/>


- Hibernate vs JPA<br/>

JPA는 기술 명세를 정의한다. 그것은 API이다.<br/>
엔티티가 무엇인지 정의하는 방식을 정의한다.<br/>
JPA를 이용하면 엔티티 정의, 속성 매핑 그리고 EntityManager를 활용하는 것까지 가능해진다.<br/>

Hibernate는 JPA에서 매우 인기 있는 구현체이다. 코드에서 Hibernate 어노테이션을 직접 사용하지 않는 이유는 Hibernate로만 한정해서 쓰고 싶지 않기 때문이다.<br/>


- Spring MVC Controller<br/>

@Controller은 주로 사용자의 요청을 처리하고 난 후 정해진 뷰 객체를 넘겨주는 역할을 합니다.<br/>

@ResponseBody는 자바 객체를 json 기반의 HTTP Body로 변환, 서버 -> 클라이언트 응답<br/>


- Dispatcher Servlet<br/>

A: HTTP 요청을 받는다.<br/>

B: HTTP 요청을 처리한다.<br/>
B1: 맨 먼저 적절한 컨트롤러 메서드를 식별해야 한다.<br/>
B2: 적절한 컨트롤러 메서드를 식별했으면 그 컨트롤러 메서드를 실행하게 된다. 그리고 컨트롤러 메서드는 모델과 뷰 이름을 리턴하게 된다.<br/>
B3: 렌더링할 적절한 뷰를 식별해야 한다. 그럼 dispatcher servlet은 view resolver과 대화하고 정확한 뷰 이름을 받게 된다.<br/>
B4: 그리고 뷰를 렌더링하게 된다.<br/>

C: 그 다음 HTTP 응답을 리턴함.<br/>


8/20

- Session vs Request Scopes<br/>

브라우저에서 오는 모든 요청은 서버에 배포된 우리의 웹 애플리케이션에 의해 처리된다.<br/>

Request Scope: 오직 하나의 요청에만 적용된다. 요청이 다시 전송되면 요청 속성은 메모리에서 삭제될 것이다. 그러므로 그 이후에 이루어지는 요청에는 사용할 수 없다.<br/>

Session Scope: 세부정보가 다수의 요청에 걸쳐 저장된다. 그러므로 세션에 저장할 때는 유의해야 한다. 그 이유는 추가로 메모리를 차지하고 모든 세부정보가 서버에 저장되기 때문이다.<br/><br/>


8/21<br/>

- Validations with Spring Boot<br/><br/>

1. 검증과 관련된 starter 프로젝트를 임포트하는 것<br/>
2. Command Bean 또는 Form Backing Object라는 개념을 사용하는 것 -> 이것을 하면 양방향 바인딩이라는 개념을 구현 가능<br/>
3. Bean에 검증을 추가하는 단계<br/>
4. 검증 오류를 뷰에 표시하는 단계<br/>


8/25<br/>

- 스프링 부트 자동설정이 편리하게 해주는 것<br/><br/>

JPA와 Spring Data JPA 프레임워크를 초기화해준다.<br/>
인메모리 데이터베이스인 H2도 시작시켜준다.<br/>
애플리케이션 대 데이터베이스 연결이 설정된다.<br/>
스크립트를 실행하려 한다면 그걸 설정하고 실행할 수 있게 해준다.<br/>


8/26<br/><br/>

- 백엔드에서 일어나는 일<br/>

1. 요청은 어떻게 처리될까?<br/>
요청은 가장 먼저 디스패처 서블릿으로 간다. 사용하는 URL과 상관없이 Spring MVC에서 모든 요청은 디스패처 서블릿이 처리하게 된다. 이걸 프런트 컨트롤러 패턴이라고 한다.<br/>
그리고 그 디스패처 서블릿은 자동 설정이라는 것에 의해 설정된다.<br/><br/>

2. 어떻게 객체가 JSON으로 변환되는가?<br/>
여기에는 @ResponseBody와 JacksonHttpMessageConverters 설정이 중요하다.<br/> 
@RestController안에 @ResponseBody 어노테이션이 포함되어 있는데 Bean을 있는 그래도 반환하라고 말하는 것과 같다.<br/>
Spring Boot 자동 설정이 설정한 기본 변환은 JacksonHttpMessageConverters를 사용한다. 이것 역시 자동 설정의 결과이다.<br/><br/>

3. 오류 매핑은 어디에서 설정하는가?<br/>
오류 페이지 역시 자동 설정의 결과이다. ErrorMvcAutoConfiguration<br/><br/>

4. 어떻게 이 모든 jar를 사용할 수 있을까?<br/>
Starter Projects - Spring Boot Starter Web 덕분이다.<br/><br/>



- REST API를 위한 요청 메서드<br/>

GET : 상세 정보를 검색할 때<br/>
POST : 새 리소스를 생성할 때<br/>
PUT : 기존 리소스를 업데이트할 때<br/>
PATCH : 리소스의 일부분을 업데이트할 때<br/>
DELETE : 리소스를 제거할 때<br/><br/>

(static 블록 초기화에 관한 링크 : https://hibiskim.tistory.com/9)
