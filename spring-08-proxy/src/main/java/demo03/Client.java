package demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Landlord landlord=new Landlord();
        //代理角色：现在没有
        ProxyInvocationHandler pih=new ProxyInvocationHandler();
        pih.setRenting(landlord);
        Renting prosy = (Renting) pih.getProsy();
        prosy.renting();
    }
}
