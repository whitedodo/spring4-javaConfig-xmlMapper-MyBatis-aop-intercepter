# Spring Framework 4.2.4 Releases에서 root-context.xml, web.xml, app-context.xml 제거, 그리고 Interceptor 구현하기(2), AOP, @Transactional 적용
(Remove root-context.xml, web.xml, app-context.xml from Spring Framework 4.2.4 Releases, implement Interceptor (2), apply AOP, @Transactional)

### 기본 정보(Information)
##### 제작일자(Create date): 2020-10-18
##### 작성언어(Write language): Java
##### IDE: Eclipse IDE with Spring Tool Suite 4-4.7.2.
##### 제작자(Author): 도도(Dodo) / rabbit.white at daum dot net
##### 프레임워크(Framework): 
##### 라이브러리(Library): 
##### 1. Apache-Maven 3.6.3/1.16.0.2.20200610-1735 (https://maven.apache.org/)
##### (소프트웨어 프로젝트 관리 및 이해 도구)
##### 2. Spring Framework 4.2.4 RELEASES
##### 3. Spring-test 4.2.4 RELEASES
##### 4. Servlet 3.1 
##### (매우 중요함. Servlet 3.1부터 지원하는 작업이다.)
##### (very important. It is supported from Servlet 3.1.)
##### 5. MyBatis (3.5.6)
##### 6. mybatis-spring (2.0.5)
##### 7. commons-dbcp2 (2.8.0)
##### 8. aspectjweaver
##### 9. spring-tx
##### 10. spring-jdbc

##### 
##### 기타 설정(Other settings)
##### 1. pom.xml의 환경설정이 매우 중요함.
##### <groupId>org.apache.maven.plugins</groupId>
##### 	<failOnMissingWebXml>false</failOnMissingWebXml>
##### 	<version>3.2.0</version>
##### 2. com.{패키지명}.config
#####     Initializer.java, RootConfig.java, WebMvcConfig.java 설정이 필수임.
#####     (Initializer.java, RootConfig.java, WebMvcConfig.java setting is required.)

### 1. 소개(Description)
##### 1. 해당 프로젝트는 web.xml, root-context.xml, app-servlet.xml을 걷어내고 Java방식으로 작업하였다.
#####    (For the project, web.xml, root-context.xml, and app-servlet.xml were removed and worked in Java method.)
##### 2. UTF-8을 통한 한글 문제까지 해결하였다. (It even solved the Korean language problem through UTF-8.)
##### 3. 스프링 인터셉터를 활용하여 맴버십 보안 기능을 적용하였다.
#####    (Membership security function was applied using Spring Interceptor.)
##### 4. 스프링 인터셉터로 preHandler, postHandler로 페이지를 관리하였다.
#####    (Pages were managed with preHandler and postHandler with Spring Interceptor.)

### 2. 시연(Practice)
##### 1. 

### 3. 참고자료(References)

