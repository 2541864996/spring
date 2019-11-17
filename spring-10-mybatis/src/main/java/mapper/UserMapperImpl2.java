package mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    public List<User> selectUsers() {
        return getSqlSession().getMapper(UserMapper.class).selectUsers();
    }
}
