###SpringAOP.1
必须依赖
```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.3</version>
        </dependency>
```
####第一种方式(Spring的API接口【主要是springAPI实现】)
- 创建log(日志)类
- 实现spring的接口MethodBeforeAdvice(前置的通知)
```java
//前置
public class Log implements MethodBeforeAdvice {

    //method：要执行的目标对象的方法
    //args：参数
    //target：目标对象
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"被执行了");
    }
}
```
- 或者AfterReturningAdvice(后置的通知，带返回值)
```java
//后置
public class AfterLog  implements AfterReturningAdvice {
    //returnValue:返回值
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了"+method.getName()+"返回的结果为："+returnValue);
    }
}
```
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
- 将通知类和要插入通知的类交给spring管理
```xml
 <!--注册bean-->
    <bean id="userService" class="service.UserServiceImpl"/>
    <bean id="afterLog" class="log.AfterLog"/>
    <bean id="log" class="log.Log"/>
```
- 配置切入点和环绕增强
```xml
    <!--方式一：使用原生的Spring api接口-->
    <aop:config>
        <!--切入点 expression:表达式 【execution(返回类型 包名 类 方法名(参数))】(固定写法)-->
        <aop:pointcut id="UserServicePointcut" expression="execution(* service.UserServiceImpl.*(..))"/>
        <aop:pointcut id="UserServicePointcut2" expression="execution(* service.UserServiceImpl.add())"/>

        <!--执行环绕增强-->
        <!--advice-ref：切入类 pointcut-ref：被切入的类-->
        <aop:advisor advice-ref="log" pointcut-ref="UserServicePointcut"/>
        <aop:advisor advice-ref="afterLog" pointcut-ref="UserServicePointcut"/>
    </aop:config>
```
- 利用ClassPathXmlApplicationContext读取配置文件获取到AppilcationContext容器测试
```java
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理代理的是接口：注意点
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
```
结果：
![Image text](https://github.com/2541864996/spring-/blob/master/spring-09-aop-01/src/main/resources/img/%E7%BB%93%E6%9E%9C.png?raw=true)

