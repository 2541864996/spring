1.单例模式(默认)，全部的User对象都只有一个
```xml
<!--单例 默认-->
<bean id="user" class="com.User" scope="singleton"/>
```
2.原型模式:每次从容器中取出的都是一个新的对象
```xml
<!--原型-->
<bean id="user" class="com.User" scope="prototype"/>
```
