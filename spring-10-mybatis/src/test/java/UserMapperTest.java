import mapper.UserMapper;
import mapper.UserMapperImpl2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import java.util.List;

public class UserMapperTest {
    @Test
    public void selectUsers(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        List<User> users = userMapperImpl.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectUser2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl2", UserMapper.class);
        List<User> users = userMapperImpl.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
