package diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect//标注这是个切面
public class AnnotationPointCut {
    //在切入点方法前执行
    @Before("execution(* service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("=====在方法之前执行=====");
    }

    //在切入点方法结束后执行
    @After("execution(* service.UserServiceImpl.*(..))")
    public void later(){
        System.out.println("=====在方法之后执行=====");
    }

    @Around("execution(* service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pj){
        System.out.println("环绕前");
        Signature signature = pj.getSignature();
        System.out.println("签名:"+signature);
        System.out.println("环绕后");
    }

}
