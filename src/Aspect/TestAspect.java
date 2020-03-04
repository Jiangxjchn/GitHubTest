package Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAspect {
    @Pointcut("execution( * Service.*.*(..))")
    private void modify(){}
    @Before("modify()")
    private  void checkSecurity(){
        System.out.println("---checkSecurity() ---");
    }
}
