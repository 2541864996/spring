import mapper.UsersMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import java.util.List;

public class UserMapperTest {
    @Test
    public void getUsers(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersMapper userMapperImpl = context.getBean("userMapperImpl", UsersMapper.class);
        List<User> users = userMapperImpl.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserAndAddUserAndDleteUserById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersMapper userMapperImpl = context.getBean("userMapperImpl", UsersMapper.class);
        userMapperImpl.getUserAndAddUserAndDleteUserById();
    }


}
