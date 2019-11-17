###依赖注入(Set注入)
1.普通注入
```xml
<bean id="address" class="Address">
    <property name="str" value="成都。天府新区。华阳"/>
</bean>
```
2.bean注入
```xml
 <property name="address" ref="address"/>
```
3.数组
```xml
<!--数组-->
    <property name="books">
         <array>
            <value>语文书</value>
            <value>数学书</value>
            <value>英语书</value>
         </array>
    </property>
```
4.List集合
```xml
<!--list-->
   <property name="hobbys">
        <list>
            <value>玩游戏</value>
            <value>看电影</value>
            <value>唱歌</value>
        </list>
   </property>
```
5.Map
```xml
<!--map-->
<property name="card">
    <map>
        <entry key="学生卡" value="4185451"/>
        <entry key="身份证" value="15165165"/>
    </map>
</property>
```
6.p命名空间注入，可直接注入属性的值：property
```xml
 <!--p命名空间-->
 <bean id="dog" class="com.Dog" p:age="0.6" p:name="球球"/>
<!--使用前提
    在bean.xml引入 xmlns:p="http://www.springframework.org/schema/p"
    属性必须有set方法
-->
```
7.c命名空间注入,通过构造器注入，construct
```xml
<!--c命名空间-->
<bean id="hamster" class="Hamster" c:name="布丁"/>
<!--使用前提
    在bean.xml引入 xmlns:c="http://www.springframework.org/schema/c"
    类必须有有参构造器
-->
```