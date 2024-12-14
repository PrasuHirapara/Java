package Aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(ShoppingCart)")
    public void authenticationPointcut() {

    }

    @Pointcut("execution(* ShoppingCart.*(..))")
    public void authorizationPointcut() {

    }

    @Before("authenticationPointcut() && authorizationPointcut()")
    public void authenticate() {
        System.out.println("AuthenticationAspect.authenticate");
    }
}
