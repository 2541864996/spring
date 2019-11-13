package demo04;

public class UserServiceImpl2 implements UserService{
    @Override
    public void add() {
        System.out.println("user2增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("user2删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("user2修改了一个用户");
    }

    @Override
    public void select() {
        System.out.println("user2查询了一个用户");
    }
}
