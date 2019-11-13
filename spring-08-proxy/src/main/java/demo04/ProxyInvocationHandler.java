package demo04;

import demo03.Renting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Object stating;

    public void setRenting(Object stating) {
        this.stating = stating;
    }

    //生成代理类
    public Object getProsy(){
        return  Proxy.newProxyInstance(this.getClass().getClassLoader(), stating.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //利用method来获取运行的方法名
        log(method.getName());
        //执行方法
        Object invoke = method.invoke(stating, objects);
        return invoke;
    }

    //额外插入的一个日志方法
    private void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }
}
