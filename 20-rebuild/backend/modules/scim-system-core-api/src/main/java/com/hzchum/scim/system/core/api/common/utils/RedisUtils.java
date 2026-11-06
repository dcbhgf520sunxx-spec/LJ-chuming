package com.hzchum.scim.system.core.api.common.utils;

import io.lettuce.core.RedisException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public final class RedisUtils {
   @Autowired
   private RedisTemplate<String, Object> redisTemplate;
   private static final String REDIS_EXCEPTION_MESSAGE = "redis发生异常！";
   private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtils.class);

   public boolean expire(String key, long time) {
      try {
         if (time > 0L) {
            this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
         }

         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public long getExpire(String key) {
      return this.redisTemplate.getExpire(key, TimeUnit.SECONDS);
   }

   public boolean hasKey(String key) {
      try {
         return this.redisTemplate.hasKey(key);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public void del(String... key) {
      if (key != null && key.length > 0) {
         if (key.length == 1) {
            this.redisTemplate.delete(key[0]);
         } else {
            this.redisTemplate.delete((Collection<String>)CollectionUtils.arrayToList(key));
         }
      }
   }

   public Object get(String key) {
      return key == null ? null : this.redisTemplate.opsForValue().get(key);
   }

   public boolean set(String key, Object value) {
      try {
         this.redisTemplate.opsForValue().set(key, value);
         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public boolean set(String key, Object value, long time) {
      try {
         if (time > 0L) {
            this.redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
         } else {
            this.set(key, value);
         }

         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public long incr(String key, long delta) {
      if (delta < 0L) {
         throw new RedisException("递增因子必须大于0");
      } else {
         return this.redisTemplate.opsForValue().increment(key, delta);
      }
   }

   public long decr(String key, long delta) {
      if (delta < 0L) {
         throw new RedisException("递减因子必须大于0");
      } else {
         return this.redisTemplate.opsForValue().increment(key, -delta);
      }
   }

   public Object hget(String key, String item) {
      return this.redisTemplate.opsForHash().get(key, item);
   }

   public Map<Object, Object> hmget(String key) {
      return this.redisTemplate.<Object, Object>opsForHash().entries(key);
   }

   public boolean hmset(String key, Map<String, Object> map) {
      try {
         this.redisTemplate.<String, Object>opsForHash().putAll(key, map);
         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public boolean hmset(String key, Map<String, Object> map, long time) {
      try {
         this.redisTemplate.<String, Object>opsForHash().putAll(key, map);
         if (time > 0L) {
            this.expire(key, time);
         }

         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public boolean hset(String key, String item, Object value) {
      try {
         this.redisTemplate.<String, Object>opsForHash().put(key, item, value);
         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public boolean hset(String hashName, String key, Object value, long time) {
      try {
         this.redisTemplate.<String, Object>opsForHash().put(hashName, key, value);
         if (time > 0L) {
            this.expire(hashName, time);
         }

         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public void hdel(String key, Object... item) {
      this.redisTemplate.opsForHash().delete(key, item);
   }

   public boolean hHasKey(String hashName, String key) {
      return this.redisTemplate.opsForHash().hasKey(hashName, key);
   }

   public double hincr(String key, String item, double by) {
      return this.redisTemplate.opsForHash().increment(key, item, by);
   }

   public double hdecr(String key, String item, double by) {
      return this.redisTemplate.opsForHash().increment(key, item, -by);
   }

   public Set<Object> sGet(String key) {
      try {
         return this.redisTemplate.opsForSet().members(key);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return new HashSet<>();
      }
   }

   public boolean sHasKey(String key, Object value) {
      try {
         return this.redisTemplate.opsForSet().isMember(key, value);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public long sSet(String key, Object... values) {
      try {
         return this.redisTemplate.opsForSet().add(key, values);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return 0L;
      }
   }

   public long sSetAndTime(String key, long time, Object... values) {
      try {
         Long count = this.redisTemplate.opsForSet().add(key, values);
         if (time > 0L) {
            this.expire(key, time);
         }

         return count;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return 0L;
      }
   }

   public long sGetSetSize(String key) {
      try {
         return this.redisTemplate.opsForSet().size(key);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return 0L;
      }
   }

   public long setRemove(String key, Object... values) {
      try {
         return this.redisTemplate.opsForSet().remove(key, values);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return 0L;
      }
   }

   public List<Object> lGet(String key, long start, long end) {
      try {
         return this.redisTemplate.opsForList().range(key, start, end);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return new ArrayList<>();
      }
   }

   public long lGetListSize(String key) {
      try {
         return this.redisTemplate.opsForList().size(key);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return 0L;
      }
   }

   public Object lGetIndex(String key, long index) {
      try {
         return this.redisTemplate.opsForList().index(key, index);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return null;
      }
   }

   public boolean lSet(String key, Object value) {
      try {
         this.redisTemplate.opsForList().rightPush(key, value);
         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public boolean lSet(String key, Object value, long time) {
      try {
         this.redisTemplate.opsForList().rightPush(key, value);
         if (time > 0L) {
            this.expire(key, time);
         }

         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public boolean lSet(String key, List<Object> value) {
      try {
         this.redisTemplate.opsForList().rightPushAll(key, value);
         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public boolean lSet(String key, List<Object> value, long time) {
      try {
         this.redisTemplate.opsForList().rightPushAll(key, value);
         if (time > 0L) {
            this.expire(key, time);
         }

         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public boolean lUpdateIndex(String key, long index, Object value) {
      try {
         this.redisTemplate.opsForList().set(key, index, value);
         return true;
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return false;
      }
   }

   public long lRemove(String key, long count, Object value) {
      try {
         return this.redisTemplate.opsForList().remove(key, count, value);
      } catch (Exception e) {
         LOGGER.error("redis发生异常！", e);
         return 0L;
      }
   }

   public boolean setIfAbsentAndTime(String key, String value, long timeout, TimeUnit unit) {
      return this.redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
   }

   public void execute(String key, String value) {
      String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
      DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
      redisScript.setScriptText(script);
      redisScript.setResultType(Long.class);
      this.redisTemplate.execute(redisScript, Arrays.asList(key), value);
   }
}
