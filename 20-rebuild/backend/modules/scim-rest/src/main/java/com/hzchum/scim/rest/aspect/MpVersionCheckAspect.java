package com.hzchum.scim.rest.aspect;

import com.google.common.base.Preconditions;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MpVersionCheckAspect {
   @Pointcut(
      "(execution( * com.baomidou.mybatisplus.extension.service.IService.updateById(..)) || execution( * com.baomidou.mybatisplus.core.mapper.BaseMapper.updateById(..)))"
   )
   private void mpReturnCheckAnnotations() {
   }

   @AfterReturning(pointcut = "mpReturnCheckAnnotations()", returning = "rvt")
   public void afterReturnAdvice(Object rvt) {
      Preconditions.checkArgument(rvt != null, "操作失败,数据异常!!!");
      if (rvt instanceof Boolean) {
         Preconditions.checkArgument(rvt.equals(Boolean.TRUE), "数据已过期，请刷新重试!!!!");
      }

      if (rvt instanceof Integer) {
         Preconditions.checkArgument((Integer)rvt >= 1, "数据已过期，请刷新重试!!!!");
      }
   }
}
