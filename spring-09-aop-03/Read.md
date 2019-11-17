###SpringAOP.3
####第三种方式(注解实现)
- 创建切面类（AnnotationPointCut）
- 配置bean(创建xml文件)
>引入 xmlns:aop="http://www.springframework.org/schema/aop"
>http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd">
</beans>
```
- 开启spring注解支持
```xml
    <!--开启注解支持-->
    <aop:aspectj-autoproxy/>
```
- 将切面类注册到spring中
```xml
    <!--注册bean-->
    <bean id="userService" class="service.UserServiceImpl"/>
    <bean id="annotationPointCut" class="diy.AnnotationPointCut"/>
```
- @Aspect:放于类上即表示这个是个切面类(类必须交给spring管理)
```java
@Aspect//标注这是个切面
public class AnnotationPointCut {}
```
- @Before(切点【"execution(* service.UserServiceImpl.*(..))"】):表示在切入点方法前执行(作用于方法上)
```java
    //在切入点方法前执行
    @Before("execution(* service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("=====在方法之前执行=====");
    }
```
- @After(切点【"execution(* service.UserServiceImpl.*(..))"】):表示在切入点方法后执行(作用于方法上)
```java
    //在切入点方法结束后执行
    @After("execution(* service.UserServiceImpl.*(..))")
    public void later(){
        System.out.println("=====在方法之后执行=====");
    }
```
测试
```java
    public class MyTest {
        public static void main(String[] args) {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            UserService userService=(UserService)context.getBean("userService");
            userService.delete();
        }
    }
```
结果

![Image text](https://github.com/2541864996/spring-/blob/master/spring-09-aop-03/src/main/resources/img/ceshi.png?raw=true)

- @Around(切点【"execution(* service.UserServiceImpl.*(..))"】)
```java
    @Around("execution(* service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pj){
        Signature signature = pj.getSignature();
        System.out.println("签名:"+signature);
    }
```
>可以利用@Around注解 给方法传入一个ProceedingJoinPoint pj
>利用pj.getSignature();可以获取到当前运行的方法名
![Image text](https://github.com/2541864996/spring-/blob/master/spring-09-aop-03/src/main/resources/img/ceshi2.png?raw=true)