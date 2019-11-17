package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UsersMapper {
    //获取用户
    List<User> getUsers();

    //添加一个用户
    Integer addUser(User user);

    //删除一个用户
    Integer deleteUserById(@Param("id") int id);

    void getUserAndAddUserAndDleteUserById();
}
