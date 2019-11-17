package mapper;

import org.mybatis.spring.SqlSessionTemplate;
import pojo.User;

import java.util.List;

public class UsersMapperImpl implements UsersMapper {
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

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
        deleteUserById(5);

    }
}
