package com.hzchum.pangu.common.util;

import com.google.common.collect.Maps;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.CollectionUtils;

public class BeanUtil {
   public static void copy(Object source, Object target) {
      BeanUtils.copyProperties(source, target, "updateTime", "boolDeleteEnum", "version");
   }

   public static void copy(Object source, Object target, String... ignoreProperties) {
      BeanUtils.copyProperties(source, target, getIgnoreProperties(ignoreProperties));
   }

   public static <T> T copy(Object source, Class<T> clazz) {
      if (source == null) {
         return null;
      }

      T t = null;

      try {
         t = clazz.newInstance();
         BeanUtils.copyProperties(source, t, "updateTime", "boolDeleteEnum", "version");
      } catch (Exception e) {
         e.printStackTrace();
      }

      return t;
   }

   public static <T> T copy(Object source, Class<T> clazz, String... ignoreProperties) {
      if (source == null) {
         return null;
      }

      T t = null;

      try {
         t = clazz.newInstance();
         BeanUtils.copyProperties(source, t, getIgnoreProperties(ignoreProperties));
      } catch (Exception e) {
         e.printStackTrace();
      }

      return t;
   }

   private static String[] getIgnoreProperties(String[] ignoreProperties) {
      ArrayList<String> list = new ArrayList<>();
      list.add("updateTime");
      list.add("boolDeleteEnum");
      list.add("version");
      if (ignoreProperties != null && ignoreProperties.length > 0) {
         List<String> l = Arrays.asList(ignoreProperties);
         list.removeAll(l);
         list.addAll(l);
      }

      return list.toArray(new String[0]);
   }

   public static <T> List<T> copyList(List<Object> source, Class<T> clazz) {
      return CollectionUtils.isEmpty(source) ? null : source.stream().map(e -> copy(e, clazz)).collect(Collectors.toList());
   }

   public static <T> Map<String, Object> beanToMap(T bean) {
      Map<String, Object> map = Maps.newHashMap();
      if (bean != null) {
         BeanMap beanMap = BeanMap.create(bean);

         for (Object key : beanMap.keySet()) {
            map.put(key + "", beanMap.get(key));
         }
      }

      return map;
   }

   public static <T> T getRandomBean(Class<T> clazz) {
      try {
         T instance = clazz.newInstance();
         Field[] fields = clazz.getDeclaredFields();

         for (Field field : fields) {
            field.setAccessible(true);
            if (Long.class.equals(field.getType())) {
               field.set(instance, Long.valueOf(RandomUtil.random(4)));
            } else if (BigDecimal.class.equals(field.getType())) {
               field.set(instance, BigDecimal.valueOf(Double.parseDouble(RandomUtil.random(3))));
            } else if (String.class.equals(field.getType())) {
               field.set(instance, RandomUtil.randomString(3));
            } else if (Integer.class.equals(field.getType())) {
               field.set(instance, RandomUtil.random(3));
            } else if (LocalDateTime.class.equals(field.getType())) {
               field.set(instance, LocalDateTime.now());
            }
         }

         Class<? super T> superclass = clazz.getSuperclass();
         if (!superclass.equals(Object.class) && !superclass.getName().equals("com.hzchum.pangu.mybatisplus.pojo.BaseEntity")) {
            Object randomBean = getRandomBean(superclass);
            copy(randomBean, instance);
         }

         return instance;
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      }

      return null;
   }

   public static boolean checkObjAllFieldsIsNull(Object object) {
      if (null == object) {
         return true;
      }

      try {
         for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.get(object) != null && org.apache.commons.lang3.StringUtils.isNotBlank(f.get(object).toString())) {
               return false;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return true;
   }
}
