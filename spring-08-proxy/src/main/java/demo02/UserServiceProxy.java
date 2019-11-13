package demo02;

public class UserServiceProxy implements UserService{
    private UserServiceImpl userServiceImpl;

    public UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public void add() {
        userServiceImpl.add();
        log("add");
    }

    public void delete() {
        userServiceImpl.delete();
        log("delete");
    }

    public void update() {
        userServiceImpl.update();
        log("update");
    }

    public void select() {
        userServiceImpl.select();
        log("select");
    }

    //额外的日志功能
    private void log(String log){
        System.out.println("当前执行了"+log+"方法");
    }
}
