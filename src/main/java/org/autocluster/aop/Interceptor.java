package org.autocluster.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class Interceptor
{
    @Around("within(org.autocluster.Border+) && execution(public * *(..))")
    public Object interceptCatchers(final ProceedingJoinPoint joinPoint) throws Throwable
    {
        return AOPUtils.intercept(joinPoint);

    }


}
