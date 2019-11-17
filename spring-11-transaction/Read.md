###声明式事务
1.按照【spring-10-mybatis】中搭建环境

##事务
- 把一组业务当成一个业务来做；要么都成功，要么都失败！
- 事务在项目开发中，十分的重要，涉及到数据的一致性问题
- 确保完整性和一致性

事务ACID原则
- 原子性
- 一致性
- 隔离性
    多个业务可能操作同一资源，防止数据损坏
- 持久性
    事务一旦提交，无论系统发生什么问题，结果都不会被影响，被持久化的写到存储性中
    
###spring中的事务管理
- 声明式事务 ：AOP
- 编程式事务 ：需要在代码中，进行事务管理

1.在spring连接mybatis的配置文件中开启事务(mybatis-soring.xml)
```xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
   <property name="dataSource" ref="dataSource"/>
</bean>
```
2.配置事务通知(mybatis-soring.xml)
```xml
    <!--配置事务通知:-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <!--给那些事务配置事务-->
        <!--配置事务的传播特性： new propagation-->
        <tx:attributes>
            <tx:method name="add" propagation="REQUIRED"/>
            <tx:method name="delete" propagation="REQUIRED"/>
            <tx:method name="update" propagation="REQUIRED"/>
            <!--所有方法-->
            <tx:method name="*" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>
```
3.利用spring的aop将事务切入
```xml
    <!--配置事务切入-->
    <aop:config>
        <!--切入点-->
        <aop:pointcut id="txPointCut" expression="execution(* mapper.*.*(..))"/>
        <!--切入-->
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
    </aop:config>
```

4.接口
```xml
    //添加一个用户
    Integer addUser(User user);

    //删除一个用户
    Integer deleteUserById(@Param("id") int id);

    void getUserAndAddUserAndDleteUserById();
```
5.sql（错误的删除sql）
```xml
    <insert id="addUser" parameterType="User">
        insert into user (id,name,pwd) values (#{id},#{name},#{pwd});
    </insert>

    <delete id="deleteUserById" parameterType="_int">
        deletes from user where id=#{id}
    </delete>
```
6.实现类
```java
    public List<User> getUsers() {
        return sqlSession.getMapper(UsersMapper.class).getUsers();
    }

    public Integer addUser(User user) {
        return sqlSession.getMapper(UsersMapper.class).addUser(user);
    }

    public Integer deleteUserById(int id) {
        return sqlSession.getMapper(UsersMapper.class).deleteUserById(id);
    }

    public void getUserAndAddUserAndDleteUserById(){
        User user=new User(6,"艾希","213123");
        addUser(user);
        deleteUserById(5****);

    }
```
7.注册实现类到spring中
8.测试getUserAndAddUserAndDleteUserById方法
```java
    @Test
    public void getUserAndAddUserAndDleteUserById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersMapper userMapperImpl = context.getBean("userMapperImpl", UsersMapper.class);
        userMapperImpl.getUserAndAddUserAndDleteUserById();
    }
```

    由于开启了事务，其中getUserAndAddUserAndDleteUserById方法中的删除语句有问题，所以第一个插入语句就不会生效
为什么需要事务
- 如果不配置事务，可能存在数据提交不一致的情况
- 事务在项目开发中十分重要，涉及到数据的一致性和完整性问题