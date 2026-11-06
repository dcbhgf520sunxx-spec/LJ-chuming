package com.ljaps.rebuild.business;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.exception.CannotFindDataSourceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** The source company configuration has strict=true and only master: never silently route bidding to master. */
@Aspect
@Component
@Order(-100)
public class StrictDataSourceGuard {
    @Around("execution(public * com.hzchum..*(..)) && (@within(com.baomidou.dynamic.datasource.annotation.DS) || @annotation(com.baomidou.dynamic.datasource.annotation.DS))")
    public Object requireConfiguredSource(ProceedingJoinPoint point) throws Throwable {
        DS source=AnnotatedElementUtils.findMergedAnnotation(((MethodSignature)point.getSignature()).getMethod(),DS.class);
        if(source==null)source=AnnotatedElementUtils.findMergedAnnotation(AopUtils.getTargetClass(point.getTarget()),DS.class);
        if(source!=null && !"master".equals(source.value()))
            throw new CannotFindDataSourceException("dynamic-datasource could not find a datasource named "+source.value());
        return point.proceed();
    }
}
