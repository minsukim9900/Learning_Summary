# 전공 Web(Back) - Servlet

## WebArchitecture

<aside>

### Client

- Web Browser (data 발생)
</aside>

↓ 요청(request)     ↑ 응답(response)

<aside>

### Server

- Web Server
    
    Client 접속, 응답 page 처리
    

    ↓

- Application Server (Client 요청에 대한 Logic 처리)
    - Business Logic
    - Persistence Logic
        
        ↓ ↑ ( JDBC)
        
        RDBMS
        
    - Presentation
- RDBMS
    
    Database
    
</aside>

<aside>

### WAS (Web Application Server (WAS)

Web Server + Application Server

</aside>

## Servlet

Context root  ⇒ memory 식별자

Content directory ⇒ src/main/webapp 폴더까지 들어가줄게!

<aside>

### Servlet?

자바 서블릿(Java Servlet)은 자바를 사용하여 웹페이지를 동적으로 생성하는 서버측 프로그램 혹은 그 사양을 말하며, 흔히 “서블릿”이라 불린다.

서블릿은 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종

서블릿은 JSP와 비슷한 점이 있지만, JSP가 HTML 문서 안에 Java 코드를 포함하고 있는 반면, 서블릿은 자바 코드 안에 HTML을 포함하고 있다는 차이점이 있다.

자바 서블릿은 자바 EE 사양의 일부분으로, 주로 이 기능을 이용하여 쇼핑몰이나 온라인 뱅킹 등의 다양한 웹 시스템이 구현되고 있다.

비슷한 기술로는 펄 등을 이용한 CGI, PHP를 아파치 웹 서버 프로세스에 동작하게 하는 mod…php, 마이크로소프트사의 IIS에서 동작하는 ASP등이 있다.

CGI는 요청이 있을 때마다 새로운 프로세스가 생성되어 응답하는 데 비해, 자바 서블릿은 외부 요청마다 프로세스보다 가벼운 스레드로써 응답하므로 보다 가볍다.

또한, 자바 서블릿은 자바로 구현 되므로 다양한 플랫폼에서 동작한다.

</aside>

### Page 이동

1. 주소 직접 url 입력 → Get
2. link(a태그 또는 버튼) → Get
3. form
    1. Get
    2. Post

### Servlet 배포(Deployment Descriptor)

- web.xml
    - <servlet>과 <servlet-mapping> 한 쌍
    - <url-pattern>
        - URL 경로 : ‘/’로 시작하는 /*
        - 확장자 매칭 : ‘*’로 시작하는 *.확장자
        - default servlet : /
        - 정확한 경로와 이름 매칭 : /basic
        - 경로와 확장자를 함께하는 매칭은 지원 안함 : /basic/*.do
- @WebServlet
    - servlet 3.0부터 web.sml 대신 Annotation을 사용하여 설정
    - 한개의 URL 설정 : urlPatterns = “/hello” 또는 value=”/hello” 또는 @WebServlet(”/hello”)
    - 여러 개의 URL 설정 : urlPatterns = {”/hello”, “*.ssafy”)

## Servlet Life-Cycle

### Servlet Life-Cycle

Servlet class는 javaSE에서의 class와는 다르게 main method가 없다.

즉 객체의 생성부터 사용(method call)의 주체가 사용자가 아닌 Servlet Containter에게 있다.

Client가 요청(request)을 하게 되면 Servlet Container는 Servlet 객체를 생성(한번만)하고, 초기화(한번만) 하면 요청에 대한 처리(요청시마다 반복)를 하게 된다. 또한 Servlet 객체가 필요 없게 되면 제거하는 일까지 Container가 담당하게 된다.