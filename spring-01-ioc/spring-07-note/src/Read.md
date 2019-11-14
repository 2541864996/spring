实体类
```java
@Component
public class User {
    @Value("魏鑫茂")//属性注入
    private String name;
    @Autowired//自动装配
    private Dog dog;
}
```
配置类
```java
@Configuration//代表一个配置类，相当于一个bean.xml文件
@ComponentScan("com")//要扫描的包
@Import(Config2.class)//引入其他的配置类
public class Config1 {
    @Bean//方法名就是bean的id ，返回值就是bean的class
    public Dog dog(){
        return new Dog();
    }
    @Bean//方法名就是bean的id ，返回值就是bean的class
    public User user(){
        return new User();
    }
}

```
获取
```java
public static void main(String[] args) {
    ApplicationContext context=new AnnotationConfigApplicationContext(Config1.class);
    User user=(User) context.getBean("user");
    System.out.println(user);
}
```
利用AnnotationConfigApplicationContext来读取一个配置类

获得ApplicationContext容器