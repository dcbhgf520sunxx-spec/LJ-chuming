package com.hzchum.pangu.redis.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
public class RedisLockerUtil {
   @Resource
   private RedissonClient redissonClient;

   public RLock lock(String lockKey) {
      RLock lock = this.redissonClient.getLock(lockKey);
      lock.lock();
      return lock;
   }

   public RLock lock(String lockKey, TimeUnit unit, long leaseTime) {
      RLock lock = this.redissonClient.getLock(lockKey);
      lock.lock(leaseTime, unit);
      return lock;
   }

   public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, Long leaseTime) {
      RLock lock = this.redissonClient.getLock(lockKey);

      try {
         return lock.tryLock(waitTime, leaseTime, unit);
      } catch (InterruptedException e) {
         return false;
      }
   }

   public RLock tryMultiLock(TimeUnit unit, long waitTime, Long leaseTime, String... lockKeys) {
      List<RLock> lockList = new ArrayList<>();

      for (String lockKey : lockKeys) {
         lockList.add(this.redissonClient.getLock(lockKey));
      }

      RLock lock = this.redissonClient.getMultiLock((RLock)lockList);

      try {
         lock.tryLock(waitTime, leaseTime, unit);
         return lock;
      } catch (InterruptedException e) {
         return null;
      }
   }

   public void unlock(String lockKey) {
      RLock lock = this.redissonClient.getLock(lockKey);
      if (Objects.nonNull(lock) && lock.isLocked() && lock.isHeldByCurrentThread()) {
         lock.unlock();
      }
   }

   public void unlock(RLock lock) {
      if (Objects.nonNull(lock) && lock.isLocked() && lock.isHeldByCurrentThread()) {
         lock.unlock();
      }
   }
}
