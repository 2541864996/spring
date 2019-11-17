##Spring整合Mybatis
1.导入相关jar包
- junit
- mybatis
- mysql数据库
- spring相关的
- aop织入
- mybatis-spring
```xml
    <dependencies>
        <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.18</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.3</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.1.RELEASE</version>
        </dependency>

        <!--spring操作数据库的话，还需要一个spring-jdbc-->
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.1.RELEASE</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.4</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.3</version>
        </dependency>

       <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
           <groupId>org.projectlombok</groupId>
           <artifactId>lombok</artifactId>
           <version>1.18.10</version>
        </dependency>
    </dependencies>
```
2.实体类
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;
}
```
3.实体类对应的接口
```java
public interface UserMapper {
    //查询所有用户
    List<User> selectUsers();
}
```
4.接口对应的Mapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="mapper.UsersMapper">
    <select id="selectUsers" resultType="User">
        select * from user;
    </select>
</mapper>
```
5.编写mybatis的配置文件,并把mapper.xml 交给mybatis
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <!--设置日志-->
        <setting name="logImpl" value="LOG4J"/>
    </settings>
    <!--设置类扫描 别名-->
    <typeAliases>
        <package name="pojo"/>
    </typeAliases>
    
    <mappers>
        <mapper resource="mapper/UserMapper.xml"/>
    </mappers>
</configuration>
```
6.创建mybatis和spring连接的配置文件(spring-mybatis.xml)
    
    1.使用spring-jdbc中DriverManagerDataSource 配置连接数据库中的一些信息(mybatis配置文件中就可以不用连接数据库了)
    2.<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!--绑定Mabits配置文件-->
        <property name="configLocation" value="mybatis-config.xml"/>
      </bean>
    3.<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
          <constructor-arg index="0" ref="sqlSessionFactory"/>
      </bean>
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--DataSource:使用Spring的数据源替换Mybatis的配置 c3p  dbcp druid
        我们这里使用Spring提供的JDBC
    -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </bean>
    <!--sqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!--绑定Mabits配置文件-->
        <property name="configLocation" value="mybatis-config.xml"/>
    </bean>

    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
        <constructor-arg index="0" ref="sqlSessionFactory"/>
    </bean>
</beans>
```
7.创建UserMapper的实现类UserMapperImpl
```java
public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectUsers() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUsers();
    }
}
```
8.创建spring的核心配置xml(applicationContext.xml),将实现类注册到spring容器
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

   <import resource="classpath:spring-mybatis.xml"/>

    <bean id="userMapperImpl" class="mapper.UserMapperImpl">
        <property name="sqlSession" ref="sqlSession"/>
    </bean>
</beans>
```
9.测试
```java
    @Test
    public void selectUsers(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        List<User> users = userMapperImpl.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
```

我们也可以简化实现类的代码
```java
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    public List<User> selectUsers() {
        return getSqlSession().getMapper(UserMapper.class).selectUsers();
    }
}
```
配置bean
```xml
<bean id="userMapperImpl2" class="mapper.UserMapperImpl2">
   <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
</bean>
```
测试
```java
    @Test
    public void selectUser2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl2", UserMapper.class);
        List<User> users = userMapperImpl.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }
```



