package mapper;

import pojo.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    List<User> selectUsers();
}
