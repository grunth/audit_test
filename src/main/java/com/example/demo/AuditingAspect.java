package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AuditingAspect {

    @Pointcut("@annotation(Audited)")
    private void auditPointcut() {
    }

    @Before("auditPointcut()")
    public void setAuditFields(JoinPoint joinPoint) {
        Object[] methodArgs = joinPoint.getArgs();

        if (methodArgs.length > 0 && methodArgs[0] instanceof Product) {
            Product product = (Product) methodArgs[0];

            Date currentDate = new Date();
            String currentUsername = "user2";

            product.setCreatedAt(currentDate);
            product.setCreatedBy(currentUsername);
            product.setUpdatedAt(currentDate);
            product.setUpdatedBy(currentUsername);
        }
    }

}
