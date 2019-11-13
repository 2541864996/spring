package demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Renting renting;

    public void setRenting(Renting renting) {
        this.renting = renting;
    }

    //生成代理类
    public Object getProsy(){
        return  Proxy.newProxyInstance(this.getClass().getClassLoader(), renting.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object invoke = method.invoke(renting, objects);
        return invoke;
    }
}
