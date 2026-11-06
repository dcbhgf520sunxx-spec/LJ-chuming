package com.hzchum.pangu.common.util;

import java.util.HashMap;

public class LocalContext {
   private static ThreadLocal<HashMap<String, Object>> mapThreadLocal = new ThreadLocal() {
      @Override
      protected Object initialValue() {
         return new HashMap();
      }
   };

   public static void transArguments(HashMap<String, Object> paramMap) {
      mapThreadLocal.get().putAll(paramMap);
   }

   public static void addArgument(String key, Object obj) {
      mapThreadLocal.get().put(key, obj);
   }

   public static <V> V getArgument(String key, Class<V> clz) {
      Object value = mapThreadLocal.get().get(key);
      return value != null && clz.isInstance(value) ? clz.cast(value) : null;
   }

   public static void removeArgument(String key) {
      mapThreadLocal.get().remove(key);
   }

   public static void clear() {
      mapThreadLocal.remove();
   }
}
