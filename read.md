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

###纯java代码配置Bean【spring-07-note】


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