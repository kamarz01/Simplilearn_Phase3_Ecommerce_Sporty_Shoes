package com.sportyshoes.ecommerce.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Aspect
@Component
@Slf4j
public class AdminSessionValidator {

    @Pointcut("execution(* com.sportyshoes.ecommerce.controller.AdminController.*(..)) && !execution(* com.sportyshoes.ecommerce.controller.AdminController.Login(..))")
    public void methods(){}

    @Around("methods()")
    public Object checkSecurity(ProceedingJoinPoint pjp) throws Throwable{
        if (session().getAttribute("admin") != null) {
            log.info("Admin session found, continue...");
            return pjp.proceed();
        } else {
            log.info("No admin session found, redirecting to login...");
            return "admin-login";
        }
    }

    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession();
    }
}
