package Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
        System.out.println(jp.getSignature());
        System.out.println(Arrays.toString(jp.getArgs()));
        System.out.println("LoggingAspect.beforeLogger");
    }

    @After("execution(* ShoppingCart.checkout(..))")
    public void afterLogger() {
        System.out.println("LoggingAspect.afterLogger");
    }

    @Pointcut("execution(* ShoppingCart.quantity(..))")
    public void afterReturningPointcut() {

    }

    @AfterReturning(pointcut = "afterReturningPointcut()", returning = "retVal")
    public void afterReturning(int retVal) {
        System.out.println("LoggingAspect.afterReturning " + retVal);
    }
}
