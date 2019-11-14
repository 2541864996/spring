###有参构造器注入
- 下标
```xml
<!--下标注入-->
   <bean id="user" class="com.User">
        <constructor-arg index="0" ref="dog"/>
        <constructor-arg index="1" ref="cat"/>
    </bean>
```
- 类型
```xml
<!--类型注入-->
    <bean id="user" class="com.User">
        <constructor-arg type="com.Dog" ref="dog"/>
        <constructor-arg type="com.Cat" ref="cat"/>
    </bean>
</bean>
```
- 参数名
```xml
<!--参数名注入-->
    <bean id="user" class="com.User">
        <constructor-arg name="cat" ref="cat"/>
        <constructor-arg name="dog" ref="dog"/>
    </bean>
```
总结：在配置文件加载的时候，容器中管理的对象已经初始化了
ApplicationContext:就代表着Spring容器