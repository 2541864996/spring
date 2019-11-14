###SpringAOP.2
必须依赖
```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.3</version>
        </dependency>
```
####第二种方式(自定义实现AOP【】)
- 创建一个切面的类(DiyPointCut)
- 定义一些切入的方法
```java
public class DiyPointCut {
    public void before(){
        System.out.println("=====在方法之前执行=====");
    }
    public void later(){
        System.out.println("=====在方法之后执行=====");
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
    <bean id="diy" class="diy.DiyPointCut"/>
```
- 自定义切面将方法切入切入点中
```xml
<aop:config>
        <!--自定义切面 定义一个类为切面-->
        <aop:aspect ref="diy">
            <!--切入点-->
            <aop:pointcut id="userServicePointcut" expression="execution(* service.UserServiceImpl.*(..))"/>
            <!--通知 将什么方法切入到什么类中-->
            <aop:after method="before" pointcut-ref="userServicePointcut"/>
            <aop:before method="later" pointcut-ref="userServicePointcut"/>
        </aop:aspect>
    </aop:config>
```
- 利用ClassPathXmlApplicationContext读取配置文件获取到AppilcationContext容器测试
```java
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService)context.getBean("userService");
        userService.add();
    }
}
```
结果
