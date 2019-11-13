package demo04;

public class Client {

    public static void main(String[] args) {
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        UserService userService=new UserServiceImpl2();
        //UserService userService=new UserServiceImpl();
        pih.setRenting(userService);
        UserService prosy = (UserService) pih.getProsy();
        prosy.add();
    }
}
