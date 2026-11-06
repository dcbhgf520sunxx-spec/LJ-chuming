package com.hzchum.scim.rest.aspect;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.UUIDUtil;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.pangu.redis.util.RedisLockerUtil;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SignerCheckAspect {
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private RedisLockerUtil redisLockerUtil;

   @Pointcut("@annotation(com.hzchum.pangu.common.valid.SignerCheck)")
   private void signerCheckAnnotations() {
   }

   @Around("signerCheckAnnotations()")
   public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
      Signature signature = joinPoint.getSignature();
      MethodSignature methodSignature = (MethodSignature)signature;
      Method targetMethod = methodSignature.getMethod();
      if (!targetMethod.isAnnotationPresent(SignerCheck.class)) {
         return joinPoint.proceed();
      }

      String key = null;
      AtomicLong hashcode = new AtomicLong();
      SignerCheck annotation = targetMethod.getAnnotation(SignerCheck.class);
      Object[] args = joinPoint.getArgs();
      String className = targetMethod.getDeclaringClass().getName();
      String methodName = targetMethod.getName();
      if (annotation.lockKey().length != 0) {
         this.parseKey(targetMethod, args, annotation.lockKey(), hashcode);
      }

      if (StringUtils.isNotBlank(annotation.constantKey())) {
         hashcode.addAndGet(annotation.constantKey().hashCode());
      }

      if (annotation.lockKey().length == 0 && StringUtils.isBlank(annotation.constantKey()) && !annotation.boolMethodAndClassName()) {
         List<Object> argList = Arrays.stream(args).filter(Objects::nonNull).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(argList)) {
            for (Object arg : argList) {
               if (arg.getClass().isArray()) {
                  for (Object o : (List)arg) {
                     Class<?> aClass = o.getClass();
                     AtomicLong atomicLong = this.signerCheck(aClass, o);
                     hashcode.addAndGet(atomicLong.get());
                  }
               }

               if (!arg.getClass().isArray()) {
                  if (!(arg instanceof Long) && !(arg instanceof Integer) && !(arg instanceof String)) {
                     AtomicLong atomicLong = this.signerCheck(arg.getClass(), arg);
                     hashcode.addAndGet(atomicLong.get());
                  } else {
                     hashcode.addAndGet(arg.toString().hashCode());
                  }
               }
            }
         }
      }

      Preconditions.checkArgument(annotation.boolMethodAndClassName() ? Boolean.TRUE : hashcode.get() != 0L, "请求参数异常!!!");
      if (annotation.boolMethodAndClassName()) {
         hashcode.addAndGet(className.hashCode());
         hashcode.addAndGet(methodName.hashCode());
         key = String.valueOf(hashcode.get());
      }

      if (StringUtils.isBlank(annotation.constantKey()) && !annotation.boolMethodAndClassName()) {
         hashcode.addAndGet(className.hashCode());
         hashcode.addAndGet(methodName.hashCode());
         key = String.valueOf(hashcode.get());
      }

      if (StringUtils.isNotBlank(annotation.constantKey())) {
         key = String.valueOf(hashcode.get());
      }

      if (!annotation.boolRedisson()) {
         String value = UUIDUtil.getUUID();

         try {
            Preconditions.checkArgument(this.redisUtils.setIfAbsentAndTime(key, value, annotation.timeout(), annotation.timeUnit()), annotation.message());
            return joinPoint.proceed();
         } finally {
            this.redisUtils.execute(key, value);
         }
      } else {
         try {
            Preconditions.checkArgument(
               this.redisLockerUtil.tryLock(key, annotation.timeUnit(), annotation.waitTime(), annotation.leaseTime()), annotation.message()
            );
            return joinPoint.proceed();
         } finally {
            this.redisLockerUtil.unlock(key);
         }
      }
   }

   private AtomicLong signerCheck(Class<?> clazz, Object arg) {
      AtomicLong hashCode = new AtomicLong();
      if (!clazz.getName().contains("springframework")) {
         AtomicLong atomicLong = this.buildFields(clazz.getDeclaredFields(), arg);
         AtomicLong superAtomicLong = this.buildFields(clazz.getSuperclass().getDeclaredFields(), arg);
         hashCode.addAndGet(atomicLong.get());
         hashCode.addAndGet(superAtomicLong.get());
      }

      return hashCode;
   }

   private Long setHashCode(Field[] fields, Object arg) throws IllegalAccessException {
      long hashCode = 0L;

      for (Field field : fields) {
         if (field != null) {
            field.setAccessible(true);
            if (field.getGenericType() instanceof ParameterizedType) {
               AtomicLong atomicInteger = this.buildFields(new Field[]{field}, arg);
               hashCode += atomicInteger.get();
            } else {
               Object fieldArg = field.get(arg);
               if (fieldArg != null) {
                  hashCode += fieldArg.toString().hashCode();
               }
            }
         }
      }

      return hashCode;
   }

   private AtomicLong buildFields(Field[] declaredFields, Object arg) {
      AtomicLong hashcode = new AtomicLong();
      Arrays.stream(declaredFields).forEach(filed -> {
         try {
            if (List.class.isAssignableFrom(filed.getType())) {
               Type type = filed.getGenericType();
               if (type instanceof ParameterizedType) {
                  if (!filed.isAccessible()) {
                     filed.setAccessible(true);
                  }

                  Object o;
                  try {
                     o = filed.get(arg);
                  } catch (IllegalAccessException e) {
                     throw new RuntimeException(e);
                  }

                  if (o != null) {
                     Class<?> clzz = filed.get(arg).getClass();
                     Method sizeMethod = clzz.getDeclaredMethod("size");
                     if (!sizeMethod.isAccessible()) {
                        sizeMethod.setAccessible(true);
                     }

                     int size = (Integer)sizeMethod.invoke(filed.get(arg));

                     for (int i = 0; i < size; i++) {
                        Method getMethod = clzz.getDeclaredMethod("get", int.class);
                        if (!getMethod.isAccessible()) {
                           getMethod.setAccessible(true);
                        }

                        Object invoke = getMethod.invoke(filed.get(arg), i);
                        Class<?> aClass1 = invoke.getClass();
                        if (aClass1.getName().contains("java.")) {
                           hashcode.addAndGet(invoke.hashCode());
                        } else {
                           Field[] fields = aClass1.getDeclaredFields();
                           hashcode.addAndGet(this.setHashCode(fields, invoke));
                        }
                     }
                  }
               }
            } else {
               hashcode.addAndGet(this.setHashCode(new Field[]{filed}, arg));
            }
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
      });
      return hashcode;
   }

   private void parseKey(Method method, Object[] argValueList, String[] keyElList, AtomicLong hashcode) {
      Map<String, Object> keyMap = new HashMap<>();
      LocalVariableTableParameterNameDiscoverer discover = new LocalVariableTableParameterNameDiscoverer();
      String[] parameterNames = discover.getParameterNames(method);
      Preconditions.checkArgument(parameterNames != null, "操作失败，方法参数异常!!!");

      for (String keyEl : keyElList) {
         String[] split = keyEl.split("\\.");
         Preconditions.checkArgument(split.length <= 2, "操作失败,el表达式格式错误!");
         String key = split[0].split("#")[1];
         String elValue = split[0].split("#")[1];
         if (split.length == 2) {
            elValue = split[1];
         }

         for (int i = 0; i < parameterNames.length; i++) {
            String parameterName = parameterNames[i];
            Object argValue = argValueList[i];
            if (parameterName.equals(key) && argValue != null) {
               keyMap.put(parameterName + "#" + elValue, argValue);
            }
         }
      }

      Preconditions.checkArgument(com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(keyMap), "操作失败,参数异常");
      keyMap.forEach((keyx, argValuex) -> {
         if (!(argValuex instanceof String) && !(argValuex instanceof Integer) && !(argValuex instanceof Long)) {
            String elValuex = keyx.split("#")[1];
            Class<?> aClass = argValuex.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            this.getDeclaredValue(hashcode, argValuex, elValuex, declaredFields);
            Field[] supperDeclaredFields = aClass.getSuperclass().getDeclaredFields();
            this.getDeclaredValue(hashcode, argValuex, elValuex, supperDeclaredFields);
         } else {
            hashcode.addAndGet(argValuex.toString().hashCode());
         }
      });
   }

   private void getDeclaredValue(AtomicLong hashcode, Object argValue, String elValue, Field[] supperDeclaredFields) {
      for (Field declaredField : supperDeclaredFields) {
         declaredField.setAccessible(true);
         String name = declaredField.getName();

         Object value;
         try {
            value = declaredField.get(argValue);
         } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
         }

         if (name.equals(elValue)) {
            hashcode.addAndGet(value.hashCode());
         }
      }
   }
}
