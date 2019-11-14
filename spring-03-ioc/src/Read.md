- 别名
>如果添加了别名，我们也可以使用这个别名获取这个对象
>如：
```xml<alias name="user" alias="newUser"/>
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
