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
- 相当于Bean的配置文件
```java
//通过配置bean.xml来管理对象
//先创建beans.xml 引入模板
/**<?xml version="1.0" encoding="UTF-8"?>
  *<beans xmlns="http://www.springframework.org/schema/beans"
  *   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  *   xmlns:p="http://www.springframework.org/schema/p"
  *   xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
  *    <bean id="user" calss="User">
  *        <property name="name" value="啊黄"/>    
  *    </bean>
  *</beans>
  */
//配置bean
//<property可以给属性设值 value是普通值 ref是引用一个bean>
//利用ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
//User user=context.getBean("user",User.class);
```
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
###有参构造器注入
- 下标
```xml
<bean id="user" class="com.User">
    <constructor-ary index="0" value="xxx"/>
    <!--要使用有参构造必须给类的属性赋值
        index代表下标,0代表第一个参数
        value代表这个参数的值
    -->
</bean>
```
- 类型
```xml
<bean id="user" class="com.User">
    <constructor-ary type="java.lang.String" value="xxx"/>
    <!--要使用有参构造必须给类的属性赋值
        type类型,根据类型来匹配构造器中的值类型匹配的
        value代表这个参数的值
        弊端：多个相同类型就会出错
    -->
</bean>
```
- 参数名
```xml
<bean id="user" class="com.User">
    <constructor-ary name="name" value="xxx"/>
    <!--要使用有参构造必须给类的属性赋值
        name代表构造器中的方法名
        value就是要注入的值
    -->
</bean>
```
总结：在配置文件加载的时候，容器中管理的对象已经初始化了
ApplicationContext:就代表着Spring容器

###Spring的配置
- 别名
>如果添加了别名，我们也可以使用这个别名获取这个对象
>如：
```xml
<alias name="user" alias="newUser"/>
<!--name 就是一个bean的id值;alias 就是要修改的别名-->
<!--getBean时即可以用原来的user也可以用这个别名获取-->
```

- Bean的配置
```xml
<bean id="user" class="com.User" name="u1 u2,u3;u4"/>
<!--id就是当前bean的唯一标识，相当于名字  class是这个bean的类型(类全限定名)  name是这个叫user的bean的别名(可以有多个,逗号 空格 分号都能进行分割)-->
```

- import:适用于团队开发
>假设有多人在开发程序,每个人都有他的类和他的beans.xml文件
>
>我们就可以设置一个总的application.xml文件,在中引入其他人的xml就可以了
```xml
<import resource="beans1.xml"/>
<import resource="beans2.xml"/>
<import resource="beans3.xml"/>
```
>最后只要读取这个application.xml文件就可以获取到引入中的bean

###依赖注入(利用set方法)
```java
//利用下方的一些注入方式给这个类注入属性值
class User{
    private String age;
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbys;
    private Map<String,String> card;
    //get和set方法
}
```
1.普通注入
```xml
<bean id="user" class="com.User">
    <property name="name" value="wxm"/>
</bean>
```
2.bean注入
```xml
<bean id="user" class="com.User">
    <property name="address" ref="address"/>
    <!--name为set方法中的名字  ref 就是引用一个叫某某某的bean-->
</bean>
```
3.数组
```xml
<bean id="user" class="com.User">
    <property name="books">
        <array>
            <value>红楼梦</value>
            <value>西游记</value>
            <value>三国演义</value>
        </array>
    </property>
    <!--name为set方法中的名字(当前这个是个数组,要给他注入值)-->
</bean>
```
4.List集合
```xml
<bean id="user" class="com.User">
    <property name="hobbys">
        <list>
            <value>听歌</value>
            <value>玩游戏</value>
        </list>
    </property>
    <!--name为set方法中的名字(这是个list集合)-->
</bean>
```
5.Map
```xml
<bean id="user" class="com.User">
    <property name="card">
        <map>
            <entry key="学生卡" value="1213123123"/>
            <entry key="身份证" value="1213123123"/>
        </map>
    </property>
</bean>
```
6.p命名空间注入，可直接注入属性的值：property
```xml
<bean id="user" class="User" p:name="wxm" p:age="19"/>
<!--使用前提
    在bean.xml引入 xmlns:p="http://www.springframework.org/schema/p"
    属性必须有set方法
-->
```
7.c命名空间注入,通过构造器注入，construct
```xml
<bean id="user" class="User" c:name="wxm" c:age="19"/>
<!--使用前提
    在bean.xml引入 xmlns:c="http://www.springframework.org/schema/c"
    类必须有有参构造器
-->
```
###Bean的作用域
1.单例模式(默认)，全部的User对象都只有一个
```xml
<bean id="user" class="com.User" scope="singleton"/>
```
2.原型模式:每次从容器中取出的都是一个新的对象
```xml
<bean id="user" class="com.User" scope="prototype"/>
```



##spring注解说明
- @Autowired:自动装配通过类型，名字
    如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
- @Nullable :字段标记了这个注解，说明这个字段可以为null;
- @Resource :自动装配通过名字，类型