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
##关于bean的配置
- 别名


##spring注解说明
- @Autowired:自动装配通过类型，名字
    如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
- @Nullable :字段标记了这个注解，说明这个字段可以为null;
- @Resource :自动装配通过名字，类型