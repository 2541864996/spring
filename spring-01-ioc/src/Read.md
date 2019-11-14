###IOC
将类交于spring来创建管理
- 创建beans.xml文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

</beans>
```
- 将类放入容器中
```xml
    <bean id="user" class="com.User"/>
    <bean id="cat" class="com.Cat"/>
    <bean id="dog" class="com.Dog"/>
```
- 获取
```java
 public static void main(String[] args) {
    ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
    User user = context.getBean("user", User.class);
    Dog dog=context.getBean("dog", Dog.class);
    Cat cat=context.getBean("cat", Cat.class);
}
```