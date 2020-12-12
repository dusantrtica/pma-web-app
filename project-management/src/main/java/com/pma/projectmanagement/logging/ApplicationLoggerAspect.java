package com.pma.projectmanagement.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.pma.projectmanagement.controllers..*) || within(com.pma.projectmanagement.dao..*)")
    public void definePackagePointCuts() {
    }

    @Before("definePackagePointCuts()")
    public void logBefore(JoinPoint jp) {
        log.debug("\n\n\n");
        log.debug("************ Before Method Execution **************");
        jp.getSignature().getDeclaringTypeName();
    }

}
