####ByName自动装配
```xml
<bean id="cat" class="demo01.Cat"/>
<bean id="dog" class="demo01.Dog"/>
<!--byname:会自动在容器上下文中查找，和自己对象的set方法后面值对应的beanid-->
<bean id="user" class="demo01.User" autowire="byName"/>
```

####ByType自动装配
```xml
<bean id="cat" class="demo01.Cat"/>
<bean id="dog" class="demo01.Dog"/>
<!--byname:会自动在容器上下文中查找，和自己对象的set方法后面值对应的beanid-->
<bean id="user2" class="demo01.User2" autowire="byType"/>
```
小结:
    
    byName的时候需要保证beanid的唯一，并且这个bean需求和自动注入的属性set方法的值一致
    byType的时候需要保证所有的bean的class唯一，并且这个bean需要和自动注入的属性类型一致

###Autowired注解
```java
class User{
     //自动注入 也可以写到set方法上面
     @Autowired
     private Bolt bolt;
     //自动注入
     @Autowired
     private Garfield garfield;
}
```
>如果bean中有Cat和Dog这两个的bean就可以利用@Autowired来赋值

>但是要在xml中引入：
```xml
xmlns:context="http://www.springframework.org/schema/context"
```

>并且在xsi:schemaLocation中添加
```xml
http://www.springframework.org/schema/context
http://www.springframework.org/schema/context/spring-context-3.0.xsd
```
>开启注解支持
```xml
<context:annotation-config/>
```
>指定扫描的包
```xml
<context:component-sacn base-package="com.xxx"/>
```
####属性注入
```java
@Component//注册到容器中
public class Superman {
    //自动注入 也可以写到set方法上面
    @Autowired
    private Bolt bolt;
    //自动注入
    @Autowired
    private Garfield garfield;

    public Superman() {
    }
    public Superman(Bolt bolt, Garfield garfield) {
        this.bolt = bolt;
        this.garfield = garfield;
    }
    public Bolt getBolt() {
        return bolt;
    }
    public void setBolt(Bolt bolt) {
        this.bolt = bolt;
    }
    public Garfield getGarfield() {
        return garfield;
    }
    public void setGarfield(Garfield garfield) {
        this.garfield = garfield;
    }
}
```
