package com.hzchum.scim.rest.runner.common;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Order(51)
@Component
public class ClassificationInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ClassificationInitRunner.class);
   @Resource
   private ClassificationService classificationService;
   @Resource
   private RedisTemplate redisTemplate;

   @Override
   public void run(String... args) throws Exception {
      this.redisTemplate.delete("wms-hash-classification-all");
      List<Classification> classifications = this.classificationService
         .list((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getBasicClass));
      if (CollectionUtil.isNotEmpty(classifications)) {
         if (ObjectUtil.isEmpty(classifications.get(0).getUserUpdateTime())) {
            this.classificationService.updateClassifyUpdateStatus();
            LocalDateTime now = LocalDateTime.now();
            this.classificationService.update((Wrapper<Classification>)new LambdaUpdateWrapper<Classification>().set(Classification::getUserUpdateTime, now));
            classifications.forEach(c -> c.setUserUpdateTime(now));
         }

         Map<String, Classification> collect = classifications.stream()
            .collect(Collectors.toMap(classification -> String.valueOf(classification.getId()), Function.identity()));
         this.redisTemplate.<String, Classification>opsForHash().putAll("wms-hash-classification-all", collect);
      }
   }

   public ClassificationInitRunner(final ClassificationService classificationService, final RedisTemplate redisTemplate) {
      this.classificationService = classificationService;
      this.redisTemplate = redisTemplate;
   }
}
