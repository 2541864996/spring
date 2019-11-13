package demo02;
//客户
public class Client {
    public static void main(String[] args) {
        UserServiceProxy proxy=new UserServiceProxy();
        proxy.setUserServiceImpl(new UserServiceImpl());
        proxy.add();
    }

}
