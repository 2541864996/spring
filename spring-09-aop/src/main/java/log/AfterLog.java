package log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
//后置
public class AfterLog  implements AfterReturningAdvice {
    //returnValue:返回值
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了"+method.getName()+"返回的结果为："+returnValue);
    }
}
