package com.hzchum.scim.common.core.api.utils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BeanToMapUtils {
   public static Map<String, Object> beanToMap(Object obj) {
      Map<String, Object> map = new HashMap<>();
      convert(obj, "", map);
      return map;
   }

   private static void convert(Object obj, String parentKey, Map<String, Object> map) {
      if (obj != null && !(obj instanceof String) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof LocalDateTime)) {
         Class<?> clazz = obj.getClass();
         Field[] fields = clazz.getDeclaredFields();

         for (Field field : fields) {
            field.setAccessible(true);

            try {
               Object value = field.get(obj);
               String key = field.getName();
               convert(value, key, map);
            } catch (IllegalAccessException e) {
               e.printStackTrace();
            }
         }
      } else {
         map.put(parentKey, obj);
      }
   }
}
