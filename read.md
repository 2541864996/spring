#Spring
##简介：
1.Spring;春天————>给软件行业带来了春天

2.2002年首次推出了spring的雏形:interface21框架

3.spring框架即以interface21框架为基础,经过重新设计,并不断丰富其内涵,于2004年3月24日发布1.0正式版

4.Rod johnson：音乐学并非计算机学

5.spring理念:使现有技术更容易使用，是一个大杂烩，整合了现有的技术框架

- 优点:

1.spring 是一个开源的免费框架(容器)

2.spring是一个轻量级、非入侵式的框架

3.特性：控制反转(IOC),面向切面编程(AOP)

4.支持事务的处理,对框架的整合支持

总结:Spring就是一个轻量级的控制反转(IOC)和面向切面编程(AOP)的框架

###控制反转
- 就是对象由spring来创建管理、装配
###Bean容器
- 相当于Bean的配置文件【spring-01-ioc】

- 控制：谁来控制对象的创建，传统应用程序中的对象是由程序本身控制创建的，使用spring后只要将对象配置到bean中，对象就有spring来创建
- 反转：程序本身不创建对象，而变成被动的接收对象
- IOC的一种编程思想,由主动的编程变为被动的接收

##常用依赖
```xml
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.0.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/junit/junit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
```
##IOC创建对象的方式
###利用构造方法创建bean【spring-02-di】

###Spring的配置【spring-03-ioc】
- 别名
- Bean上配置别名
- import:适用于团队开发

###依赖注入(利用set方法)【spring-04-di】

###Bean的作用域【spring-05-actionScope】
1.单例模式(默认)，全部的User对象都只有一个
2.原型模式:每次从容器中取出的都是一个新的对象

###自动装配【spring-06-Autowired】
####ByName自动装配
```xml
<bean id="dog" class="com.Dog"/>
<bean id="cat" class="com.Cat"/>
<!--byname:会自动在容器上下文中查找，和自己对象的set方法后面值对应的beanid-->
<bean id="people" class="com.People" autowire="byName"/>
```

####ByType自动装配
```xml
<bean id="dog" class="com.Dog"/>
<bean id="cat" class="com.Cat"/>
<!--byname:会自动在容器上下文中查找，和自己对象的set方法后面值对应的beanid-->
<bean id="people" class="com.People" autowire="byType"/>
```
小结:byName的时候需要保证beanid的唯一，并且这个bean需求和自动注入的属性set方法的值一致
     byType的时候需要保证所有的bean的class唯一，并且这个bean需要和自动注入的属性类型一致

###Autowired注解
```java
class User{
    private Cat cat;
    private Dog dog;
}
```
>如果bean中有Cat和Dog这两个的bean就可以利用@Autowired来赋值

>但是要在xml中引入：xmlns:aop="http://www.springframework.org/schema/aop"

>并且在xsi:schemaLocation中添加
>http://www.springframework.org/schema/aop
 http://www.springframework.org/schema/aop/spring-aop.xsd
>
>开启注解支持
><context:annotation-config/>
>
>指定扫描的包
><context:component-sacn base-package="com.xxx"/>
####属性注入
```java
@Component
public class User{
    public String name;
    @Value("wxm")
    public void setName(String name){
        this.name=name;
    }
}
```

###纯java代码配置Bean
实体类
```java
@Component
public class User{
    private String name;
    public String getName(){
        return name;
    }
    @Value("wxm")//属性注入
    public void setName(String name){
        this.name=name;
    }

}
```
配置类
```java
@Configuration//代表一个配置类，相当于一个bean.xml文件
@ComponentScan("com")//要扫描的包
@Import(Config2.class)//引入其他的配置类
public class Config1{
    @Bean//方法名就是bean的id ，返回值就是bean的class
    public User user(){
        return new User();
    }
}
```
获取
```java
ApplicationContext context=new AnnotationConfigApplicationContext(Config1.class);
User user=context.getBean("user",User.class);
```
利用AnnotationConfigApplicationContext来读取一个配置类

获得ApplicationContext容器
##spring注解说明
- @Autowired:自动装配通过类型，名字
    如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
- @Nullable :字段标记了这个注解，说明这个字段可以为null;
- @Resource :自动装配通过名字，类型
- @Component有几个衍生注解，在为欧盟web开发中会按照mvc三层架构分层

      dao：@Repository
      service:@Service
      controller:@Controller
      这4个注解功能都是一页的，都代表将某个类注册到spring中，装配bean
- @Scope("prototype")原型模式   singleton单例模式(将注解放到类上即可，前提这个类由spring托管)


##AOP
依赖
```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>

```