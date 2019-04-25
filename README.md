# SpringBootDemo
Hello Spring Boot

## Notes

### CGI

- WebServer和处理HTTP请求程序之间约定的一种协议
- 一个HTTP请求会fork一个进程，提供给这个进程CGI的环境变量
- CGI是一种规范，与语言无关，可用`perl` `php` `C`等实现
- 缺点：fork进程，CGI程序的可移植性和可维护性

### Servlet

- Java技术栈
- Servlet容器`Tomcat` `Jetty`
- 在 Servlet 3 中，我们可以继承 `ServletContainerInitializer` 来实现替代 `web.xml` 的作用

### JSP

- 运行时编译成Servlet

### Spring

- AOP 
- IOC

### Spring MVC

- ApplicationContext负责搜索、创建、装配Bean

  - ClassPathXmlApplicationContext 解析xml

- DI三种方式

  - xml

  - anotation

  - Java Config

    ```java
    @Configuration
    @ComponentScan("com.skyline")
    public class AppConfig {
      @Bean
      public MyServiceImpl myService() {
        return null;
      }
    }
    ```

- 依赖注入的相关注解

  - @Component @Service @Repository @Controller
  - @Bean
  - @Autowired

### Spring Boot

- 升级版Spring MVC，避免了繁琐和不必要的配置
- 内置tomcat
- 内置hibernate

### Others

- JavaWeb J2EE JavaEE JEE: 同一个东西`Java Platform, Enterprise Edition`
- POJO: `Plain Old Java Object` 对外部没有任何依赖的Java类，无基类未实现接口
- JavaBean: 
   - 无参构造器
   - 成员为`private`提供`setter` `getter`
   - ~~实现Serializable~~
- EJB

