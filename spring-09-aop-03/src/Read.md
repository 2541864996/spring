###SpringAOP.3
####第三种方式(注解实现)
- 创建切面类（AnnotationPointCut）
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

![Image text]()
- @Around(切点【"execution(* service.UserServiceImpl.*(..))"】)
```java
    @Around("execution(* service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pj){
        Signature signature = pj.getSignature();
        System.out.println("签名:"+signature);
    }
```