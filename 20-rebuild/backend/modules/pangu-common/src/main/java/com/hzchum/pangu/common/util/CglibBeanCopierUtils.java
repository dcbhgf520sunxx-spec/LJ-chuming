package com.hzchum.pangu.common.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.cglib.beans.BeanCopier;

public class CglibBeanCopierUtils {
   private static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

   private CglibBeanCopierUtils() {
   }

   public static void copyProperties(Object source, Object target) {
      String beanKey = generateKey(source.getClass(), target.getClass());
      BeanCopier copier;
      if (!beanCopierMap.containsKey(beanKey)) {
         copier = BeanCopier.create(source.getClass(), target.getClass(), false);
         beanCopierMap.put(beanKey, copier);
      } else {
         copier = beanCopierMap.get(beanKey);
      }

      copier.copy(source, target, null);
   }

   private static String generateKey(Class<?> class1, Class<?> class2) {
      return class1.toString() + class2.toString();
   }
}
